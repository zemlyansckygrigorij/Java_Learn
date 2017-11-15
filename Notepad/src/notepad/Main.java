package notepad;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main {
	public static String        buffer = "";
	private final String        NAME = "new File";
    private JTabbedPane         tabs = new JTabbedPane();
  
    private BaseFileChooser     fileChooser = new BaseFileChooser();
    private JMenuBar            menuBar = new JMenuBar();
    
    private JMenu               menuFile ;
    private JMenu               editFile ;
    private JMenu               formatFile ;
    private JMenu               helpFile ;
    
    private JMenuItem           newFile ;
    private JMenuItem           openFile ;
    private JMenuItem           saveFile;
    private JMenuItem           exitFile;
	
    private JMenuItem           openFolderFile;
    private JMenuItem           saveAs;
    private JMenuItem           reName;
    private JMenuItem           close;
    private JMenuItem           closeAll;
    private JMenuItem           deleteFile;
    private JMenuItem           print;
	
    private JMenuItem           cancel;
    private JMenuItem           cut;
	private JMenuItem           copy;
	private JMenuItem           paste;
	private JMenuItem           delete;
	private JMenuItem           find;
	private JMenuItem           replace;
	private JMenuItem           selectAll;
	
	private JMenuItem           font;
	private JMenuItem           wordWrap;
	
	private JMenuItem           help;
	
	private JFrame              window ;
	private File                file ;
	private FileOutputStream    writer ;
	
	private String              CopyString = "";
	Main                        main;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Main();
			}
			
		});

	}
	public Main(){
		main = this;
		createMenu();
		createWindow();
	}
	
	
	public void createMenu(){
		createMenuFile();
		createMenuEdit();
		createMenuFormat();
		createMenuHelpFile();
		menuAddListener();
		
	}
	public void createMenuFile(){
		 //create menu File
		menuFile = new JMenu("Файл");
		
		newFile = new JMenuItem("Создать файл");
		openFile = new JMenuItem("Открыть файл");
		saveFile = new JMenuItem("Сохранить файл");
		exitFile = new JMenuItem("Выход");
		openFolderFile = new JMenuItem("Открыть папку файла");
		saveAs = new JMenuItem("Сохранить как");
		reName = new JMenuItem("Переименовать");
		close = new JMenuItem("Закрыть");
		closeAll = new JMenuItem("Закрыть все");
		deleteFile = new JMenuItem("Удалить файл");
		//print = new JMenuItem("Печать");
		
		menuFile.add(newFile);
		menuFile.add(openFile);
		menuFile.add(openFolderFile);
		menuFile.add(saveFile);
		menuFile.add(saveAs);
		menuFile.add(reName);
		menuFile.add(close);
		menuFile.add(closeAll);
		menuFile.add(deleteFile);
		//menuFile.add(print);
		menuFile.addSeparator();//separator
		menuFile.add(exitFile);
		menuBar.add(menuFile);	
	}
	
	public void createMenuEdit(){//create menu edit
	    editFile = new JMenu("Правка");
	    
		cancel = new JMenuItem("Отмена");
		cut = new JMenuItem("Вырезать");
		copy = new JMenuItem("Копировать");
		paste = new JMenuItem("Вставить");
		delete = new JMenuItem("Удалить");
		//find = new JMenuItem("Найти");
		replace = new JMenuItem("Заменить");
		selectAll = new JMenuItem("Выделить все");
		
		//editFile.add(cancel);
		editFile.add(cut);
		editFile.add(copy);
		editFile.add(paste);
		editFile.add(delete);
	//	editFile.add(find);
		editFile.add(replace);
		editFile.add(selectAll);

		menuBar.add(editFile);
    }
	
	public void createMenuFormat(){//create menu format
	    formatFile = new JMenu("Формат");
		
        font = new JMenuItem("Шрифт");
		wordWrap = new JMenuItem("Перенос по словам");
		
		formatFile.add(font);
		formatFile.add(wordWrap);
		
		menuBar.add(formatFile);
	}
	
	public void createMenuHelpFile(){//create menu helpFile
		helpFile = new JMenu("Помощь");
		help = new JMenuItem("Справка");
		helpFile.add(help);
		menuBar.add(helpFile);
	}
	
	public void createWindow(){
		window = new JFrame("Notepad");
		window.setSize(800,600);
		window.setJMenuBar(menuBar);
		window.add(tabs);
		
		JTextArea text = new JTextArea();
		Scroll scroll = new Scroll(text,true,"");

		tabs.add("Test", scroll);
		
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void menuAddListener(){
		newFile.addActionListener(new NewFileListener());
		saveFile.addActionListener(new SaveFileListener() );
		openFile.addActionListener(new OpenFileListener());	
		exitFile.addActionListener(new ExitListener());
		openFolderFile.addActionListener(new OpenFolderFileListener());
		saveAs.addActionListener(new SaveAsListener());
		reName.addActionListener(new ReNameListener());
		close.addActionListener(new CloseListener());
		closeAll.addActionListener(new CloseAllListener());
		deleteFile.addActionListener(new DeleteFileListener ());
	//	print.addActionListener(new PrintListener());
		//cancel.addActionListener(new CancelListener());
		cut.addActionListener(new CutListener());
		copy.addActionListener(new CopyListener());
		paste.addActionListener(new PasteListener());
		delete.addActionListener(new DeleteListener());
		//find.addActionListener(new FindListener());
		replace.addActionListener(new ReplaceListener());
		selectAll.addActionListener(new SelectAllListener());
		font.addActionListener(new FontListener());
		wordWrap.addActionListener(new WordWrapListener());
		help.addActionListener(new HelpListener());

	}
	
	
	public  void replace(String str){
		Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		JTextArea textArea = scroll.getTextArea();
		textArea.setText(str);
	}
	
	public  void setFont(Font font){
		Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		JTextArea textArea = scroll.getTextArea();
		textArea.setFont(font);
	}
	
	public File getFile(){
		Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		File f = new File(scroll.getPath());
		return f;
	}
	public JTextArea getTextArea(){
		Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		JTextArea textArea = scroll.getTextArea();
		return textArea;
	}
	
	/*****************************************************************************************************/
	//classes ActionListener
	
	class NewFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JTextArea text = new JTextArea();
			Scroll scroll = new Scroll(text,true,"");
			tabs.addTab(NAME, scroll);
	
		}
	}
	
	
	class SaveAsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Scroll text = (Scroll) tabs.getSelectedComponent();
			String output = text.getText();
			
			fileChooser.showSaveDialog(null);
			file = fileChooser.getSelectedFile();
			if(tabs.countComponents() !=0){
			
					try{
						writer = new FileOutputStream(file);
						writer.write(output.getBytes());
					}catch(IOException e){
						e.printStackTrace();
					}
				
			}
			
		}
	}
	
	class OpenFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try{
				fileChooser.showOpenDialog(null);
			    file = fileChooser.getSelectedFile();
			    String input = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));//?
			    JTextArea text = new JTextArea(input);
			    Scroll scroll = new Scroll(text,true,file.getAbsolutePath());
			    tabs.addTab(file.getName(),scroll);
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
	}
	
	
	class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	
	class OpenFolderFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   File f = getFile();
		  
		   fileChooser.setCurrentDirectory(f);
		   fileChooser.showOpenDialog(null);
		   fileChooser.setDefault(); 
		}
	}
	
	class SaveFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   Scroll scroll =  (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   File f = getFile();
		   if(!f.isFile()){
			   fileChooser.showSaveDialog(null);
			   f = fileChooser.getSelectedFile();
			   try {
			       f.createNewFile();
			   } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
		   }
		   
		   try(BufferedWriter bw = new BufferedWriter(new FileWriter(f)))
	        {
	          String text = scroll.getText();
	          bw.write(text);
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        } 
		   
		}
	}
	class ReNameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		   
		 //  Scroll scroll =  (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   File f = getFile();
		   
		   
		   String s = (String)JOptionPane.showInputDialog(
				   window,
                   "Введите новое имя файла",
                   "Переименование файла",
                   JOptionPane.PLAIN_MESSAGE
                  
                   );
		   
		   
		   String newFilePath = f.getAbsolutePath().replace(f.getName(), "") + s+ ".txt";
		   File newFile = new File(newFilePath);

		   boolean flag = f.renameTo(newFile);
			if(flag){
			   System.out.println("File renamed successfully");
			}else{
			   System.out.println("Rename operation failed");
			 }
		}
	}

	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   tabs.remove(tabs.getComponent(tabs.getSelectedIndex()));
		 
		}
	}
	
	class CloseAllListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   while(tabs.countComponents() !=0){
			   tabs.remove(tabs.getComponent(0));   
		   }  
		}
	}
	class DeleteFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub	
		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   File f = getFile();
		   try {
			   if(f.isFile()){
		           Files.deleteIfExists(f.toPath());
			   }
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   tabs.remove(tabs.getComponent(tabs.getSelectedIndex()));
		}
	}
	
	class PrintListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   System.out.println("PrintListener");	
		}
	}
	
	class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   System.out.println("CancelListener");	
		}
	}
	
	class CutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea = getTextArea();
		   textArea.setText(textArea.getText().replace(textArea.getSelectedText(),""));
		}
	}
	
	class CopyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub	
		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea = getTextArea();
		   CopyString = textArea.getText();
		}
	}
	
	class PasteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea =getTextArea();
		   textArea.setText(CopyString);
		}
	}
	
	class DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		 //  Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea = getTextArea();
		   textArea.setText("");
		}
	}
	
	class FindListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   System.out.println("FindListener");	
		}
	}
	
	class ReplaceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	
		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea = getTextArea();
		   new FrameReplace(main,textArea.getText()); 
		}
	}
	
	class SelectAllListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		  // Scroll scroll =   (Scroll) tabs.getComponent(tabs.getSelectedIndex());
		   JTextArea textArea = getTextArea();
		   textArea.selectAll();
		}
	}
	
	class FontListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		   new FrameFont(main);
		}
	}
	
	class WordWrapListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	
		   Scroll text = (Scroll) tabs.getSelectedComponent();
		   if(text.getLineWrap()){
			   text.setLineWrap(false);
		   }else{
			   text.setLineWrap(true);
		   }
		       
		}
	}
	
	class HelpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub  
		  new FrameHelp();
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

}

