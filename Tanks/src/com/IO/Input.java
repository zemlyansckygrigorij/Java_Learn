package com.IO;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Input extends JComponent{
	//array pressed button
	private boolean[] map;
	
	public Input(){
		map = new boolean[256] ;
		
		for(int i =0;i<map.length;i++){
			
			final int KEY_CODE= i;
			
			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,false), i*2);
			getActionMap().put(i*2, new AbstractAction(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					map[KEY_CODE]= true;
					
				}});
			
			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,true), i*2+1);
			getActionMap().put(i*2+1, new AbstractAction(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					map[KEY_CODE]= false;
					
				}});
		}
		
	}
	//get array pressed button
	public boolean[] getMap(){
		return Arrays.copyOf(map, map.length);
	}
	//check  pressed button
	public boolean getKey(int keyCode){
		return map[keyCode];
		
	}


}





























