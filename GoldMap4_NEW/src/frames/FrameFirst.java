package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import objects.ButtonFrameFirst;
import objects.GameFileChooser;
import baseDialogs.BaseFileChooser;
//import objects.Map;

public class FrameFirst extends JFrame{
	
	public FrameFirst(){
		createForm();
	}	
	public FrameFirst(String name){
		super(name);
		createForm();
	}
	private void createForm(){
		createComponent();
		addComponent();
		setSizeComponent();
		addActionListeners();
		
		this.setBounds(750, 300, 180, 170);
		this.setVisible(true);	
	}
	
	private void createComponent(){
		
		box = Box.createVerticalBox();
		boxNewGame = Box.createHorizontalBox();
		boxStatic = Box.createHorizontalBox();
		boxLoad = Box.createHorizontalBox();
		boxExit = Box.createHorizontalBox();
		
		panel = new JPanel();
	
		buttonNewGame = new ButtonFrameFirst("<html><center>Новая игра</center></html>\n");
		buttonLoad = new ButtonFrameFirst("<html><center>Загрузить</html>\n");
		buttonStatic = new ButtonFrameFirst("<html><center>Cтатистика</center></html>\n");
		buttonExit = new ButtonFrameFirst("<html><center>Выход</center></html>\n");
	}
	private void addComponent(){
		boxNewGame.add(buttonNewGame)	;
		boxLoad.add(buttonLoad)	;
		boxStatic.add(buttonStatic)	;
		boxExit.add(buttonExit)	;
		
		box.add(boxNewGame);
		box.add(boxLoad);
		box.add(boxStatic);
		box.add(boxExit);
		
		panel.add(box);

		this.add(panel);
	}
	
	private void setSizeComponent(){
		box.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		boxNewGame.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		boxStatic.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		boxLoad.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		boxExit.setAlignmentX(JComponent.LEFT_ALIGNMENT);
	}
	
	private void addActionListeners(){
		buttonNewGame.addActionListener(new NewGame());
		buttonStatic.addActionListener(new FormStatic());
		buttonLoad.addActionListener(new FormLoad());
		buttonExit.addActionListener(new FormExit());
	}
	private Box box;

	private Box boxNewGame;
	private Box boxStatic;
	private Box boxLoad;
	private Box boxExit;
	
	private JPanel panel;
	private ButtonFrameFirst buttonNewGame;
	private ButtonFrameFirst buttonStatic;
	private ButtonFrameFirst buttonLoad;
	private ButtonFrameFirst buttonExit;
	private FrameFirst obj = this;
	private File fileMap = new File("src/files/map.txt");
    
	public File getFileMap(){
		return this.fileMap;
	}
    
    
    
    /***********************************************************************/
    class NewGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("newGame");
			fileMap = new File("src/files/map.txt");
			FormGame formGame = new FormGame(fileMap.getPath());
		//Map map = new Map(fileMap.getPath());
			formGame.addWindowListener(new WindowListener() {
			     // ...
			     public void windowClosing(WindowEvent event) {

			         // [ТУТ ТВОИ ДЕЙСТВИЯ ПО ЗАКРЫТИЮ]
			    	 obj.setVisible(true);
			     }

				@Override
				public void windowActivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosed(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeactivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowOpened(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			 });
			obj.setVisible(false);
		}
    	
    }
    class FormStatic implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			System.out.println("Static");
			System.out.println(evt.getID());
		}
    	
    }
    class FormExit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Exit");
			System.exit(0);//close form
		}
    	
    }
    class FormLoad implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub

			BaseFileChooser fileopen = new BaseFileChooser();
			FileNameExtensionFilter  filter = new FileNameExtensionFilter("TXT","txt"); 
			fileopen.setFileFilter(filter);
			int ret = fileopen.showDialog(null, "Открыть файл");

			fileMap = fileopen.getSelectedFile();
			FormGame formGame = new FormGame(fileMap.getPath());
		}
    	
    }
}
