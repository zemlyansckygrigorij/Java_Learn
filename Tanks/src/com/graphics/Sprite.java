package com.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.utils.Utils;

public class Sprite {
	
	private SpriteSheet             sheet;
	private float                   scale;
	private BufferedImage           image;
	public Sprite(SpriteSheet sheet,float scale){
		this.sheet = sheet;
		this.scale = scale;
	}
	public void render(Graphics2D g,float x,float y){
		image = sheet.getSprite(0);
		g.drawImage(sheet.getSprite(0), (int)(x), (int)(y),  (int)(image.getWidth()*scale),  (int)(image.getHeight()*scale),null);
	}
}






















