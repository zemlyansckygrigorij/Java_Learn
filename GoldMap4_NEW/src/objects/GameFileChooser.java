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
		this.setDialogTitle("������� ����");
		
		
		// ����������� ����������� ���� JFileChooser
		UIManager.put("FileChooser.openDialogTitleText", "�������");
		UIManager.put("FileChooser.lookInLabelText", "������ �");
		UIManager.put("FileChooser.openButtonText", "�������");
		UIManager.put("FileChooser.cancelButtonText", "������");
		UIManager.put("FileChooser.fileNameLabelText", "��� �����");
		UIManager.put("FileChooser.filesOfTypeLabelText", "T�� ������");
		UIManager.put("FileChooser.openButtonToolTipText", "������� ����");
		UIManager.put("FileChooser.cancelButtonToolTipText","������");
		UIManager.put("FileChooser.fileNameHeaderText","��� �����");
		UIManager.put("FileChooser.upFolderToolTipText", "����");
		UIManager.put("FileChooser.homeFolderToolTipText","������� ����");
		UIManager.put("FileChooser.newFolderToolTipText","������� ����� �����");
		UIManager.put("FileChooser.listViewButtonToolTipText","������");
		UIManager.put("FileChooser.newFolderButtonText","������� ����� �����");
		UIManager.put("FileChooser.renameFileButtonText", "������������� ����");
		UIManager.put("FileChooser.deleteFileButtonText", "������� ����");
		UIManager.put("FileChooser.filterLabelText", "���");
		UIManager.put("FileChooser.detailsViewButtonToolTipText", "������");
		UIManager.put("FileChooser.fileSizeHeaderText","������");
		UIManager.put("FileChooser.fileDateHeaderText", "���� ���������");

		
		
		
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
		this.setDialogTitle("������� ����");*/
	
	}

}
