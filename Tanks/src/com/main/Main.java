package com.main;


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import com.game.Game;

import object.Display;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game tanks = new Game();
		tanks.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Display.create( 800,600, "tanks",0xff00ff00,3);
		
		Timer t = new Timer(1000/60,new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Display.clear();
			//	Display.render();
				Display.swapBuffers();
				
			}});
		t.setRepeats(true);
		t.start();*/

	}

}
