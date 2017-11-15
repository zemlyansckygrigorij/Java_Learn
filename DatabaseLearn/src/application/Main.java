package application;

//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//import javax.swing.JLabel;

//import objects.DatePickerCodeExample;
import objects.Form;

//import testFrame.TestFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Form form = new Form();
		
			 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		             public void run() {
		            	 
		                  JFrame.setDefaultLookAndFeelDecorated(true);
		                  Form form = new Form();
		  
		             }
		        });
	}

}
