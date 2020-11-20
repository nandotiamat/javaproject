package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 5361307131680056775L;

    public static final int HEIGHT = 620, WIDTH = HEIGHT * 4 / 3;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu; 
    public static STATE gameState = STATE.Menu;

    public Game() {
        handler = new Handler();
        menu = new Menu(); 
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        new Window(WIDTH, HEIGHT, "ORCHI VS CAVALIERI!", this);
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2, ID.Player, handler));
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int clamp(int var, int min, int max) {
        if (var > max) 
            return var = max;
        else if (var < min) 
            return var = min;
        else return var;
    }

    //Game Loop part
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer+=1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() { 
        if (gameState == STATE.Game) {
            handler.tick();
            hud.tick();
            spawner.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        }
    }


    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (gameState == STATE.Game) {
            handler.render(g);
            hud.render(g);
        } else if (gameState == STATE.Menu) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
        
    };

}