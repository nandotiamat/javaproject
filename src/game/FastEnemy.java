package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class FastEnemy extends GameObject {

    private Handler handler;
    public static final int width = 16;
    public static final int height = 16;
    
    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 2;
        velY = 8;
    }

    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y > Game.HEIGHT - 2*height)
            velY *= -1;
        if (x <= 0 || x > Game.WIDTH - 2*width)
            velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.blue, width, height, 0.08f));
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
}
