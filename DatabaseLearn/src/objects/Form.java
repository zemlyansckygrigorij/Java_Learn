package objects;



//import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
//import java.awt.image.ImageProducer;
//import java.io.ByteArrayInputStream;
//import java.io.DataInputStream;
import java.io.File;
//import java.io.FileFilter;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.Box;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.Blob;
import com.qt.datapicker.DatePicker;



public class Form extends JFrame{
	private Box                         box = Box.createVerticalBox();
	private Box                         boxTable = Box.createVerticalBox();

	private String                      connectDP="jdbc:mysql://localhost:3306/library";
	private String                      connectPassword="uhbujhbq";

	private String                      connectDN="com.mysql.jdbc.Driver";
	private String                      connectLogin="root";
	
	private JTextField                  fioText = new JTextField("ФИО");
	private JTextField                  birthdayText = new JTextField("Дата рождения");
	private JTextField                  findText = new JTextField("");
	
	private JLabel                      fioLabel = new JLabel("ФИО");
	private JLabel                      birthdayLabel = new JLabel("Дата рождения");
	
	private final JDBCAdapter           adapterTable = new JDBCAdapter(connectDN,connectDP,connectLogin,connectPassword);
	private final JDBCAdapter           adapterAction = new JDBCAdapter(connectDN,connectDP,connectLogin,connectPassword);
	private final JPanel                panel = new JPanel();
	private final JPanel                calendarPanel = new JPanel();
	private JTable                      table =new JTable(adapterTable);
	private JScrollPane                 scrollPane = new JScrollPane(table);
//   private String                      findQuery ;
	private String                      query ;
	private JTabbedPane                 jtp = new JTabbedPane();
	
	private ImageIcon                   image ;
	private JLabel                      labelImage = new JLabel("", image, JLabel.CENTER);

	private JButton                     buttonDelete = new JButton("Удалить");
	private JButton                     buttonCreate = new JButton("Создать");
	private JButton                     buttonUpdate = new JButton("Обновить");
	private JButton                     buttonLoadImage = new JButton("Загрузить файл");
	private JButton                     buttonSetDate = new JButton("Установить дату");
	private JButton                     buttonFind = new JButton("Поиск");
	
	private ResultSet                   resultSet ;
	private File                        fileImage = null;
	private Blob                        blob;
	private BaseFileChooser             fileChooser = new BaseFileChooser();
    byte[]                              blobAsBytes;
   // private DatePicker                  checkInDatePicker;
   // private DatePickerCodeExample       calendar;
    private JDatePicker                 picker ;
    private JFrame                      frame = this;
	public Form(){
		super("Test frame");
	//	createForm();
		setBoundsElements();
	    createGUI();
	    setActionListeners();
	    setAdapterTableSetting();
	    setCalendar();
	    createForm();
	}
	
	 public void createGUI() {
		
		 birthdayText.setEditable(false);//fie
	     panel.setLayout(null);
	     jtp.add("", panel);
	     
	     boxTable.add(scrollPane);
	     box.add(boxTable);
	     
	     panel.add(box);
	     panel.add(fioLabel);
	     panel.add(fioText);
	     panel.add(birthdayLabel);
	     panel.add(birthdayText);
	     panel.add(labelImage);
	     panel.add(buttonDelete);
	     panel.add(buttonCreate);
	     panel.add(buttonUpdate);
	     panel.add(buttonLoadImage);
	     panel.add(buttonSetDate);
	     panel.add(buttonFind);
	     panel.add(findText);
	   
	     this.add(jtp);
	     getContentPane().add(panel);

	   }
	
