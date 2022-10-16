package org.exa.ui.mainwindow;

import java.io.IOException;
import java.net.URL;

import org.exa.Estructura;
import org.exa.ui.Window2.Window2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	static Stage primaryStage;
	private BorderPane mainLayout;
	public static Estructura estructura;

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Cuantificador");
		displayWindow();
		
	}

	private void displayWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/mainWindowView.fxml"));
		try {
			mainLayout = loader.load();
		} catch (Exception e) {
				System.out.println("Error al cargar mainWindowView.fxml");
				e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void newWindow() {
		Window2 w = new Window2();
		w.show(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
