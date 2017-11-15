package objects;

public class Coordinates {
   private int x;
   private int y;
   public Coordinates(int x,int y){
	 this.x= Math.abs(x)  ;
	 this.y= Math.abs(y)  ;
   }
   
   public void setX(int x){
	   this.x= Math.abs(x)  ;  
   }
   public int getX(){
	   return this.x;
   }
   
   public void setY(int y){
	   this.y= Math.abs(y)  ;  
   }
   public int getY(){
	   return this.y;
   }
   
   
   public void setXY(int x,int y){
		 this.x= Math.abs(x)  ;
		 this.y= Math.abs(y)  ;
  }
}
