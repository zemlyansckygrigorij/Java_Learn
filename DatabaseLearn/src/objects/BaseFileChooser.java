package objects;

import java.io.File;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BaseFileChooser extends JFileChooser{
	
	
	//
	public BaseFileChooser(){
		setDefault();
	    SwingUtilities.updateComponentTreeUI(this);
	}
	public BaseFileChooser(Map<String, String> map){
		setDefault();
	//	this.setSelectedFile("");
		for (Map.Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().contains("Text")){
			   UIManager.put("FileChooser."+entry.getKey() , entry.getValue());
			}
			if(entry.getKey().contains("Icon")){
				
			    File f = new File(entry.getValue());
					
				if(!(f.exists())) { 
				    return;
				}
				
				try{
			        ImageIcon img = new ImageIcon(entry.getValue());
					UIManager.put("FileChooser."+entry.getKey(), img);
					UIManager.put("FileView."+entry.getKey(), img);
			
			    }
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	    SwingUtilities.updateComponentTreeUI(this);
	}
	//getters
	
	public String getOpenDialogTitleText(){ return this.openDialogTitleText ;}
	public String getLookInLabelText(){ return this.lookInLabelText ;}
	public String getOpenButtonText(){ return this.openButtonText ;}
	public String getCancelButtonText(){ return this.cancelButtonText ;}
	public String getFileNameLabelText(){ return this.fileNameLabelText ;}
	public String getFilesOfTypeLabelText(){ return this.filesOfTypeLabelText ;}
	public String getOpenButtonToolTipText(){ return this.openButtonToolTipText ;}
	public String getCancelButtonToolTipText(){ return this.cancelButtonToolTipText ;}
	public String getFileNameHeaderText(){ return this.fileNameHeaderText ;}
	public String getUpFolderToolTipText(){ return this.upFolderToolTipText ;}
	public String getHomeFolderToolTipText(){ return this.homeFolderToolTipText ;}
	public String getNewFolderToolTipText(){ return this.newFolderToolTipText ;}
	public String getListViewButtonToolTipText(){ return this.listViewButtonToolTipText ;}
	public String getNewFolderButtonText(){ return this.newFolderButtonText ;}
	public String getRenameFileButtonText(){ return this.renameFileButtonText ;}
	public String getDeleteFileButtonText(){ return this.deleteFileButtonText ;}
	public String getFilterLabelText(){ return this.filterLabelText ;}
	public String getDetailsViewButtonToolTipText(){ return this.detailsViewButtonToolTipText ;}
	public String getFileSizeHeaderText(){ return this.fileSizeHeaderText ;}
	public String getFileDateHeaderText(){ return this.fileDateHeaderText ;}
	public String getSaveButtonText(){ return this.saveButtonText ;}

	public String getDirectoryIcon(){ return this.directoryIcon ;}
	public String getHardDriveIcon(){ return this.hardDriveIcon ;}
	public String getComputerIcon(){ return this.computerIcon ;}
	public String getHomeFolderIcon(){ return this.homeFolderIcon ;}
	public String getFloppyDriveIcon(){ return this.floppyDriveIcon ;}
	public String getFileIcon(){ return this.fileIcon ;}
	public String getUpFolderIcon(){ return this.upFolderIcon ;}
	public String getNewFolderIcon(){ return this.newFolderIcon ;}
	public String getListViewIcon(){ return this.listViewIcon ;}
	public String getDetailsViewIcon(){ return this.detailsViewIcon ;}
	
	
	
	
	
	public void setDefault(){
		
		UIManager.put("FileChooser.openDialogTitleText", openDialogTitleText);
		UIManager.put("FileChooser.lookInLabelText",lookInLabelText);
		UIManager.put("FileChooser.openButtonText", openButtonText);
		UIManager.put("FileChooser.cancelButtonText", cancelButtonText);
		UIManager.put("FileChooser.fileNameLabelText", fileNameLabelText);
		UIManager.put("FileChooser.filesOfTypeLabelText", filesOfTypeLabelText);
		UIManager.put("FileChooser.openButtonToolTipText", openButtonToolTipText);
		UIManager.put("FileChooser.cancelButtonToolTipText",cancelButtonToolTipText);
		UIManager.put("FileChooser.fileNameHeaderText",fileNameHeaderText);
		UIManager.put("FileChooser.upFolderToolTipText", upFolderToolTipText);
		UIManager.put("FileChooser.homeFolderToolTipText",homeFolderToolTipText);
		UIManager.put("FileChooser.newFolderToolTipText",newFolderToolTipText);
		UIManager.put("FileChooser.listViewButtonToolTipText",listViewButtonToolTipText);
		UIManager.put("FileChooser.newFolderButtonText",newFolderButtonText);
		UIManager.put("FileChooser.renameFileButtonText", renameFileButtonText);
		UIManager.put("FileChooser.deleteFileButtonText", deleteFileButtonText);
		UIManager.put("FileChooser.filterLabelText", filterLabelText);
		UIManager.put("FileChooser.detailsViewButtonToolTipText", detailsViewButtonToolTipText);
		UIManager.put("FileChooser.fileSizeHeaderText",fileSizeHeaderText);
		UIManager.put("FileChooser.fileDateHeaderText", fileDateHeaderText);

		
		UIManager.put("FileChooser.saveButtonText", saveButtonText);
		UIManager.put("FileChooser.saveDialogTitleText", saveDialogTitleText);
		UIManager.put("FileChooser.saveInLabelTextt", saveInLabelText);
		//Set icons for the JFileChooser
		
		UIManager.put("FileView.directoryIcon", new ImageIcon(directoryIcon));
		UIManager.put("FileView.hardDriveIcon", new ImageIcon(hardDriveIcon));
		UIManager.put("FileView.computerIcon", new ImageIcon(computerIcon));
		UIManager.put("FileChooser.homeFolderIcon", new ImageIcon(homeFolderIcon));
		UIManager.put("FIleView.floppyDriveIcon", new ImageIcon(floppyDriveIcon));
		UIManager.put("FileView.fileIcon", new ImageIcon(fileIcon));
		UIManager.put("FileChooser.upFolderIcon", new ImageIcon(upFolderIcon));
		UIManager.put("FileChooser.newFolderIcon", new ImageIcon(newFolderIcon));
		UIManager.put("FileChooser.listViewIcon", new ImageIcon(listViewIcon));
		UIManager.put("FileChooser.detailsViewIcon", new ImageIcon(detailsViewIcon));	
	}
	
	
	
	

	//load variable default
	
	{
		saveButtonText =  "Сохранить";
		openDialogTitleText =  "Открыть";
		saveDialogTitleText =  "Сохранить";
		lookInLabelText =  "Искать в";
		saveInLabelText =  "Сохранить в";
		openButtonText =  "Открыть";
		cancelButtonText =  "Отмена";
		fileNameLabelText =  "Имя файла";
		filesOfTypeLabelText =  "Tип файлов";
		openButtonToolTipText =  "Открыть файл";
		cancelButtonToolTipText = "Отмена";
		fileNameHeaderText = "Имя файла";
		upFolderToolTipText =  "Выше";
		homeFolderToolTipText = "Рабочий стол";
		newFolderToolTipText = "Создать новую папку";//
		listViewButtonToolTipText = "Список";
		newFolderButtonText = "Создать новую папку";
		renameFileButtonText =  "Переименовать файл";
		deleteFileButtonText =  "Удалить файл";
		filterLabelText =  "Тип";
		detailsViewButtonToolTipText =  "Детали";
		fileSizeHeaderText = "Размер";
		fileDateHeaderText =  "Дата изменения";
		
		directoryIcon =  "src/files/normal_folder.png";
		hardDriveIcon =  "src/files/hard-drive.png";
		computerIcon =  "src/files/Computer-icon.png";
		homeFolderIcon =  "src/files/folder_home_icon.png";
		floppyDriveIcon =  "src/files/floppy_drive.jpg";
		fileIcon =  "src/files/file_icon.png";
		upFolderIcon =  "src/files/folder_up.png";
		newFolderIcon =  "src/files/new_folder_icon.png";
		listViewIcon =  "src/files/view_list.png";
		detailsViewIcon =  "src/files/details_icon.png";
	}
	
	
	
	private String openDialogTitleText;
	private String lookInLabelText;
	private String openButtonText;
	private String cancelButtonText;
	private String fileNameLabelText;
	private String filesOfTypeLabelText;
	private String openButtonToolTipText;
	private String cancelButtonToolTipText;
	private String fileNameHeaderText;
	private String upFolderToolTipText;
	private String homeFolderToolTipText;
	private String newFolderToolTipText;
	private String listViewButtonToolTipText;
	private String newFolderButtonText;
	private String renameFileButtonText;
	private String deleteFileButtonText;
	private String filterLabelText;
	private String detailsViewButtonToolTipText;
	private String fileSizeHeaderText;
	private String fileDateHeaderText;
	private String saveButtonText;
	private String saveDialogTitleText;
	private String saveInLabelText;
	
	private String directoryIcon;
	private String hardDriveIcon;
	private String computerIcon;
	private String homeFolderIcon;
	private String floppyDriveIcon;
	private String fileIcon;
	private String upFolderIcon;
	private String newFolderIcon;
	private String listViewIcon;
	private String detailsViewIcon;
	
}
