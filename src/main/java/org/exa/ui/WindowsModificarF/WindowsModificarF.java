package org.exa.ui.WindowsModificarF;


import java.io.IOException;

import org.exa.ui.WindowsModificarF.view.WindowModificarFController;
import org.exa.ui.mainwindow.MainWindow;

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
	

	public WindowsModificarF(MainWindow main) {
		this.main = main;
	}
	
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
		stage.setScene(scene);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(parentStage);
		stage.setResizable(false);
		stage.getIcons().add(image);
		stage.showAndWait();
		
	}
}
