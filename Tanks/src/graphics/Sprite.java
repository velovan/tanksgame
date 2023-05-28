package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/*
public class Sprite{

   private SprateSheet sheet;
   private float       scale;
   
   public Sprite (SprateSheet sheet, float scale{
	    this.sheet = sheet;
	    this.scale = scale;
   }

   public void render (Graphics2D g, float x, float y){ 
	    BufferedImage image = sheet.getSprite(0);
	    g.drawImage(sheet.getSprite(0),(int)(x), (int)(y),(int)(image.getWidth()*scale), (int) (image.getHeight() * scale),null);   
   }
}*/
 
public class Sprite{
	
	private SprateSheet sheet;
	private float scale;
	
	public Sprite(SprateSheet sheet, float scale){
	    this.sheet = sheet;
 	    this.scale =scale;
	}
	
	public void render (Graphics2D g, float x, float y){
	    BufferedImage image = sheet.getSprite(0);
	    g.drawImage(sheet.getSprite(0), (int)(x), (int) (y), (int)(image.getWidth() * scale), (int)(image.getHeight() * scale), null);	
	}
	
}
