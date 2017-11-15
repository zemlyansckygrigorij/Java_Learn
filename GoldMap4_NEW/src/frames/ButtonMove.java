package frames;

import javax.swing.Icon;
import javax.swing.JButton;

import enums.MovingDirection;

public class ButtonMove extends JButton{
	private Icon image;
	public ButtonMove(){
		setSize();
	}
	public ButtonMove(String name){
		super(name);
		setSize();
	//this.setIcon(new Icon(""));
	}
	public ButtonMove(Icon image){
		this.image = image;
		super.setIcon(image);
		setSize();
	}
	public ButtonMove(MovingDirection movingDirection){
		this.image = movingDirection.getImage();
		super.setIcon(movingDirection.getImage());
		setSize();
	}
	private void setSize(){
		this.setSize(10, 10);
	}
	public void setIcon(Icon image){
		this.image = image;
		this.setIcon(image);
	}
	public Icon getIcon(){
		return image; 
	}
}
