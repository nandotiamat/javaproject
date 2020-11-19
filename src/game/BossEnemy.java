package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class BossEnemy extends GameObject {

    private Handler handler;
    private int timer;
    private int timer2;
    private BufferedImage img;
    private Random r = new Random();
    public static final int width = 200, height = 200;

    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = 2;
        velX = 0;
        timer = 100;
        timer2 = 100;
        try {
            img = ImageIO.read(new File("src/img/sarracino.jpeg"));
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
            if (timer2 == 0) {
                velX = 2;
            }
        } else {
            int spawn = r.nextInt(10);
            if (spawn == 0 ) handler.addObject(new BossEnemyBullet((int) (x + width/2), (int) (y+height/2), ID.BasicEnemy, handler));
        }
        
        if (x <= 0 || x > Game.WIDTH - width)
            velX *= -1;

    }

    public void render(Graphics g) {
        g.drawImage(img, (int) x, (int) y, width, height, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x ,(int) y, width, height);
    }
    
}
