package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook {
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    
    public void add(Person person){
    	personList.add(person);
    }
    public void update(Person person){
    	//personList.add(person);
    }
    public void delete(Person person){
    	personList.remove(person);
    }
    public ObservableList<Person> getPersonalList(){
		return personList;
    	
    }
    public void print(){
    	int number = 0;
    	System.out.println();
    	for(Person person:personList){
    		number++;
    		System.out.println(number +"fio = " + person.getFio()+"phone +"+person.getPhone());
    	}
    	
    }
    
    public void fillTestData(){
    	personList.add(new Person("john","mexico","23-34-45"));
    	personList.add(new Person("jeck","tocio","35-45-67"));
    	personList.add(new Person("jhen","moscow","45-65-43"));
    	personList.add(new Person("tom","kiev","11-22-33"));
    	personList.add(new Person("ken","orel","23-45-67"));
    	personList.add(new Person("mary","riga","345-23-23"));
    }
}
