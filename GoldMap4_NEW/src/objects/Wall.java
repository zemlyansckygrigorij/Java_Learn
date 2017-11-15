package objects;

import enums.GameObjectType;

public class Wall extends AbstractGameObject{

	public Wall(Coordinates coordinates) {
		super(coordinates);
		// TODO Auto-generated constructor stub
	}
	public Wall(int x,int y) {
		super( x, y);
		setSetting();
	}
	private void setSetting(){
		this.type = GameObjectType.WALL;
		imageIcon= Images.WALL;	
	}

}
