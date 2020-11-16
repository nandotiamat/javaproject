package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i=0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);
                break;
            }
        }
        this.velX=0;
        this.velY=0;

    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt(Math.pow(diffX+8, 2) + Math.pow(diffY+8, 2));
        System.out.println("X: " + diffX + "Y: " + diffY + "Distance: " + distance );
        velX = (-1.0f/distance) * diffX;
        velY = (-1.0f/distance) * diffY;

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.yellow, 16, 16, 0.1f));
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 16, 16);
    }
    
}