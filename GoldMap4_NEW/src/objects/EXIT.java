package objects;

import enums.GameObjectType;

public class EXIT extends AbstractGameObject{

	public EXIT(Coordinates coordinates) {
		super(coordinates);
		setSetting();
	}
	public EXIT(int x,int y) {
		super( x, y);
		setSetting();
	}
	private void setSetting(){
		this.type = GameObjectType.EXIT;
		imageIcon= Images.EXIT;	
	}
}
