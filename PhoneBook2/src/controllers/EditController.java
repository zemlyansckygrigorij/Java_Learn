package controllers;

import java.io.IOException;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.Person;

public class EditController {
	@FXML
    private Button OkButton;
    @FXML
    private Button CancelButton;
    @FXML
    TextField eFio;
    @FXML
    TextField ePhone;
    @FXML
    TextField town;
    private static Person person;
    
    @FXML
  	private void initialize() throws IOException{
    	System.out.println("1244"+(person==null));
    	System.out.println(person.getFio());
    	//eFio.setText("1");
    	//ePhone.setText("1");
    	//town.setText("1");
    	setText();
  	}
    
    
    
    
    public void action(ActionEvent actionEvent) throws IOException{
        Object source = actionEvent.getSource();
    	
    	if(!(source instanceof Button)){return;}
    	
    	Button clickedButton = (Button) source;

    	switch(clickedButton.getId()){
    	    case("OkButton"):System.out.println("OkButton");       
    	                     break;
    	    case("CancelButton"):System.out.println("CancelButton");
                                 break;  
    	}
    	
    }
    
    public void setText(){
    	eFio.setText(person.getFio());
    	ePhone.setText(person.getPhone());
    	town.setText(person.getTown());
    }
    public void setPerson(Person person){
    	this.person = person;
    	System.out.println(person.getFio());
    	//eFio.setText(this.person.getFio());
    	/*ePhone.setText(person.getPhone());
    	town.setText(person.getTown());*/
   // 	setText();
    }
}
