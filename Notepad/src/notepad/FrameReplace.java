package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameReplace extends JDialog {
	
	private JTextField    oldField;
	private JTextField    newField;
	
	private Box           MainBox;
	private Box           oldBox;
	private Box           newBox;
	private Box           buttonBox;
	
	private JButton       replaceButton;
	private JButton       exitButton;
	
	private String        oldString;
	private String        newString;
	
	private JFrame        frame;
	FrameReplace          window;
	Main main;
	public FrameReplace(Main main, String oldString){
		this.main = main;
		window = this;
		
		this.oldString = oldString;
		
		createPanel();
		this.setBounds(100, 100, 400, 100);
		this.setTitle("Замена");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void createPanel(){
		MainBox = Box.createVerticalBox();
		oldBox = Box.createVerticalBox();
		newBox = Box.createVerticalBox();
		buttonBox = Box.createHorizontalBox();
		
		oldField = new JTextField();
		newField = new JTextField();
		replaceButton = new JButton("Заменить");
		replaceButton.addActionListener(new ButtonListener());
		
		exitButton = new JButton(" Выход  ");
		exitButton.addActionListener(new ExitListener());
		
		oldField.setText("Старое значение !");
		newField.setText("Новое значение !");
		
		oldBox.add(oldField);
		newBox.add(newField);
		buttonBox.add(replaceButton);
		buttonBox.add(exitButton);
		
		
		oldField.setBounds(10,10,200,20);
		newField.setBounds(10,10,200,20);
		
		oldBox.setBounds(10,10,200,20);
		newBox.setBounds(10,10,200,20);

		MainBox.add(oldBox);
		MainBox.add(newBox);
		MainBox.add(buttonBox);
		
		this.add(MainBox);
	}
	
	public String getNewField(){
        return newString;
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub	
		   newString = oldString.replaceAll(oldField.getText(), newField.getText());
		   main.replace(newString);
		   window.setVisible(false);
		   
		   
		}
	}
	
	class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub	
		   
		  // window.setVisible(false);
			dispose();
		   
		   
		}
	}
	
	

}
