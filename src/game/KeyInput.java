package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    private boolean keyDown[] = new boolean[4]; //0 UP, 1 DOWN, 2 LEFT, 3 RIGHT

    public KeyInput(Handler handler) {
        this.handler = handler;
        for (int i=0; i<3; i++){
            keyDown[i] = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.id == ID.Player) {
                //Key events for Player
                if (key == KeyEvent.VK_W) {
                    if (keyDown[1]) {
                        tempObject.setVelY(0);
                    }
                    else  {
                        tempObject.setVelY(-5);
                    }
                    keyDown[0] = true;
                }                
                
                if (key == KeyEvent.VK_S) {
                    if (keyDown[0]) {
                        tempObject.setVelY(0);
                    }
                    else 
                        tempObject.setVelY(5);
                    keyDown[1] = true;
                }

                if (key == KeyEvent.VK_A) {
                    if (keyDown[3]) {
                        tempObject.setVelX(0);
                    }
                    else 
                        tempObject.setVelX(-5);
                    keyDown[2] = true;
                }
            
                if (key == KeyEvent.VK_D) {
                    if (keyDown[2]) {
                        tempObject.setVelX(0);
                    }
                    else 
                        tempObject.setVelX(5);
                    keyDown[3] = true;
                }
            }
        }
        if ( key == KeyEvent.VK_ESCAPE ) {
            if (Game.gameState == STATE.Menu) {
                Game.gameState = STATE.Game;
            }
            else {
                Game.gameState = STATE.Menu;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.id == ID.Player) {
                //Key events for Player
                if (key == KeyEvent.VK_W) {
                    if (keyDown[1]) {
                        tempObject.setVelY(5);
                    }
                    else {
                        tempObject.setVelY(0);
                    }
                    keyDown[0] = false;
                }

                if (key == KeyEvent.VK_S) {
                    if (keyDown[0]) {
                        tempObject.setVelY(-5);
                    }
                    else 
                        tempObject.setVelY(0);
                    keyDown[1] = false;
                }

                if (key == KeyEvent.VK_A) {
                    if (keyDown[3]) {
                        tempObject.setVelX(5);
                    }
                    else 
                        tempObject.setVelX(0);
                    keyDown[2] = false;
                }
                
                if (key == KeyEvent.VK_D) {
                    if (keyDown[2]) {
                        tempObject.setVelX(-5);
                    }
                    else 
                        tempObject.setVelX(0);
                    keyDown[3] = false;
                }
                
            }
        }
    }

}
