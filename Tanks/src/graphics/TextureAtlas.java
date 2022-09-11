package graphics;

import java.awt.image.BufferedImage;

import utils.ResourseLoader;
/*
public class TextureAtlas {
	
	BufferedImage image;
	
	public TextureAtlas(String imageName) {
	        image = ResourseLoader.loadImage(imageName);
	}
	
	public BufferedImage cut (int x, int y, int w, int h) {
	        return image.getSubimage(x, y, w, h);
	}
}
*/

   public class TextureAtlas {
	   
	 BufferedImage image;
	   
	 public TextureAtlas(String imageName) {
	      image = ResourseLoader.loadImage(imageName);
	 }
	   
	 public BufferedImage cut (int x, int y, int w, int h){
              return image.getSubimage(x, y, w, h);
	 }
	   
   }
