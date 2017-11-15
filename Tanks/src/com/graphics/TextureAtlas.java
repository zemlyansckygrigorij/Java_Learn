package com.graphics;

import java.awt.image.BufferedImage;

import com.utils.ResourceLoader;

public class TextureAtlas {
	
	BufferedImage image;
	public TextureAtlas(String imageName){
		image = ResourceLoader.loadImage(imageName);
	}
	public BufferedImage cut(int x,int y, int w,int h){
		return image.getSubimage(x,y,w,h);
	}

}
