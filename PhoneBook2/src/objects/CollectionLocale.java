package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionLocale {
private ObservableList<String> Locale = FXCollections.observableArrayList();
    
    public void add(String lang){
    	Locale.add(lang);
    }
    public void update(String lang){
    	//personList.add(lang);
    }
    public void delete(String lang){
    	Locale.remove(lang);
    }
    public ObservableList<String> getLocale(){
		return Locale;
    	
    }
    public void print(){
    	int number = 0;
    	System.out.println();
    	for(String lang:Locale){
    		number++;
    		System.out.println(lang);
    	}
    	
    }
    
    public void fillTestData(){
    	Locale.add("EN");
    	Locale.add("RU");
    }
}
