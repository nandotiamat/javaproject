package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    protected float x, y;
    protected float velX, velY;
    protected ID id;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract Rectangle getBounds();

    //setters
    public void setX(float x) {
        this.x =  x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }   
    public void setVelY(float velY) {
        this.velY = velY;
    }

    //getters
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public ID getId() {
        return id;
    }
    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }

}
