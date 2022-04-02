
package firstgame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class FastBossBullet extends GameObject{
    
    private Handler handler;
    Random r = new Random();
    
    public FastBossBullet (int x, int y, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = (r.nextInt(9 - -9) + -9);
        velY = 9; 
    }
    
    public Rectangle getBounds(){
        return new Rectangle ((int)x, (int)y, 16, 16);
    }

    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y >= FirstGame.HEIGHT) handler.removeObject(this);
        
        //if(y <= 0 || y >= FirstGame.HEIGHT - 48) velY *= -1;
       // if(x <= 0 || x >= FirstGame.WIDTH - 16) velX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16, 16, 0.09f, handler));
    }


    public void render(Graphics g) {
       g.setColor(Color.magenta);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    
    
    
}
