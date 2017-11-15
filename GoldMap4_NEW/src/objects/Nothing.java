package objects;

import enums.GameObjectType;

public class Nothing extends AbstractGameObject{

	public Nothing(Coordinates coordinates) {
		super(coordinates);
		setSetting();
	}
	public Nothing(int x,int y) {
		super( x, y);
		setSetting();
	}
	private void setSetting(){
		this.type = GameObjectType.NOTHING;
		imageIcon= Images.NOTHING;	
	}
}
