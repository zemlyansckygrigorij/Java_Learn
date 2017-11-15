package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrameFont extends JDialog{
	private int                               fontSize = 12;
	private String                            fontName = "TimesRoman";
	
	private Box                               fontNameBox = Box.createVerticalBox();
	private Box                               fontSizeBox = Box.createVerticalBox();
	private Box                               mainBox = Box.createHorizontalBox();
	private Box                               buttonBox = Box.createHorizontalBox();
	private Box                               box = Box.createVerticalBox();
	private JPanel                            controlPanel = new JPanel();
	
	private JButton                           buttonSave = new JButton("Сохранить");
	private JButton                           buttonCancel = new JButton("  Отмена   ");
	
	private final JRadioButton                size8 = new JRadioButton("8");
	private final JRadioButton                size9 = new JRadioButton("9");
	private final JRadioButton                size10 = new JRadioButton("10");
	private final JRadioButton                size12 = new JRadioButton("12", true);
	private final JRadioButton                size14 = new JRadioButton("14");
	private final JRadioButton                size16 = new JRadioButton("16");
    private final JRadioButton                size18 = new JRadioButton("18");
    private final JRadioButton                size20 = new JRadioButton("20");
    private final JRadioButton                size22 = new JRadioButton("22");
    private final JRadioButton                size24 = new JRadioButton("24");
    private final JRadioButton                size26 = new JRadioButton("26");
    private final JRadioButton                size28 = new JRadioButton("28");
    private final JRadioButton                size36 = new JRadioButton("36");
    private final JRadioButton                size48 = new JRadioButton("48");
    
    private final JRadioButton                timesRomanFont = new JRadioButton("Times Roman");
    private final JRadioButton                arialFont = new JRadioButton("Arial");
    private final JRadioButton                monospacedFont = new JRadioButton("Monospaced");
    private final JRadioButton                sansSerifFont = new JRadioButton("SansSerif");
    private final JRadioButton                verdanaFont = new JRadioButton("Verdana");
    private final JRadioButton                serifFont = new JRadioButton("SERIF");
    private final JRadioButton                lucidaConsoleFont = new JRadioButton("Lucida Console");
    private final JRadioButton                agencyFBFont = new JRadioButton("Agency FB");
    private final JRadioButton                arialUnicodeMSFont = new JRadioButton("Arial Unicode MS");
    private final JRadioButton                blackadderITCFont = new JRadioButton("Blackadder ITC");
    private final JRadioButton                bookmanOldStyleFont = new JRadioButton("Bookman Old Style");  
    private final JRadioButton                bradleyHandITCFont = new JRadioButton("Bradley Hand ITC");
    private final JRadioButton                brushScriptMTFont = new JRadioButton("Brush Script MT");
    private final JRadioButton                calibriFont = new JRadioButton("Calibri");

    private ButtonGroup                       groupSize = new ButtonGroup();
    private ButtonGroup                       groupFont = new ButtonGroup();
    private Main                              main;
	
	public FrameFont(Main main){
		this.main= main;
		
		createPanel();
		setSizeListener();
		setFontListener();
		this.setBounds(100, 100, 500, 400);
		this.setTitle("Шрифт");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	public void createPanel(){
		
		groupSize.add(size8) ;
		groupSize.add(size9) ;
		groupSize.add(size10) ;
		groupSize.add(size12) ;
		groupSize.add(size14) ;
		groupSize.add(size16) ;
		groupSize.add(size18) ;
		groupSize.add(size20) ;
		groupSize.add(size22) ;
		groupSize.add(size24) ;
		groupSize.add(size26) ;
		groupSize.add(size28) ;
		groupSize.add(size36) ;
		groupSize.add(size48) ;
		
		fontSizeBox.add(size8) ;
		fontSizeBox.add(size9) ;
		fontSizeBox.add(size10) ;
		fontSizeBox.add(size12) ;
		fontSizeBox.add(size14) ;
		fontSizeBox.add(size16) ;
		fontSizeBox.add(size18) ;
		fontSizeBox.add(size20) ;
		fontSizeBox.add(size22) ;
		fontSizeBox.add(size24) ;
		fontSizeBox.add(size26) ;
		fontSizeBox.add(size28) ;
		fontSizeBox.add(size36) ;
		fontSizeBox.add(size48) ;
		
		
		
		groupFont.add(timesRomanFont);
		groupFont.add(arialFont);
		groupFont.add(monospacedFont);
		groupFont.add(sansSerifFont);
		groupFont.add(verdanaFont);
		groupFont.add(serifFont);
		groupFont.add(lucidaConsoleFont);
		groupFont.add(agencyFBFont);
		groupFont.add(arialUnicodeMSFont);
		groupFont.add(blackadderITCFont);
		groupFont.add(bookmanOldStyleFont);
		groupFont.add(bradleyHandITCFont);
		groupFont.add(brushScriptMTFont);
		groupFont.add(calibriFont);   
		fontNameBox.add(timesRomanFont);
		fontNameBox.add(arialFont);
		fontNameBox.add(monospacedFont);
		fontNameBox.add(sansSerifFont);
		fontNameBox.add(verdanaFont);
		fontNameBox.add(serifFont);
		fontNameBox.add(lucidaConsoleFont);
		fontNameBox.add(agencyFBFont);
		fontNameBox.add(arialUnicodeMSFont);
		fontNameBox.add(blackadderITCFont);
		fontNameBox.add(bookmanOldStyleFont);
		fontNameBox.add(bradleyHandITCFont);
		fontNameBox.add(brushScriptMTFont);
		fontNameBox.add(calibriFont);
		    
		mainBox.add(fontSizeBox);
		mainBox.add(fontNameBox);
		
		buttonSave.addActionListener(new SaveListener() );
		buttonCancel.addActionListener(new CancelListener() );
		
		buttonBox.add(buttonSave);
		buttonBox.add(buttonCancel);
	
		box.add(mainBox);
		box.add(buttonBox);
		
		controlPanel.add(box);
		
		this.add(controlPanel);

	}
	
	private void setSizeListener(){
	    size8.addActionListener(new SetSizeListener(8));
		size9.addActionListener(new SetSizeListener(9));
		size10.addActionListener(new SetSizeListener(10));
		size12.addActionListener(new SetSizeListener(12));
	    size14.addActionListener(new SetSizeListener(14));
	    size16.addActionListener(new SetSizeListener(16));
	    size18.addActionListener(new SetSizeListener(18));
	    size20.addActionListener(new SetSizeListener(20));
	    size22.addActionListener(new SetSizeListener(22));
	    size24.addActionListener(new SetSizeListener(24)); 
	    size26.addActionListener(new SetSizeListener(26));
	    size28.addActionListener(new SetSizeListener(28));
	    size36.addActionListener(new SetSizeListener(36));
	    size48.addActionListener(new SetSizeListener(48));
	}
	private void setFontListener(){

		timesRomanFont.addActionListener(new SetFontNameListener("TimesRoman"));
		arialFont.addActionListener(new SetFontNameListener("Arial"));
		monospacedFont.addActionListener(new SetFontNameListener("Monospaced"));
		sansSerifFont.addActionListener(new SetFontNameListener("SansSerif"));
		verdanaFont.addActionListener(new SetFontNameListener("Verdana"));
		verdanaFont.addActionListener(new SetFontNameListener("SERIF"));
		lucidaConsoleFont.addActionListener(new SetFontNameListener("Lucida Console"));
		agencyFBFont.addActionListener(new SetFontNameListener("Agency FB"));
		arialUnicodeMSFont.addActionListener(new SetFontNameListener("Arial Unicode MS"));
		blackadderITCFont.addActionListener(new SetFontNameListener("Blackadder ITC"));
		bookmanOldStyleFont.addActionListener(new SetFontNameListener("Bookman Old Style"));
		bradleyHandITCFont.addActionListener(new SetFontNameListener("Bradley Hand ITC"));
		brushScriptMTFont.addActionListener(new SetFontNameListener("Brush Script MT"));
		calibriFont.addActionListener(new SetFontNameListener("Calibri"));

	}
	
	class SaveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Font font =  new Font(fontName, Font.BOLD, fontSize);
			main.setFont(font);
			dispose();
		}
		
	}
	class CancelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
	}
	
	
	class SetSizeListener implements ActionListener{
        private int size ;
        
        public SetSizeListener(int size){
        	this.size = size;
        }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fontSize = size;
		}	
	}
	
	class SetFontNameListener implements ActionListener{
        private String name ;
        
        public  SetFontNameListener(String name){
        	this.name = name;
        }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			fontName = name;
		}
		
	}

}
