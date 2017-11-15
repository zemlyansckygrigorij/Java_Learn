package com.game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.IO.Input;
import com.graphics.Sprite;
import com.graphics.SpriteSheet;
import com.graphics.TextureAtlas;

public class Player extends Entity{
	
	public static final int SPRITE_SCALE = 16;
	public static final int SPRITES_PER_HEADING = 1;
	 
	
	private enum Heading{
		NORTH(0 * SPRITE_SCALE, 0 * SPRITE_SCALE,1 * SPRITE_SCALE,1 * SPRITE_SCALE),
		EAST(6 * SPRITE_SCALE, 0 * SPRITE_SCALE,1 * SPRITE_SCALE,1 * SPRITE_SCALE),
		SOUTH(4 * SPRITE_SCALE, 0 * SPRITE_SCALE,1 * SPRITE_SCALE,1 * SPRITE_SCALE),
		WEST(2 * SPRITE_SCALE, 0 * SPRITE_SCALE,1 * SPRITE_SCALE,1 * SPRITE_SCALE);
		
		private int x, y, h, w;
		
		Heading(int x,int y,int h,int w){
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;	
		}
		
		protected BufferedImage texture(TextureAtlas atlas){
			return atlas.cut(x, y, w, h);
		}
		
	}
	
	private Heading               heading;
	private Map<Heading,Sprite>   spriteMap;
	private float                 scale;
	private float                 speed ;
	
	public Player( float x, float y,float scale ,float speed ,TextureAtlas atlas) {
		super(EntityType.Player, x, y);
		
		heading = Heading.NORTH;
		spriteMap = new HashMap<Heading,Sprite>();
		this.scale =scale;
		this.speed =speed;
		
		for(Heading h: Heading.values()){
			SpriteSheet sheet = new SpriteSheet(h.texture(atlas),SPRITES_PER_HEADING,SPRITE_SCALE);
			Sprite sprite = new Sprite(sheet, scale);
			spriteMap.put(h, sprite);	
		}
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Input input) {
		// TODO Auto-generated method stub
		
		float newX = x;
		float newY = y;
		
		if(input.getKey(KeyEvent.VK_UP)){
			newY -= speed;
			heading = Heading.NORTH;
		}else if(input.getKey(KeyEvent.VK_RIGHT)){
			newX += speed;
			heading = Heading.EAST;
		}else if(input.getKey(KeyEvent.VK_DOWN)){
			newY += speed;
			heading = Heading.SOUTH;
		}else if(input.getKey(KeyEvent.VK_LEFT)){
			newX -= speed;
			heading = Heading.WEST;
		}
		//check out size game
		if(newX < 0) {
			newX =0;
		}else if(newX >= Game.WIDTH - SPRITE_SCALE * scale){
			newX = Game.WIDTH - SPRITE_SCALE * scale;
		}
		
		if(newY < 0) {
			newY = 0;
		}else if(newY >= Game.HEIGHT - SPRITE_SCALE * scale){
			newY = Game.HEIGHT - SPRITE_SCALE * scale;
		}
		x = newX;
		y = newY;
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		spriteMap.get(heading).render(g, x, y);
		
	}
	
}