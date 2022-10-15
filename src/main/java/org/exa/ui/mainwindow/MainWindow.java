package org.exa.ui.mainwindow;

import java.io.IOException;

import org.exa.ui.Window2.Window2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	static Stage primaryStage;
	private BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cuantificador");
		displayWindow();
		
	}

	private void displayWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainWindow.class.getResource("view/mainWindowView.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {
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
