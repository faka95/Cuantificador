package org.exa.ui.windowModificarF;


import java.io.IOException;

import org.exa.ui.mainwindow.MainWindow;
import org.exa.ui.windowModificarF.view.WindowModificarFController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowsModificarF {
	
	public static Stage stage;
	public static BorderPane layout;
	private WindowModificarFController controller;
	private MainWindow main;
	
	/***
	 * Contructor de la clase que adminstra la ventana de modificion de la formula
	 * @param main Ventana principal
	 */
	public WindowsModificarF(MainWindow main) {
		this.main = main;
	}
	/***
	 * Carga el archivo FXML que corresponde a la ventana de modificacion de la formula
	 * , almacena el controlador en una variable y muestra la ventana
	 * @param image Imagen para poner de titulo en la ventana
	 * @param parentStage Stage de la ventana a la que pertence
	 */
	public void show(Stage parentStage, Image image) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WindowsModificarF.class.getResource("view/WindowModificarF.fxml"));
		try {
			layout = loader.load();
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		this.controller = loader.getController();
		controller.setMain(main);
		Scene scene = new Scene(layout);
		stage = new Stage();
		controller.setStage(stage);
		stage.setScene(scene);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(parentStage);
		stage.setResizable(false);
		stage.getIcons().add(image);
		stage.showAndWait();
		
	}
}
