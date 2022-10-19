package org.exa.ui.Window2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.exa.ui.Window2.view.Window2Controller;



public class Window2 {
	
	private Stage stage;
	private BorderPane layout;
	private Window2Controller controller;



	public  void show(Stage parentStage, Image image) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Window2.class.getResource("view/Window2View.fxml"));
		try {
			layout = loader.load();
		} catch (IOException e) {
			System.out.println("error en window2");
			e.printStackTrace();
		}
		this.controller = loader.getController();
		Scene scene = new Scene(layout);
		stage = new Stage();
		stage.setScene(scene);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(parentStage);
		controller.setFocusOnCancel();
		controller.setImage(image);
		controller.setStage(stage);
		stage.getIcons().add(image);
		stage.showAndWait();

		
	}



	public void setIcon(Image image) {
		stage.getIcons().add(image);		
	}
	

}
