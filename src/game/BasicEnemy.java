package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = 5;
        velX = 5;
    }

    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y > Game.HEIGHT - 32)
            velY *= -1;
        if (x <= 0 || x > Game.WIDTH - 32)
            velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.red, 16, 16, 0.1f));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x ,(int) y, 16, 16);
    }
    
}