     private void setActionListeners(){
    	 table.addMouseListener(new TableClicked ()); 
    	 buttonDelete.addActionListener(new DeleteListener());
     	 buttonCreate.addActionListener(new CreateListener());
     	 buttonUpdate.addActionListener(new UpdateListener());
     	 buttonLoadImage.addActionListener(new LoadImageListener());
     	 buttonSetDate.addActionListener(new SetDateListener());
     	 buttonFind.addActionListener(new FindListener());
     }
     
     
	 private void setBoundsElements(){
		
	    buttonFind.setBounds(15, 15, 80, 23);
		findText.setBounds(100, 15, 265, 23); 

	    boxTable.setBounds(15, 45, 350, 100);
	    box.setBounds(15, 45, 350, 400);
	
        fioLabel.setBounds(15, 450, 230, 25);
        fioText.setBounds(125, 450, 240, 25);
        
        birthdayLabel.setBounds(15, 475, 230, 25);
        birthdayText.setBounds(125, 475, 240, 25);

        buttonDelete.setBounds(15, 500, 100, 25);
    	buttonCreate.setBounds(115, 500, 100, 25);
    	buttonUpdate.setBounds(215, 500, 100, 25);
    
    	calendarPanel.setBounds(50, 531, 400, 35);
    	buttonSetDate.setBounds(15, 535, 130, 25);
    	
        labelImage.setBounds(380, 45, 300, 300);
        buttonLoadImage.setBounds(470, 350, 130, 25);
	}
	 
	 
	private void createForm(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Book");
		setSize(805,700);
		setPreferredSize(new Dimension(805,700));
		this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	
	//get value from selected row table and set into textField
	public void getSelectedValue(int rowIndex){
		String fio = (String) table.getModel().getValueAt(rowIndex, 1);
		String birthday =  table.getModel().getValueAt(rowIndex, 2).toString();
		fioText.setText(fio);
		birthdayText.setText(birthday);
	}
	
	//get image from selected row table and set on panel
	private void getSelectedImage(int rowIndex){
		try {
			
			boolean bul = resultSet.absolute(rowIndex+1);
			blob=(Blob) resultSet.getBlob(4);
			if(blob==null) return;
			int blobLength = (int) blob.length();
            blobAsBytes = blob.getBytes(1, blobLength);
            blob.free();
            ImageIcon icon = new ImageIcon( blobAsBytes); // you can read straight from byte array
            labelImage.setIcon(icon);
            fileImage = null;
            repaint();
            setVisible(true);
			
		} catch (SQLException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	private File getFile(){
		FileFilter filter = new FileNameExtensionFilter("JPEG","jpg");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		
		if(file == null){
			showMessage("Файл не выбран !");
			return null;
		}
		if(file.length()> 65000 ){
			showMessage("Размер файла слишком большой !");
			return null;
		}
		return file ;
	}
	
	//load from file
	private void loadImage(String query){

		try{  
			Connection con = adapterAction.getConnection();
			if( con == null){
				showMessage("Подключение к базе данных не установлено !");
				return;
			}
			
			if(fileImage == null){
				return;
			}
		
	        FileInputStream fin=new FileInputStream(fileImage);
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setBinaryStream(1,fin,fin.available());
	        pst.executeUpdate();
			fin.close();
	        con.close(); 
			}catch (Exception e) {e.printStackTrace();}		
	}
	
	private void setAdapterTableSetting(){

		query = "select id as '№', fio as 'ФИО', birthday as 'Дата рождения',image   from author where fio like  '%"+findText.getText()+"%';";
        adapterTable.executeQuery(query);
	    resultSet = adapterTable.getResultSet();
	    table.removeColumn(table.getColumnModel().getColumn(3));
	    table.getColumnModel().getColumn(0).setMaxWidth(30);
	}
	
    private void setCalendar(){
    	java.util.Date date = new java.util.Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	
    	int year = cal.get(Calendar.YEAR);
    	int month = cal.get(Calendar.MONTH);
    	int day = cal.get(Calendar.DAY_OF_MONTH);
    	
    	picker = new JDateComponentFactory().createJDatePicker();
    	picker.setTextEditable(true);
        picker.setShowYearButtons(true);
        calendarPanel.add((Component) picker);
    
        picker.getModel().setYear(year);
        picker.getModel().setMonth(month);
        picker.getModel().setDay(day);
 
        picker.getModel().setSelected(true);
        panel.add(calendarPanel);   
    }
    
    private void showMessage(String message){
	    JOptionPane.showMessageDialog(frame,
			  "<html><h3> <center>   &nbsp  &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp "+message+"</center></h3></html>",
		      "Сообщение",
			  JOptionPane.PLAIN_MESSAGE);
    }
    
    public boolean isValidDate(String date){
    	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    	   boolean flag = true;

    	   try{
    	      dateFormat.parse(date); 
    	   }catch(ParseException e){
    	      flag = false;
    	   }
    	   
    	 return flag;
    	}
    
	private class TableClicked implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int rowIndex = table.getSelectedRow();
			getSelectedValue(rowIndex);	
			getSelectedImage(rowIndex);

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	
	class CreateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			if(!isValidDate(birthdayText.getText())){
				 /*JOptionPane.showMessageDialog(frame,
						  "<html><h3> <center>   &nbsp  &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp Дата не выбрана !</center></h3></html>",
					      "Сообщение",
						  JOptionPane.PLAIN_MESSAGE);*/
				showMessage("Дата не выбрана !");
				return;
			}

			String createQuery = "insert into  library.author(fio,birthday , image ) values('"+fioText.getText()+"','"+birthdayText.getText()+"',?)";
		      
			loadImage(createQuery);
			setAdapterTableSetting();
			repaint();
	        setVisible(true);
	        
	        int rowIndex = table.getRowCount()-1;
			getSelectedValue(rowIndex);	
			getSelectedImage(rowIndex);
		}
		
	}
	
	class UpdateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			int rowIndex = table.getSelectedRow();
			
            if(rowIndex == -1){
            	showMessage("Строка не выбрана !");
				return;
			}
			int id = Integer.valueOf( table.getModel().getValueAt(rowIndex, 0).toString());
			
			if(fileImage == null){
			    adapterAction.executeQueryIns("UPDATE library.author SET fio = '"+ fioText.getText() +"', birthday = '"+birthdayText.getText()+"' WHERE id = '"+id+"'; ");
			}else{
				String updateQuery = "UPDATE library.author SET fio = '"+ fioText.getText() +"', birthday = '"+birthdayText.getText()+"',image = ?  WHERE id = '"+id+"'; ";
				loadImage(updateQuery);
			}
			
			setAdapterTableSetting();
			repaint();
	        setVisible(true);
		}
		
	}
	class DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			int rowIndex = table.getSelectedRow();
		
			if(rowIndex == -1){
			      showMessage("Строка не выбрана !");
				  return;
			}
	
			String fio = (String) table.getModel().getValueAt(rowIndex, 1);
			String birthday =  table.getModel().getValueAt(rowIndex, 2).toString();
			int id = Integer.valueOf( table.getModel().getValueAt(rowIndex, 0).toString());
			adapterAction.executeQueryIns("delete from library.author where fio = '"+ fio +"' and birthday = '"+birthday+"' and id = '"+id+"' limit 1 ");
			
			fileImage = null;
			labelImage.setIcon(null);
			 
			setAdapterTableSetting();
			repaint();
	        setVisible(true);
		}
		
	}
	
	class LoadImageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			fileImage= getFile();
			
			if(fileImage == null){
				return;
			}
		
			try {
				BufferedImage 	image1 = ImageIO.read(new File(fileImage.toPath().toString()));
				labelImage.setIcon( new ImageIcon(image1));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	class SetDateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			java.util.Date date = new java.util.Date();

	        int day = picker.getModel().getDay();
	        int month = picker.getModel().getMonth();
	        int year = picker.getModel().getYear();
	  
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.YEAR, year);
	        cal.set(Calendar.MONTH, month);
	        cal.set(Calendar.DAY_OF_MONTH, day);
	        
	        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	        String formatted = format1.format(cal.getTime());
	    
	        birthdayText.setText(formatted);
		}
	}
	
	
	class FindListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setAdapterTableSetting();
			repaint();
	        setVisible(true);
		}
	}	
}
