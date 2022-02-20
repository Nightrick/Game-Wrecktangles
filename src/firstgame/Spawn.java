
package firstgame;

import java.util.Random;

public class Spawn {
    
    private Handler handler;
    private HUD hud;
    private Random r = new Random(); 
    
    private int scoreKeep = 0;
    
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
       
        if(scoreKeep >= 250){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
                                    
            if(hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));   
            }else if(hud.getLevel() == 4){
                handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.BasicEnemy, handler));         
            } else if(hud.getLevel() == 5){
                clearEnemies();
                handler.addObject(new Boss1((FirstGame.WIDTH / 2) - 48, -120, ID.Boss1, handler));
            } else if(hud.getLevel() == 11){
                clearEnemies();
                handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
            } else if(hud.getLevel() == 12){               
                handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
            } else if(hud.getLevel() == 13){               
                handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
            } else if(hud.getLevel() == 14){               
                handler.addObject(new FastEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.FastEnemy, handler));
            }
            
            
            
             /*  else if(hud.getLevel() == 5){
                handler.addObject(new SmartEnemy(r.nextInt(FirstGame.WIDTH - 50), r.nextInt(FirstGame.HEIGHT - 50), ID.SmartEnemy, handler));
            } */
}
}
    private void clearEnemies(){
        for(int i = handler.object.size() - 1; i > 0; i--){
            handler.object.remove(i);
        }
    }
    
}
