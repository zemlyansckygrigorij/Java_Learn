package stages;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditStage  extends Stage{

private FXMLLoader fxmlLoader = new FXMLLoader();
	
	public EditStage() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../fxmls/EditWindow.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());
		this.setScene(scene);
		this.initModality(Modality.WINDOW_MODAL);
	}
}