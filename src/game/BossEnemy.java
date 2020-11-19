package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class BossEnemy extends GameObject {

    private Handler handler;
    private int timer;
    private int timer2;
    private BufferedImage img;

    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = 2;
        velX = 0;
        timer = 100;
        timer2 = 100;
        System.out.println(System.getProperty("user.dir"));
        try {
            img = ImageIO.read(new File("src/game/sarracino.png"));
        } catch (Exception e) {
            System.out.println("Cant load img");
        }
    }
    

    public void tick() {
        x += velX;
        if (timer >= 0 ) {
            y += velY;
            timer--;
        }
        if (timer2 >= 0) {
            timer2--;
            if (timer2 == 0) velX = 2;
        }
        
        if (x <= 0 || x > Game.WIDTH - 64)
            velX *= -1;

        //handler.addObject(new Trail(x, y, ID.Trail, handler, Color.red, 64, 64, 0.1f));
    }

    public void render(Graphics g) {
        g.drawImage(img, (int) x, (int) y, 100, 100, null);
        //g.setColor(Color.red);
        //g.fillRect((int) x, (int) y, 64, 64);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x ,(int) y, 64, 64);
    }
    
}
