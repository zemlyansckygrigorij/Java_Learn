package objects;

//import java.util.Vector;  
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
//import com.mysql.jdbc.Connection;
public class JDBCAdapter extends AbstractTableModel{

    private Connection connection;		        
    private Statement statement;		      
    private ResultSet resultSet;
    private ResultSetMetaData metaData;

    private String[] columnNames = {};			// Наименования столбцов таблицы
    private ArrayList<ArrayList> rows = new ArrayList<>();			// Объявляем вектор строк таблицы




public JDBCAdapter(String url, String driverName) {
    try {
        Class.forName(url);	        // Регистрируем драйвер

//Выполняем соединение с СУБД
        connection = DriverManager.getConnection(driverName);
        statement = connection.createStatement();
        }
        catch (ClassNotFoundException ex) {
            getMessageError(ex, "Cannot find the database driver classes.");
        }
        catch (SQLException ex) {
            getMessageError(ex, "Cannot connect to this database.");
        }
     }
public JDBCAdapter(String url, String driverName, String login, String password) {
    try {
        Class.forName(url);	        // Регистрируем драйвер

//Выполняем соединение с СУБД
        connection = DriverManager.getConnection(driverName, login, password);
        statement = connection.createStatement();
        }
    catch (ClassNotFoundException ex) {
        getMessageError(ex, "Cannot find the database driver classes.");
    }
    catch (SQLException ex) {
        getMessageError(ex, "Cannot connect to this database.");
    }
     }
public void executeQuery(String query) {
    if (connection == null || statement == null) {
        System.err.println("There is no database to execute the query.");
        System.err.println("connection="+connection);
        System.err.println("statement="+statement);
        return;
    }
    try {
        resultSet = statement.executeQuery(query);            // Отправляем запрос на СУБД
        metaData = resultSet.getMetaData();		      // Получаем метаданные с сервера с помощью которых:
        
        int numberOfColumns =  metaData.getColumnCount();     // сохраняем кол-во столбцов
        columnNames = new String[numberOfColumns];
        for(int column = 0; column < numberOfColumns; column++) {
            columnNames[column] = metaData.getColumnLabel(column+1);	// заносим в массив имена столбцов
        }

        rows = new ArrayList<>();                                            // (1)
  
        int j=1;
        while (resultSet.next()) {                                      // (1)
        	ArrayList<Object> newRow = new ArrayList<>();                               // (1)
            for (int i = 1; i <= getColumnCount(); i++) {		// (1)
//попытка убрать уникальный ключ	            
 
            	newRow.add( resultSet.getObject(i));

            }                                                           // (1)

            	rows.add(newRow);			                // (1)
//                }
            j++;
        	}
        fireTableChanged(null);                                         // Обновляем таблицу
        }
    catch (SQLException ex) {
        System.err.println(ex);
    }
}

public void executeQueryIns(String query) {
    if (connection == null || statement == null) {
        System.err.println("There is no database to execute the query.");
        return;
    }
    try {
    	connection.setAutoCommit(false);
    	boolean rs = statement.execute(query);            // Отправляем запрос на СУБД
    	connection.setAutoCommit(true);
        fireTableChanged(null); 	
        }
    catch (SQLException ex) {
        System.err.println("Down executeQueryIns:"+ex);
    }
}

public void close() throws SQLException {
	if(resultSet != null) resultSet.close();
	if(statement != null) statement.close();
	if(connection != null) connection.close();
}
public String getColumnName(int column) {	        // (2)
    if (columnNames[column] != null) {
        return columnNames[column];			// Возвращаем имя столбца
        } else {
            return "";
        }
    }

public boolean isCellEditable(int row, int column) {	// (3)
    if (column < 1) {
        return false;
    } else {
        return true;
    }
}

public int getColumnCount() {                           // (4)
     return columnNames.length;
}

public int getRowCount() {			        // (5)
	return rows.size();
}

public Object getValueAt(int aRow, int aColumn) {	// (6)
	ArrayList row = (ArrayList)rows.get(aRow);	        // Получаем вектор столбцов строки aRow
    return row.get(aColumn);
}
public Class getColumnClass(int c) {

    return String.class;
}
public String dbRepresentation(int column, Object value) {
    int type;
    System.out.println("dbRepresentation");
    if (value == null) {
        return "null";
    }

    try {
        type = metaData.getColumnType(column+1);                // Получаем тип значения столбца
    }
    catch (SQLException e) {
        return value.toString();
    }

    switch(type) {
        case Types.INTEGER:
        case Types.DOUBLE:
        case Types.FLOAT:
            return value.toString();	                         // Integer, double и float возвращаем как строку
        case Types.BIT:
            return ((Boolean)value).booleanValue() ? "1" : "0";
        case Types.DATE:						// Т.к. в Java нет такого типа как Дата значит возвращаем строку
            return value.toString();
       // case Types.BLOB:						// Т.к. в Java нет такого типа как BLOB значит возвращаем строку
          //  return value.toString();
        default:
           return "\""+value.toString()+"\"";              	// Для всех остальных типов возвращаем строку заключенную в "\"
    }

}
public void setValueAt(String value, int row, int column) {

	String[] PA =  String.valueOf(rows.get(row)).substring(1,String.valueOf(rows.get(row)).length()-1).split(",");
	
	PA[column] = value;
  Object obj = new String();
  ArrayList NV= new ArrayList(); 

  Object instance = null;
  for (int i=0; i< PA.length; i++ ){
	  if (String.valueOf(PA[i]).trim().equals("null")){
			obj=""; 
	  }else{
		    obj=PA[i].trim(); 
				}
		NV.add(obj);
  }
  rows.set(row, NV);
  fireTableCellUpdated(row, column);

}


public void getMessageError(Exception ex, String message){
	System.err.println(message);
    System.err.println(ex);
}

public ResultSet getResultSet(){
	return resultSet ;
}

public Connection getConnection(){
	return connection ;
}
public Statement getStatement(){
	return statement;
}
}