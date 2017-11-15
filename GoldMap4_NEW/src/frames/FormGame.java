package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import objects.Images;
import objects.Map;


import enums.MovingDirection;

public class FormGame  extends JFrame{
	
	
	
	public FormGame(String path){
		this.path = path;
		createForm();
	} 
	public FormGame(String name,String path){
		super(name);
		this.path = path;
		createForm();
	} 
	
	private void createForm(){
		//this.setLayout(null);
		createComponent();
		createTableMap();
		addComponent();
		addActionListeners();
		setFormSetting();
			
	}
	
	private void setFormSetting(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(10, 20, 800, 300); 
		this.pack();
		this.setVisible(true);
	}
	private void createComponent(){
		boxButton = Box.createVerticalBox();
		boxButtonUP = Box.createHorizontalBox();
		boxButtonLR = Box.createHorizontalBox();
		boxButtonDOWN = Box.createHorizontalBox();
		boxButtonSAVE = Box.createHorizontalBox();
		boxButtonEXIT = Box.createHorizontalBox();
		boxTable = Box.createHorizontalBox();
		boxMain = Box.createHorizontalBox();
		
		
	
		
		boxMain.setBounds(0, 0, 800, 800);
		boxButton.setBounds(0, 0, 300, 250);
		
		panel = new JPanel();	
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		buttonUp = new ButtonMove(MovingDirection.UP);
		buttonDown = new ButtonMove(MovingDirection.DOWN);
		buttonLeft = new ButtonMove(MovingDirection.LEFT);
		buttonRight = new ButtonMove(MovingDirection.RIGHT);
		buttonWait = new ButtonMove(MovingDirection.WAIT);
		buttonSave = new JButton("Сохранить");
		buttonExit = new JButton("  Выход  ");
		//buttonSave = new JButton("");
		//buttonExit = new JButton("  ");
		
		
		labelPoint = new JLabel("Количество очков = " + countPoint);
		labelStep = new JLabel("Количество ходов = " + countStep );
	  
		buttonUp.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonDown.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonRight.setAlignmentX(Component.CENTER_ALIGNMENT);
	    boxMain.setBackground(Color.green);
	}

	private void addComponent(){
		
		boxTable.add(table);
		 
	//	boxButtonUP.add(buttonUp)	;
	//	boxButtonDOWN.add(buttonDown)	;
		boxButtonLR.add(buttonLeft)	;
		boxButtonLR.add(buttonWait)	;
		boxButtonLR.add(buttonRight)	;
	//	boxButtonSAVE.add(buttonSave)	;
	//	boxButtonEXIT.add(buttonExit)	;
		boxButton.add(buttonUp);
		boxButton.add(boxButtonLR);
		boxButton.add(buttonDown);
		/*boxButton.add(buttonSave);
		boxButton.add(buttonExit);
		boxButton.add(labelStep);
		boxButton.add(labelPoint);*/
		
		/********************************/
		boxButtonSAVE.add(buttonSave)	;
	    boxButtonEXIT.add(buttonExit)	;
	    boxButton.add(boxButtonSAVE);
		boxButton.add(boxButtonEXIT);
		boxButton.add(labelStep);
		boxButton.add(labelPoint);
		
		boxButtonSAVE.setBounds(buttonSave.getBounds());
		/*******************************/
		
		
		
		boxMain.add(boxTable);
		boxMain.add(boxButton);
		panel.add(boxMain);
		panel.setBackground(Color.gray);
		this.add(panel);
		
		/*****************************/
		boxButton.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		buttonSave.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelPoint.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelStep.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//buttonSave.setMinimumSize(300);
		
		//buttonSave.setSize(300, 100);
		//buttonExit.setSize(300, 100);
		
		//buttonSave.setSize(buttonDown.getSize());
		buttonSave.setPreferredSize(buttonDown.getPreferredSize());      
		
		/******************************/
	
		
	}
	private void addActionListeners(){
		buttonUp.addActionListener(new MoveGame(MovingDirection.UP,-1,0));
		buttonDown.addActionListener(new MoveGame(MovingDirection.DOWN,1,0));
		buttonLeft.addActionListener(new MoveGame(MovingDirection.LEFT,0,-1));
		buttonRight.addActionListener(new MoveGame(MovingDirection.RIGHT,0,1));
		buttonSave.addActionListener(new saveGame());
		buttonExit.addActionListener(new exitGame());
	}
	
	private void createTableMap(){
	     map = new Map(path);
		 String[] columnNames = {"", "", "", "", "", "", "", "", "", ""};
		 DefaultTableModel model = new DefaultTableModel(map.getData(), columnNames);
		 table = new TableMap(model);
		 table.setBounds(0, 0, 300, 300);
		 table.setMaximumSize(new Dimension(400, 260));
	}
	
	
	
	Box boxButton;
	Box boxButtonUP;
	Box boxButtonLR;
	Box boxButtonDOWN;
	Box boxButtonSAVE;
	Box boxButtonEXIT;
	Box boxTable;
	Box boxMain;
    JPanel panel;
    ButtonMove buttonUp;
    ButtonMove buttonDown;
    ButtonMove buttonLeft;
    ButtonMove buttonRight;
    ButtonMove buttonWait;
    JButton buttonSave;
    JButton buttonExit;
    
    
    JLabel labelPoint;
    JLabel labelStep;
    int countPoint = 0;
    int countStep = 0;
    FormGame formGame = this;
    
    
    Map map ; 
    TableMap table;
    String path;
    /***********************************************************************/
    class MoveGame implements ActionListener{
    	MovingDirection movingDirection;
    	private int x;
    	private int y;
    	
    	MoveGame(MovingDirection movingDirection,int x,int y){
    		this.movingDirection = movingDirection;
    		this.x = x;
    		this.y = y;
    	}
    
		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			
			 System.out.println(movingDirection);
			 int xF = map.getX();
			 int yF = map.getY();
			 int xE = xF + x;
			 int yE = yF + y;
			 
			 if(xE<0||yE<0||xE>9||yE>9) return;
			 
			 Object o1 = table.getModel().getValueAt(xF, yF);
			 Object o2 = table.getModel().getValueAt(xE, yE);
			 
			 if(o2==Images.WALL) return;
			 if(o2==Images.TRESUARE) countPoint++;
			 if(o2==Images.MONSTR){
				 table.getModel().setValueAt(Images.MONSTR, xE, yE);
				 table.getModel().setValueAt(Images.NOTHING, xF, yF);
				 return;
			 } //System.out.println("Game over");
			 
			 countStep++;
			 labelPoint.setText("Количество очков = " + countPoint);
			 labelStep.setText("Количество ходов = " + countStep );
			    
			 table.getModel().setValueAt(o1, xE, yE);
			 table.getModel().setValueAt(Images.NOTHING, xF, yF);
			 
			 map.setX(xE);
			 map.setY(yE);
		}
    	
    }
    
    class exitGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			formGame.setVisible(false);
			
		}}
}
class saveGame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//formGame.setVisible(false);
		System.out.println("sAVE");
		
	}}

/************************************************************************************************************************/










