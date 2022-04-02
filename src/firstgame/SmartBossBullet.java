
package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartBossBullet extends GameObject{
    
    private Handler handler;
    private GameObject player;
    
    public SmartBossBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        //cycles through objects ID to identify if our new player object for this class is in fact the player
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
        
     
    }
    
    public Rectangle getBounds(){
        return new Rectangle ((int)x, (int)y, 16, 16);
    }

    
    public void tick(){
        x += velX;
        y += velY;
        
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        
        velX = (-1/distance) * diffX;
        velY = (-1/distance) * diffY;
        
        if(y >= FirstGame.HEIGHT) handler.removeObject(this);
        
       // if(y <= 0 || y >= FirstGame.HEIGHT - 48) velY *= -1;
       // if(x <= 0 || x >= FirstGame.WIDTH - 16) velX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.09f, handler));
    }


    public void render(Graphics g) {
       g.setColor(Color.cyan);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    
    
    
}
