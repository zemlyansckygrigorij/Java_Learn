package frames;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableMap extends JTable{
	private int width = 10;
	private int height = 10;
	
	

	public TableMap(){
		this.setEnabled(false);
		this.setSize(new Dimension(300,300));
		this.setRowHeight(26);
		this.setRowSelectionAllowed(false);
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setTableHeader(null);
		this.setUpdateSelectionOnSort(false);
		this.setVerifyInputWhenFocusTarget(false);
	}
	
	
	public TableMap(DefaultTableModel model){
		super(model);
		this.setEnabled(false);
		this.setSize(new Dimension(300,300));
		this.setRowHeight(26);
		this.setRowSelectionAllowed(false);
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setTableHeader(null);
		this.setUpdateSelectionOnSort(false);
		this.setVerifyInputWhenFocusTarget(false);

	}
	
	public void setSetting(){
		this.setEnabled(false);
		this.setSize(new Dimension(300,300));
		this.setRowHeight(26);
		this.setRowSelectionAllowed(false);
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setTableHeader(null);
		this.setUpdateSelectionOnSort(false);
		this.setVerifyInputWhenFocusTarget(false);
	}
	
	
	
	 public Class getColumnClass(int column)
     {
         return getValueAt(0, column).getClass();
     }


}
