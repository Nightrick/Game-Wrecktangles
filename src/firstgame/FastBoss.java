
package firstgame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class FastBoss extends GameObject{
    
    private Handler handler;
    Random r = new Random();
    
    private int timer = 60; 
    private int timer2 = 50; 
    
    public FastBoss (int x, int y, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 0;
        velY = 2; 
    }
    
    public Rectangle getBounds(){
        return new Rectangle ((int)x, (int)y, 96, 96);
    }

    
    public void tick(){
        x += velX;
        y += velY;
        
        if(timer <= 0) velY = 0;
        else timer--; 
        
        if(timer <= 0) timer2--;
        if(timer2 <= 0) {
            if(velX == 0) velX = 5;
            int spawn = r.nextInt(10);
            if(spawn == 0) handler.addObject(new FastBossBullet((int)x + 48, (int)y + 48, ID.FastEnemy, handler));
        }
        
        //if(y <= 0 || y >= FirstGame.HEIGHT - 48) velY *= -1;
        if(x <= 0 || x >= FirstGame.WIDTH - 108) velX *= -1;
        
       handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 96, 96, 0.09f, handler));
    }


    public void render(Graphics g) {
       g.setColor(Color.magenta);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    
    
    
}
