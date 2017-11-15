package objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;



public class Map {
	private ImageIcon[][] data;
	private int countColumn=10;
	private int countRow = 10;
	private String path ;
	File file;
	private BufferedReader br ;
	private BufferedWriter bw;
    private ArrayList<AbstractGameObject> objectList = new ArrayList<AbstractGameObject>();;
    private int x ;
	private int y;
	
	private ArrayList<String[]> words = new ArrayList<String[]>();
	public Map(String path){
		this.path =  path;
		data = new  ImageIcon[countColumn][countRow];
		for(int i =0;i<countColumn;i++){
			for(int j =0;j< countRow ;j++){
				 data[i][j] = new Nothing(i,j).getImageIcon();
			}
		}
		loadMap();
		loadData();
	}
	public Map(){
		this.path = ("src/files/map.txt");
		data = new  ImageIcon[countColumn][countRow];
		for(int i =0;i<countColumn;i++){
			for(int j =0;j< countRow ;j++){
				 data[i][j] = new Nothing(i,j).getImageIcon();
			}
		}
		loadMap();
		loadData();
	}
	
	public ImageIcon[][] getData(){
		return this.data;
	}
	public int getCountColumn(){
		return this.countColumn;
	}
	public int getCountRow(){
		return this.countRow;
	}
	public String getPath(){
		return this.path;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public void setData(ImageIcon[][] data){
		this.data = data;
	}
	public void setCountRow(int countRow){
		this.countRow = countRow;
	}
	public void setCountColumn(int countColumn){
		this.countColumn = countColumn;
	}
	public void setPath(String path){
		this.path = path;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public void loadMap(){
		//int i = 0;
		System.out.println(path);
		try( BufferedReader br = new BufferedReader(new FileReader(path)))
		{
		    //чтение построчно
		    String s;
		    while((s=br.readLine())!=null){
		    	words.add(s.split(","));         
		     //   i++;
		    }
		    for(int i = 0;i<words.size();i++){
		    	if(i>countRow-1){break;}
		    	String s1[] = words.get(i);
		    	  
		    	for(int j =0; j<s1.length;j++){
		    		if(j>countColumn-1){break;}
		    		
		    		String word = s1[j];
		    		System.out.println(word);
		    		switch(word){
		    		    case "NOTHING":objectList.add(new Nothing(i,j));
		    		      break;
		    		    case "WALL":objectList.add(new Wall(i,j));
		    		      break;
		    		    case "TRESUARE":objectList.add(new Tresuare(i,j));
		    		      break;
		    		    case "GOLDMAN":objectList.add(new GoldMan(i,j));
		    		      x=i;
		    		      y=j;
		    		      break;
		    		    case "MONSTR":objectList.add(new Monster(i,j));
		    		      break;
		    		    case "EXIT":objectList.add(new EXIT(i,j));
		    		      break;
		    		   
		    		}
		    		
		    		
					
				}
		    }
		   
		}
		 catch(IOException ex){
		             
		    System.out.println(ex.getMessage());
		} 
	}
	public void loadData(){
		if (objectList.size()==0)return;
		for(int i =0;i<objectList.size();i++){
			int x = objectList.get(i).getX();
			int y = objectList.get(i).getY();
			
			data[x][y] = objectList.get(i).getImageIcon();
		}
	}
	
	
	public void saveMap(){}
}
