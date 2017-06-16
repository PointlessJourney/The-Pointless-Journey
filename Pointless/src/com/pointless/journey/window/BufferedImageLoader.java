package com.pointless.journey.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	//use this to load images
	public BufferedImage loadImage(String path){
		
		try {
			image = ImageIO.read(new File(path));//get image for any given path
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
		
	}

}
