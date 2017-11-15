package notepad;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FrameHelp extends JFrame{
	
    JLabel label1 = new JLabel("Данная программа разработана");
    JLabel label2 = new JLabel("Землянским Григорием в 2016г.");
    JLabel label3 = new JLabel("в качестве учебного экземпляра !!!");
    JLabel label4 = new JLabel("мой гитхаб https://github.com/zemlyansckygrigorij");
    Box box;
    
	public FrameHelp(){
		createElements();
		
		this.setTitle("Помощь");
		this.setSize(400,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void createElements(){
		box = Box.createVerticalBox();
		box.add(label1);
		box.add(label2);
		box.add(label3);
		box.add(label4);
		this.add(box);
		
	}

}
