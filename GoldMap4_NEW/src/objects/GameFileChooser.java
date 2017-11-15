package objects;

import java.nio.file.FileSystem;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GameFileChooser extends JFileChooser{
	
	private FileNameExtensionFilter filter ;
	
	public GameFileChooser(){
		FileNameExtensionFilter  filter = new FileNameExtensionFilter("TXT","txt"); 
		this.setFileFilter(filter);
		this.setDialogTitle("Выбрать файл");
		
		
		// Локализация компонентов окна JFileChooser
		UIManager.put("FileChooser.openDialogTitleText", "Открыть");
		UIManager.put("FileChooser.lookInLabelText", "Искать в");
		UIManager.put("FileChooser.openButtonText", "Открыть");
		UIManager.put("FileChooser.cancelButtonText", "Отмена");
		UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
		UIManager.put("FileChooser.filesOfTypeLabelText", "Tип файлов");
		UIManager.put("FileChooser.openButtonToolTipText", "Открыть файл");
		UIManager.put("FileChooser.cancelButtonToolTipText","Отмена");
		UIManager.put("FileChooser.fileNameHeaderText","Имя файла");
		UIManager.put("FileChooser.upFolderToolTipText", "Выше");
		UIManager.put("FileChooser.homeFolderToolTipText","Рабочий стол");
		UIManager.put("FileChooser.newFolderToolTipText","Создать новую папку");
		UIManager.put("FileChooser.listViewButtonToolTipText","Список");
		UIManager.put("FileChooser.newFolderButtonText","Создать новую папку");
		UIManager.put("FileChooser.renameFileButtonText", "Переименовать файл");
		UIManager.put("FileChooser.deleteFileButtonText", "Удалить файл");
		UIManager.put("FileChooser.filterLabelText", "Тип");
		UIManager.put("FileChooser.detailsViewButtonToolTipText", "Детали");
		UIManager.put("FileChooser.fileSizeHeaderText","Размер");
		UIManager.put("FileChooser.fileDateHeaderText", "Дата изменения");

		
		
		
		//Set icons for the JFileChooser
		
		UIManager.put("FileView.directoryIcon", new ImageIcon("src/files/normal_folder.png"));
		UIManager.put("FileView.hardDriveIcon", new ImageIcon("src/files/hard-drive.png"));
		UIManager.put("FileView.computerIcon", new ImageIcon("src/files/Computer-icon.png"));
		UIManager.put("FileChooser.homeFolderIcon", new ImageIcon("src/files/folder_home_icon.png"));
		UIManager.put("FIleView.floppyDriveIcon", new ImageIcon("src/files/floppy_drive.jpg"));
		UIManager.put("FileView.fileIcon", new ImageIcon("src/files/file_icon.png"));
		
		
		UIManager.put("FileChooser.upFolderIcon", new ImageIcon("src/files/folder_up.png"));
		UIManager.put("FileChooser.newFolderIcon", new ImageIcon("src/files/new_folder_icon.png"));
		UIManager.put("FileChooser.listViewIcon", new ImageIcon("src/files/view_list.png"));
		UIManager.put("FileChooser.detailsViewIcon", new ImageIcon("src/files/details_icon.png"));
		
	//	UIManager.put("FileView.fileIcon", new ImageIcon("src/files/normal_folder.png"));
		//("src/files/folder.png");
		/*
		
		
		
		
	
		
		*/

		//Update UI
	SwingUtilities.updateComponentTreeUI(this);
	
		
		
		/*filter = new FileNameExtensionFilter("*.TXT","*.*"); 
		this.setFileFilter(filter);
		this.setDialogTitle("Выбрать файл");*/
	
	}

}
