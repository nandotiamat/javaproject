package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    
    public static int HEALTH = 100;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(32, 32, 200, 32);
        g.setColor(Color.green);
        g.fillRect(32, 32, HEALTH*2, 32);
        g.setColor(Color.white);
        g.drawRect(32, 32, 200, 32);
    }
}
