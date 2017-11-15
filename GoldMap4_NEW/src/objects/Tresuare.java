package objects;

import enums.GameObjectType;

public class Tresuare extends AbstractGameObject{

	public Tresuare(Coordinates coordinates) {
		super(coordinates);
		setSetting();
	}
	public Tresuare(int x,int y) {
		super( x, y);
		setSetting();
	}
	private void setSetting(){
		this.type = GameObjectType.TREASURE;
		imageIcon= Images.TRESUARE;	
	}
}