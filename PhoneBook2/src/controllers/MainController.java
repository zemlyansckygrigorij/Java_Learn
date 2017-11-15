package controllers;


import java.io.IOException;

import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import objects.CollectionAddressBook;
import objects.CollectionLocale;
import objects.Person;
import objects.ProjectData;
import stages.EditStage;

public class MainController {
	private CollectionAddressBook addressBookImpl = new CollectionAddressBook();
	private CollectionLocale collectionLocale = new CollectionLocale();
	@FXML private AnchorPane Anchor;
	
	public Main mainApp;
	private EditController editController ;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView tableAddressBook;
    @FXML
	private TableColumn <Person,String> columnFIO;
	@FXML
	private TableColumn <Person,String> columnTown;
	@FXML
	private TableColumn <Person,String> columnPhone;
	@FXML
	private ComboBox CBox;
	
	private Parent fxmlEdit;
	private FXMLLoader fxmlLoader = new FXMLLoader();

	private Stage eitDialogStage;
	
    public void action(ActionEvent actionEvent) throws IOException{

    	Object source = actionEvent.getSource();
    	
    	if(!(source instanceof Button)){return;}
    	
    	Button clickedButton = (Button) source;
    	
    	Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
    	
    	editController = new EditController();
        
         editController.setPerson(selectedPerson);
    	switch(clickedButton.getId()){
    	    case("btnAdd"):System.out.println("btnAdd");
    	                   getEditStage();
    	                   break;
    	    case("btnEdit"):System.out.println("btnEdit");
    	                    edit(selectedPerson);
                            break;
    	    case("btnDelete"):System.out.println("btnDelete");
    	                      delete(selectedPerson);
                              break;
    	    case("btnSearch"):System.out.println("btnSearch");
                              break;
    	    
    	}
    }
    
    
    @FXML
	private void initialize() throws IOException{
    
		columnFIO.setCellValueFactory(new PropertyValueFactory<Person,String>("fio"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("town"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));
		addressBookImpl.fillTestData();
		
		tableAddressBook.setItems(addressBookImpl.getPersonalList());
		addressBookImpl.getPersonalList().addListener(new ListChangeListener<Person>(){

			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Person> arg0) {
				// TODO Auto-generated method stub
				 //Stage stage=mainApp.getStage();
				System.out.println();
				
			}
			
		});
		
		//Window p =  Anchor.getScene().getWindow();
	/*	Object p = Anchor.getParent();
		Stage stage = (Stage) p;*/
	//	Scene scene =  p.getScene();
		//System.out.println("12311 "+stage);
		
		addressBookImpl.fillTestData();
		tableAddressBook.setItems(addressBookImpl.getPersonalList());
		
		setNames("src/bundles/Locale_en.properties");
		
		collectionLocale.fillTestData();
		
	    CBox.getItems().addAll(collectionLocale.getLocale());
		
	}
    public void getEditStage() throws IOException{
    	EditStage editStage = new EditStage();
    	editStage.initModality(Modality.WINDOW_MODAL);
    	//editStage.initOwner(parentWindow);
    	editStage.show();
    	
    }
    public void delete(Person selectedPerson){
    	if(selectedPerson==null){
    		System.out.println("person not exist");
    		return;
    	}
    	addressBookImpl.delete(selectedPerson);
    }
    
    public void edit(Person selectedPerson) throws IOException{
    	if(selectedPerson==null){
    		System.out.println("person not exist");
    		return;
    	}
    	getEditStage();
      //  editController = new EditController();
       // editController.setText(selectedPerson.getFio(),selectedPerson.getTown(),selectedPerson.getPhone());
     //   editController.setPerson(selectedPerson);

     //   editController.setText();
       // getEditStage();
    }
    
    
    public void setNames(String path){
    	 ProjectData  projectData = new ProjectData(path);
    	 btnAdd.setText(projectData.getAddButton());
    	 btnEdit.setText(projectData.getEditButton());
    	 btnDelete.setText(projectData.getDeleteButton());
    	 btnSearch.setText(projectData.getSearchButton());
    	 columnFIO.setText(projectData.getFio());
    	 columnTown.setText(projectData.getTown());
    	 columnPhone.setText(projectData.getPhone());
    	 
    	// Stage stage = (Stage) Anchor.getScene().getWindow();
    	 /*stage.setTitle(projectData.getAddress_book());*/
    	 
    	
    	
    }
    
    public void changeCombo(ActionEvent actionEvent) throws IOException{
    
    	Object source = actionEvent.getSource();
    	
    	if(!(source instanceof ComboBox)){return;}
    	
    	ComboBox changedCombo = (ComboBox) source;
    	
    	switch(changedCombo.getValue().toString()){
	        case("EN"):setNames("src/bundles/Locale_en.properties");
	                   break;
	        case("RU"):setNames("src/bundles/Locale_ru.properties");
	                   break;
         }
    	
    }
    
}
