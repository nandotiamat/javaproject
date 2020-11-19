package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class BossEnemyBullet extends GameObject {

    private Handler handler;
    private Random r = new Random();
    public BossEnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(10) - 5);
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;
        if (y >= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.cyan, 16, 16, 0.1f));
    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x ,(int) y, 16, 16);
    }
    
}
