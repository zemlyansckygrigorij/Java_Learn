package notepad;

import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Scroll extends JScrollPane{
    private final JTextArea text ;
    private final String path;
    private final boolean isOpened;
   // private  final File file;
  
    
	/**
	 * @param args
	 */
	
    public Scroll(JTextArea text,boolean isOpened,String path ){
    	
    	super(text);
    	this.path = path;
    	this.text = text;
    	this.isOpened = isOpened;
    }
    public String getText(){
    	return text.getText();
    }
    public String getPath(){
    	return this.path;
    }
    public boolean isOpened(){
		return this.isOpened;
	}
    public void setLineWrap(boolean wrap){
    	text.setLineWrap(wrap);	
    }
    
    public boolean getLineWrap(){
    	return text.getLineWrap();
    }
    
    public JTextArea getTextArea(){
		return this.text;
	}
}
