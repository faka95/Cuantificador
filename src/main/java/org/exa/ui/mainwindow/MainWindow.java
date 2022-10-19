package org.exa.ui.mainwindow;

import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.ui.WindowsModificarF.WindowsModificarF;
import org.exa.ui.mainwindow.view.mainWindowController;
import org.exa.ui.Window2.Window2;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	public static String direccionArchivoDocentes;
	public static String direccionArchivoCatedras;
	public static String direccionArchivoFormula=new String("formula.txt");
	private mainWindowController controller;
	
	
	@Override
	public void start(Stage primaryStage){
		direccionArchivoCatedras= new String();
		direccionArchivoDocentes= new String();
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Cuantificador");
		
		FileManager.cargarFormula(MainWindow.direccionArchivoFormula);
		Estructura.formula="A=b*c";
		
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
		this.controller = loader.getController();
		controller.setMain(this);
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image(getClass().getResource("icon.jpg").toString()));
		primaryStage.show();
		
	}
	
	public void newWindow() {

		//Window2 w = new Window2();
		Window2 windowDirecciones = new Window2();
		windowDirecciones.show(primaryStage,primaryStage.getIcons().get(0));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void WindowSetFormula() {
		WindowsModificarF windowF = new WindowsModificarF(this);
		windowF.show(primaryStage,primaryStage.getIcons().get(0));
	}
	public void setFormulaText(String s) {
		this.controller.setFormulaText(s);
	}
	
}
