
package firstgame;

import firstgame.FirstGame.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter {
    
     FirstGame game;
     Handler handler;
     private HUD hud;
     Random r = new Random();
    
    public Menu(FirstGame game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == FirstGame.STATE.Menu){
               
        //play button
        if(mouseOver(mx, my, 210, 150, 200, 64)){
       
        game.gameState = FirstGame.STATE.Select;
        return;                 
        }
        
        //help button
        if(mouseOver(mx, my, 210, 250, 200, 64)){
             game.gameState = FirstGame.STATE.Help;
            
        }        
        }
        
        //Back Button for Help
        if(game.gameState == FirstGame.STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = FirstGame.STATE.Menu;
                return;
            }
        
        }
    
                       
        if(game.gameState == FirstGame.STATE.Select){
               
        //play on normal difficulty button
        if(mouseOver(mx, my, 210, 150, 200, 64)){
        game.gameState = FirstGame.STATE.Game; 
        handler.object.clear();
        handler.addObject(new Player(FirstGame.WIDTH/2-32, FirstGame.HEIGHT/2-32, ID.Player, handler));
        
        game.diff = 0;
        
        for(int i = 0; i < 1; i++)
        handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH), r.nextInt(FirstGame.HEIGHT), ID.BasicEnemy, handler));                 
        }
               
        //Play on hard difficulty button 
        if(mouseOver(mx, my, 210, 250, 200, 64)){
        game.gameState = FirstGame.STATE.Game; 
        handler.object.clear();
        handler.addObject(new Player(FirstGame.WIDTH/2-32, FirstGame.HEIGHT/2-32, ID.Player, handler));
        
        game.diff = 1;
        
        for(int i = 0; i < 1; i++)
        handler.addObject(new BasicEnemy(r.nextInt(FirstGame.WIDTH), r.nextInt(FirstGame.HEIGHT), ID.BasicEnemy, handler)); 
        }
        }
        
              
        //Back Button for Select
        if(game.gameState == FirstGame.STATE.Select){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = FirstGame.STATE.Menu;
                return;
            }
        }
        
      
        //Return to Menu Button for Game Over
        if(game.gameState == FirstGame.STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = FirstGame.STATE.Menu;
                return;
            }
        
    }
        
        //Quit Button
        if(mouseOver(mx, my, 210, 350, 200, 64)){
             System.exit(1);
        }
        
        
    }

    
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false; 
        }else return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if(game.gameState == FirstGame.STATE.Menu){
        Font fnt = new Font("arial", 1, 50); //Font name, style, size
        Font fnt2 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("WRECKTANGLES", 115, 70);
        
        g.setFont(fnt2); 
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 280, 192);
                
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 280, 292);
              
        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit", 280, 392);
    } else if(game.gameState == FirstGame.STATE.Help){
        Font fnt = new Font("arial", 1, 50); //Font name, style, size
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help", 240, 70);
        
        //Text located in the help menu
        g.setFont(fnt3);
        g.drawString("Use arrow keys to move player and dodge enemies.", 60, 200);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 280, 392);
        
    }else if(game.gameState == FirstGame.STATE.End){
        Font fnt = new Font("arial", 1, 50); //Font name, style, size
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("GAME OVER", 170, 70);
        
        //Text located at the end screen
        g.setFont(fnt3);
        g.drawString("You died with a score of: " + hud.getScore(), 170, 200);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Main Menu", 235, 392);
        
    } else if(game.gameState == FirstGame.STATE.Select){
        Font fnt = new Font("arial", 1, 50); //Font name, style, size
        Font fnt2 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("SELECT DIFFICULTY", 75, 70);
        
        g.setFont(fnt2); 
        g.drawRect(210, 150, 200, 64);
        g.drawString("Normal", 260, 192);
                
        g.drawRect(210, 250, 200, 64);
        g.drawString("Hard", 280, 292);
              
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 280, 392);
    } 
        
    }
}
    


