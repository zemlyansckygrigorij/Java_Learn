package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectData {
	private Properties prop = new Properties();
	private FileInputStream input;
	private String address_book;
	private String fio;
	private String phone;
	private String town;
	private String addButton;
	private String editButton;
	private String deleteButton;
	private String searchButton;
	private String okButton;
	private String cancelButton;
	
	
	public ProjectData(String path){
	
		try {
		    input = new FileInputStream(path);
		    prop.load(input);
		    
		    address_book = prop.getProperty("address_book");
		    fio = prop.getProperty("fio");
		    phone = prop.getProperty("phone");
		    town = prop.getProperty("town");
		    addButton = prop.getProperty("addButton");
		    editButton = prop.getProperty("EditButton");
		    deleteButton = prop.getProperty("DeleteButton");
		    searchButton = prop.getProperty("SearchButton");
		    okButton = prop.getProperty("OkButton");
		    cancelButton = prop.getProperty("CancelButton");
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		    e.printStackTrace();
		
		    address_book="";
		    fio="";
		    phone="";
		    town="";
		    addButton="";
		    editButton="";
		    deleteButton="";
		    searchButton="";
		    okButton="";
		    cancelButton="";
	  }
	}
	
	public String getAddress_book(){
		return this.address_book ;
	}
	public String getFio(){
		return this.fio ;
	}
	public String getPhone(){
		return this.phone ;
	}
	public String getTown(){
		return this.town ;
	}
	public String getAddButton(){
		return this.addButton ;
	}
	public String getEditButton(){
		return this.editButton ;
	}
	public String getDeleteButton(){
		return this.deleteButton ;
	}
	public String getSearchButton(){
		return this.searchButton ;
	}
	public String getOkButton(){
		return this.okButton ;
	}
	public String getCancelButton(){
		return this.cancelButton ;
	}
}

 