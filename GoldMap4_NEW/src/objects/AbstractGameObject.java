package objects;

import javax.swing.ImageIcon;

import enums.GameObjectType;

public class AbstractGameObject {
	protected Coordinates coordinates;
	protected ImageIcon imageIcon;
	protected GameObjectType type;
	
	public AbstractGameObject(Coordinates coordinates){
		this.coordinates = coordinates;
	}
	public AbstractGameObject(int x,int y){
		Coordinates coordinates =new  Coordinates(x, y);
		this.coordinates = coordinates;
	}
	public Coordinates getCoordinates(){
		return coordinates;
	}
	
	public ImageIcon getImageIcon(){
		return this.imageIcon;
	}
	
	public int getX(){
		return coordinates.getX();
	}
	
	public int getY(){
		return coordinates.getY();
	}

}
