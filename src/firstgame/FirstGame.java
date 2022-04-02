
package firstgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class FirstGame extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 2L;
     
     
    //These dimensions are used to create a nice aspect ratio 
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; 
    
    private Thread thread;
    private boolean running = false;
    
    public static boolean paused = false;
    public int diff;
    //If diff = 0, this triggers a cannot find symbol error in Menu? 
    
    //for int diff, 0 = normal, 1 = hard
    
    private Random r; 
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    public enum STATE {
      Menu,
      Help,
      Select,
      Game,
      End,
    };
    
    public STATE gameState = STATE.Menu;
    
    
    public FirstGame(){
        
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        
        new Window(WIDTH, HEIGHT, "David's First Game!", this);
        
        
        spawner = new Spawn(handler, hud);
        r = new Random();
        
        if(gameState == STATE.Game){       
        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
        
        for(int i = 0; i < 1; i++)
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler)); 
        }else{
            for(int i = 0; i < 20; i++){
                handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
            }
        }
    }
     
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Below is the game loop. This is essential for running the game. 
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime(); 
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--; 
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        
        
        if(gameState == STATE.Game){
            if(!paused){
             
        hud.tick();
        spawner.tick();
        handler.tick();
        
        if(HUD.HEALTH <= 0){
            HUD.HEALTH = 100;
            handler.object.clear();
            gameState = STATE.End;
            for(int i = 0; i < 20; i++){
                handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
            }
        }
        }
            
        
    }else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Help || gameState == STATE.Select){
        menu.tick();
        handler.tick();
    }
    } 
    
    public void changeState(){
        gameState = STATE.Game;
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        if(paused){
            g.setColor(Color.white);
            g.drawString("PAUSED", 290, 220);
        }
        
        if(gameState == STATE.Game){        
        hud.render(g);
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
        menu.render(g);
        }
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float var, float min, float max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else 
            return var;
    }


    public static void main(String[] args) {
       new FirstGame();
        
    }
    
}



