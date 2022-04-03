package firstgame;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private FirstGame game;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, FirstGame game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (game.diff == 0) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                } else if (hud.getLevel() == 11) {
                    clearEnemies();
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 12) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 13) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 14) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 15) {
                    clearEnemies();
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                } else if (hud.getLevel() == 21) {
                    clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 24) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 25) {
                    clearEnemies();
                    handler.addObject(new SmartBoss((FirstGame.WIDTH / 2) - 48, -120, ID.SmartBoss, handler));
                } else if (hud.getLevel() == 31) {
                    clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 32) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 33) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 34) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 35) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                } else if (hud.getLevel() == 41) {
                    clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 42) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 43) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 44) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 45) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                    handler.addObject(new SmartBoss((FirstGame.WIDTH / 2) - 48, -120, ID.SmartBoss, handler));
                }
            } else if(game.diff == 1){
                if (hud.getLevel() == 2) {
                    handler.addObject(new HardEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new HardEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new HardEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                } else if (hud.getLevel() == 11) {
                    clearEnemies();
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 12) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 13) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 14) {
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 15) {
                    clearEnemies();
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                } else if (hud.getLevel() == 21) {
                    clearEnemies();
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 24) {
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 25) {
                    clearEnemies();
                    handler.addObject(new SmartBoss((FirstGame.WIDTH / 2) - 48, -120, ID.SmartBoss, handler));
                } else if (hud.getLevel() == 31) {
                    clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 32) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 33) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 34) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 35) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                } else if (hud.getLevel() == 41) {
                    clearEnemies();
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 42) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 43) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 44) {
                    handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 45) {
                    clearEnemies();
                    handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
                    handler.addObject(new FastBoss((FirstGame.WIDTH / 2) - 48, -120, ID.FastBoss, handler));
                    handler.addObject(new SmartBoss((FirstGame.WIDTH / 2) - 48, -120, ID.SmartBoss, handler));
                }
            }

            /*  else if(hud.getLevel() == 5){
                handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
            } */
        }
    }

    private void clearEnemies() {
        for (int i = handler.object.size() - 1; i > 0; i--) {
            handler.object.remove(i);
        }
    }

}
