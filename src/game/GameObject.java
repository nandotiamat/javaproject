package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    protected int x, y;
    protected int velX, velY;
    protected ID id;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract Rectangle getBounds();

    //setters
    public void setX(int x) {
        this.x =  x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }   
    public void setVelY(int velY) {
        this.velY = velY;
    }

    //getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ID getId() {
        return id;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }

}
