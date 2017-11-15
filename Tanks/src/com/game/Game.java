package com.game;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import level.Level;


import object.Display;

import com.IO.Input;
import com.graphics.Sprite;
import com.graphics.SpriteSheet;
import com.graphics.TextureAtlas;
import com.utils.Time;

public class Game implements Runnable{
	
	public static final int              WIDTH = 800;
	public static final int              HEIGHT = 600;
	public static final String           TITLE = "Tanks";
	
	public static final int              CLEAR_COLOR = 0xff000000;
	public static final int              NUM_BUFFERS =3;
	
	public static final float            UPRADE_RATE = 60.0f;
	public static final float            UPRADE_INTERVAL= Time.SECOND/UPRADE_RATE;
	public static final long             IDLE_TIME = 1;
	
	public static final String           ATLAS_FILE_NAME = "texture_atlas.png";
	
	private boolean                      running;
	private Thread                       gameThread;
	private Graphics2D                   graphics;
	private Input                        input;
	private TextureAtlas                 atlas;
	private Player                       player;
	
	
	public Game(){
		running = false;
		Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
		graphics = Display.getGraphic();
		input = new Input();
		Display.addInputListener(input);
		atlas = new TextureAtlas(ATLAS_FILE_NAME);
		player = new Player(300,300,2,3,atlas);
	
	}
	
	public synchronized void start(){
		if (running)return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	public synchronized void stop(){
		if (!running)return;
		
		running = false;
		
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cleanUp();
	}
	
	private void update(){
		player.update(input);	
	}
	
	private void render(){
		Display.clear();
		player.render(graphics);
		Display.swapBuffers();
	}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		int fps = 0;
		int upd = 0;
		int updl = 0;
		
		long count = 0;
		
		float delta = 0;
		long lastTime = Time.get();//
		
		while(running){
			long now = Time.get();
			long elapsedTime = now - lastTime;
			lastTime = now;
			
			count += elapsedTime;
			
			boolean render = false;
			delta += (elapsedTime/UPRADE_INTERVAL);
			while(delta > 1){
				update();
				upd++;
				delta--;
				if(render){
					updl++;
				}else{
				    render = true;
				}
			}
			if(render){
				render();
				fps++;
				
			}else{
				try {
					Thread.sleep(IDLE_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(count >= Time.SECOND){
				Display.setTitle(TITLE+"  || fps: "+fps+" || upd "+upd+" ||updl" +updl);
				upd =0;
				updl =0;
				fps =0;
				count=0;
			}
		}
		
	}
	
	private void cleanUp(){
		Display.destroy();
	}
	
}
