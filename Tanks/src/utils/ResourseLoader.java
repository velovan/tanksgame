package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
public class ResourseLoader {
	
	public static final String PATH = "res/";
	
	public static BufferedImage loadImage (String fileName){
		BufferedImage image = null;
		try{			
		   image = ImageIO.read(new File (PATH + fileName));
		}catch (IOException e){
			e.printStackTrace();
		 }
		return image;
	}
}*/

public class ResourseLoader {
	
	public static final String PATH = "res/";
	
	public static BufferedImage loadImage (String fileName){
		
		BufferedImage image = null;
		try{
		   image = ImageIO.read(new File(PATH + fileName));
		} catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		}
		
		return image;
	}
	
	
}
