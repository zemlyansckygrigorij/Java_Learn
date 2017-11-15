package enums;

import javax.swing.ImageIcon;

import objects.Images;



public enum MovingDirection {
	UP(Images.UP),
	DOWN(Images.DOWN),
	RIGHT(Images.RIGHT),
	LEFT(Images.LEFT),
	WAIT(Images.WAIT);
	
	private MovingDirection(String path){
		this.image = new ImageIcon(path);
		
	}
	private MovingDirection(ImageIcon image){
		this.image = image;
		
	}
	private ImageIcon image;
	private int x;
	private int y;
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	public ImageIcon getImage(){
		return image;
	}
	
}
