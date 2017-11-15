package stages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage extends Stage{
	
	private FXMLLoader fxmlLoader = new FXMLLoader();
	Properties prop = new Properties();
	public MainStage() throws IOException{
		fxmlLoader.setLocation(getClass().getResource("../fxmls/MainWindow.fxml"));
		
		FileInputStream input = new FileInputStream("src/bundles/Locale_en.properties");
		 prop.load(input);
	
		
		Parent root = FXMLLoader.load(getClass().getResource("../fxmls/MainWindow.fxml"));
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());
		this.setScene(scene);
		this.setTitle(prop.getProperty("address_book"));
	}
}
