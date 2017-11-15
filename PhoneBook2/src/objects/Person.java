package objects;


import javafx.beans.property.SimpleStringProperty;

public class Person {
  private SimpleStringProperty fio =  new SimpleStringProperty("");
  private SimpleStringProperty town =  new SimpleStringProperty("");
  private SimpleStringProperty phone =  new SimpleStringProperty("");
  
  public Person(String fio, String town,String phone ){
	 this.fio =  new SimpleStringProperty(fio);
	 this.town = new SimpleStringProperty(town);
	 this.phone = new SimpleStringProperty(phone);
  }
  public Person(Person o){
		 this.fio =  o.fio;
		 this.town = o.town;
		 this.phone = o.phone;
  }
  
  public void setFio(String fio){
	  this.fio =  new SimpleStringProperty(fio);
  }
  public void setTown(String town){
	  this.town =  new SimpleStringProperty(town);
  }
  public void setPhone(String phone){
	  this.phone =  new SimpleStringProperty(phone);
  }
 /* 
  public SimpleStringProperty getFio(){
	 return this.fio;
  }
  public SimpleStringProperty getTown(){
	  return this.town;
  }
  public SimpleStringProperty getPhone(){
	  return this.phone;
  }
  
  */
  
  
  public String getFio(){
	 return this.fio.get();
  }
  public String getTown(){
	  return this.town.get();
  }
  public String getPhone(){
	  return this.phone.get();
  }
}
