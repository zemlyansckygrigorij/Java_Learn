package notepad;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FrameHelp extends JFrame{
	
    JLabel label1 = new JLabel("������ ��������� �����������");
    JLabel label2 = new JLabel("���������� ��������� � 2016�.");
    JLabel label3 = new JLabel("� �������� �������� ���������� !!!");
    JLabel label4 = new JLabel("��� ������ https://github.com/zemlyansckygrigorij");
    Box box;
    
	public FrameHelp(){
		createElements();
		
		this.setTitle("������");
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
