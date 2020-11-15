package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    
    public static int HEALTH = 100;

    private int greenValue = 255;
    private int level = 1;
    private int score = 0;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(32, 32, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(32, 32, HEALTH*2, 32);
        g.setColor(Color.white);
        g.drawRect(32, 32, 200, 32);
        g.drawString("Score: " + score, 32, 80);
        g.drawString("Level: " + level, 32, 94);
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
}
