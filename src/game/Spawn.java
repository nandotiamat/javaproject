package game;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    private void spawnBasicEnemy(int n) {
        for (int i = 0 ; i < n; i++) 
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - BasicEnemy.width), r.nextInt(Game.HEIGHT - BasicEnemy.height), ID.BasicEnemy, handler));
    }

    private void spawnFastEnemy(int n) {
        for (int i = 0; i<n; i++)
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - FastEnemy.width), r.nextInt(Game.HEIGHT - FastEnemy.height), ID.FastEnemy, handler));
    }

    private void spawnSmartEnemy(int n) {
        for (int i = 0; i<n; i++) 
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - SmartEnemy.width), r.nextInt(Game.HEIGHT - SmartEnemy.height), ID.SmartEnemy, handler));
    }

    private void spawnBossEnemy(int n) {
        for (int i = 0; i<n; i++) 
            handler.addObject(new BossEnemy(Game.WIDTH/2 - BossEnemy.width, - BossEnemy.height, ID.BossEnemy, handler));
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            
            if (hud.getLevel() == 2) {
                spawnBasicEnemy(1);
            }
            else if (hud.getLevel() == 3) {
                spawnFastEnemy(2); 
            }
            else if (hud.getLevel() == 4) {
                spawnSmartEnemy(1);
            }
            else if (hud.getLevel() == 5) {
                spawnBasicEnemy(2);
            }
            else if (hud.getLevel() == 6) {
                spawnSmartEnemy(1);
            }
            else if (hud.getLevel() == 7) {
                spawnFastEnemy(1);
                spawnSmartEnemy(2);
            }
            else if (hud.getLevel() == 8) {
                spawnBasicEnemy(1); 
            }
            else if (hud.getLevel() == 9) {
                spawnSmartEnemy(2);
            }
            else if (hud.getLevel() == 10) {
                handler.clearEnemies();
                spawnBossEnemy(1);
            }
            
        }
    }
}
