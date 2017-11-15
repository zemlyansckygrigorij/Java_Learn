package objects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

public class ButtonFrameFirst extends JButton{
	private ButtonFrameFirst(){}
	Dimension dimension = new Dimension(100, 50);
	public ButtonFrameFirst(String name){
		super(name);
		//this.setBackground(Color.blue);
		//this.setBounds(10, 0, 100, 50);
		
		this.setPreferredSize(new Dimension(dimension));
		this.setMinimumSize(new Dimension(dimension));
		this.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		this.setHorizontalAlignment(SwingConstants.LEFT);
	//	this.setSize(150,450);
		//this.setPreferredSize(new Dimension(100,450));
	//	this.setMinimumSize(new Dimension(100,450));
	}

}
