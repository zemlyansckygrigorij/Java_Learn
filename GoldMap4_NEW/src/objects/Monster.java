package objects;

import enums.GameObjectType;

public class Monster extends AbstractGameObject{

	public Monster(Coordinates coordinates) {
		super(coordinates);
		setSetting();
	}
	public Monster(int x,int y) {
		super( x, y);
		setSetting();
	}
	private void setSetting(){
		this.type = GameObjectType.MONSTER;
		imageIcon= Images.MONSTR;	
	}
	
	public void setCoordinates(Coordinates coordinates){
		this.coordinates = coordinates;
	}
	
	public void setX(int x){
		this.coordinates.setX(x);
	}
	public void setY(int y){
		this.coordinates.setY(y);
	}
	
	public void setXY(int x,int y){
		this.coordinates.setX(x);
		this.coordinates.setY(y);
	 }
}