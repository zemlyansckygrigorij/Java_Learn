package notepad;


import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
	private File file;
	private Scroll component;
	
	public Panel(File file, Scroll component){
	    this.file = file;
	    this.component = component;
	    JLabel label = new JLabel("1243");
	    this.add(label);
	    this.add(this.component);
	}
	public File getFile(){
		return this.file;
	}
	
	public Scroll getComponent(){
		return this.component;
	}

}
