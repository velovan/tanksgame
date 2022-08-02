package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.security.acl.LastOwnerException;

import javax.xml.ws.Dispatch;

import IO.Input;
import display.Display;
import graphics.SprateSheet;
import graphics.Sprite;
import graphics.TextureAtlas;
import utils.Time;

public class Game implements Runnable{

	//int width, int height, String title, int _clearColor, int numBuffers
	
	public static final int    WIDTH           = 800;
	public static final int    HEIGHT          = 600;
	public static final String TITLE           = "Tanks";
	public static final int    CLEAR_COLOR     = 0xff000000;
	public static final int    NUM_BUFFERS     = 3;
	
	public static final float  UPDATE_RATE     = 60.0f;
	public static final float  UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
	public static final long   IDLE_TIME       = 1;
	
	public static final String ATLAS_FILE_NAME = "texture_atlas.png";
	
	private boolean            running;
	private Thread             gameThread;
	private Graphics2D         graphics;
	private Input              input;
	private TextureAtlas       atlas;
	
	//private SprateSheet        sheet;
	//private Sprite             sprite;
	
	private Player             player;
	
    public Game(){	
    	running = false;
    	Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
    	graphics = Display.getGraphics();
    			
    	input = new Input();
    	Display.addInputListener(input);
    	
    	atlas = new TextureAtlas(ATLAS_FILE_NAME);
      
        //sheet = new SprateSheet(atlas.cut(1 * 16,9*16,19,19), 2 , 16);
    	//sprite = new Sprite (sheet, 1);
    	player = new Player(300, 300,  2, 4, atlas);
    }
    
    public synchronized void start(){
    	if(running){
    	  return;
    	}
    	running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public synchronized void stop(){
        if(!running){
           return;
        }
        running = false;
        try{
	     gameThread.join();
		} catch (InterruptedException e) {
	     // TODO Auto-generated catch block
             e.printStackTrace();
		}	
	}
	
	private void update(){	
		player.update(input);
	}
	
	private void render(){
		Display.clear();
	//sprite.render(graphics, x, y);
	
		player.render(graphics);

		Display.swapBuffers();
	}
	
	public void run() {	
	        int fps  = 0;
		int upd  = 0;
		int updl = 0;
		
		float delta1 = 0;
		
		long count = 0;
		long lastTime = Time.get();
		
		while(running){	
	    	long now = Time.get();
			long elapsedTime = now - lastTime;
			lastTime = now;
	    	count += elapsedTime;
			delta1 += (elapsedTime / UPDATE_INTERVAL);
			boolean render1 = false;
			
			while(delta1 > 1){
				
				update();
				upd++; //1
				delta1--;
				
				if(render1 ){
					updl++; //1
				} else {
				  render1 = true ;
				}
			}
			
			if(render1 ){
				render();
				fps++; //1
			}else{
				
				try {
					Thread.sleep(IDLE_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(count >= Time.SECOND){
				Display.setTitle(TITLE + "|| Fps: " + fps + "| Upd: " + upd + "| Updl:" +updl);
				upd   = 0;
				fps   = 0;
				updl  = 0;
				count = 0;
			}
		}
	}	
		
	private void cleanUp(){
		Display.destroy();
	}
}
