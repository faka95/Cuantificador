package org.exa.ui.Window2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Window2 {
	
	private Stage stage;
	private BorderPane layout;
	
	public void show(Stage parentStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Window2.class.getResource("view/Window2View.fxml"));
		try {
			layout = loader.load();
		} catch (IOException e) {
			System.out.println("error en window2");
			e.printStackTrace();
		}
		Scene scene = new Scene(layout);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(parentStage);
		stage.showAndWait();
		
	}
	

}
