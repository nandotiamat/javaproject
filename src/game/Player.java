package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Player extends GameObject {

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int)x, 0, Game.WIDTH - 45);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 70);

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.white, 32, 32, 0.1f));

        collision();
    }

    public void render(Graphics g) {
        /*
         * HITBOX RENDER Graphics2D g2d = (Graphics2D) g; g.setColor(Color.red);
         * g2d.draw(getBounds());
         */
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.id == ID.BasicEnemy || tempObject.id == ID.FastEnemy || tempObject.id == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
}
