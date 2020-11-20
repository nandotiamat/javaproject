package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics; 
import java.awt.Color;
import java.awt.Font;

public class Menu extends MouseAdapter {
    
    public void mousePressed(MouseEvent e) {
        if (Game.gameState == STATE.Menu) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/3 - 32, 200, 64)) {
                Game.gameState = STATE.Game;
            }
            else if (mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/3 + 100 - 32, 200, 64)) {
                System.exit(0);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font font = new Font("Arial", 1, 50);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Menu", Game.WIDTH/2 - 64, Game.HEIGHT/4);

        g.drawRect(Game.WIDTH/2 - 100, Game.HEIGHT/3 - 32, 200, 64);
        g.drawString("Play", Game.WIDTH/2 - 48, Game.HEIGHT/3 + 16);


        g.drawRect(Game.WIDTH/2 - 100, Game.HEIGHT/3 + 100 - 32 , 200, 64);
        g.drawString("Quit", Game.WIDTH/2 - 48, Game.HEIGHT/2 + 16);
    }
    
}
