package graphics;

import java.awt.image.BufferedImage;
/*
public class SprateSheet{
	
	BufferedImage sheet;
	public int sprite;
	public int spriteScale;
	public int spriteWidth;
	
	public SprateSheet(BufferedImage sheet, int sprite, int spriteScale) {
		this.sheet = sheet;
		this.sprite = sprite;
		this.spriteScale = spriteScale;
		this.spriteWidth = sheet.getHeight() / spriteScale;
	}
	
	public BufferedImage getSprite (int index) {
	    index = index % spriteScale;
	    int x = index % spriteWidth * spriteScale;
	    int y = index / spriteWidth * spriteScale;
	  return sheet.getSubimage(x, y, spriteScale, spriteScale);
	}
}*/

public class SprateSheet{
	
	public BufferedImage sheet;
	public int sprite;
	public int spriteScale;
	public int spriteWidth;
	
	public SprateSheet(BufferedImage sheet, int sprite, int spriteScale){
	        this.sheet = sheet;
	        this.sprite = sprite;
		this.spriteScale = spriteScale;
	this.spriteWidth = sheet.getWidth() / spriteScale;
        }
	
	public BufferedImage getSprite (int index){
		index = index % spriteScale;
		int x = index % spriteWidth * spriteScale;
		int y = index / spriteWidth * spriteScale;
		
	  return sheet.getSubimage(x, y, spriteScale, spriteScale);
	}
	
}
