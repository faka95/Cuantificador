package org.exa.ui.addressModificationWindow;

import java.io.IOException;

import org.exa.ui.addressModificationWindow.view.AddressModificationWindowController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class AddressModificationWindow {
	
	private Stage stage;
	private BorderPane layout;
	private AddressModificationWindowController controller;


	/**
	 * Carga el archivo FXML que corresponde a la ventana de modificacion de direcciones de archivos de entrada
	 * , almacena el controlador en una variable y muestra la ventana
	 * @param image Imagen para poner de titulo en la ventana
	 * @param parentStage Stage de la ventana a la que pertence
	 */
	public  void show(Stage parentStage, Image image) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AddressModificationWindow.class.getResource("view/AddressModificationWindowView.fxml"));
		try {
			layout = loader.load();
		} catch (IOException e) {
			System.out.println("error en AddressModificationWindow");
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
}
