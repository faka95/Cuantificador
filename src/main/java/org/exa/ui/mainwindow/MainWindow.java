package org.exa.ui.mainwindow;

import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.ui.mainwindow.view.mainWindowController;
import org.exa.ui.Window2.Window2;
import org.exa.ui.WindowsModificarF.WindowsModificarF;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	
	//Variables estaticas donde se almacenan las direcciones de los archivos de entrada y la formula
	//puede ser que se las pase a la clase Estructura
		
	public static String direccionArchivoDocentes;
	public static String direccionArchivoCatedras;
	
	private mainWindowController controller;
	
	
	@Override
	public void start(Stage primaryStage){
		direccionArchivoCatedras= new String();
		direccionArchivoDocentes= new String();
		this.primaryStage = primaryStage;
		
		//Titulo de la aplicacion
		
		primaryStage.setTitle("Cuantificador");
		
		//Carga de la Formula, hay que sacar el ejemplo cuando se unan las ramas del programa
		Estructura.formula="A=b*c";

		FileManager.cargarFormula();
		
		displayWindow();
		
	}
	/***
	 * Carga el archivo FXML que corresponde a la ventana principal, almacena el controlador en una variable, carga
	 * la imagen para el icono de la aplicacion, y muestra la ventana
	 */
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
	
	/***
	 * Crea una instancia de la ventana de modificion de las direcciones de los archivos de entrada
	 * y la muestra
	 */
	public void newWindow() {

		//Window2 w = new Window2();
		Window2 windowDirecciones = new Window2();
		windowDirecciones.show(primaryStage,primaryStage.getIcons().get(0));
	}
	

	/***
	 * Crea una instancia de la ventana de modificion de la formula y la muestra
	 */
	public void WindowSetFormula() {
		WindowsModificarF windowF = new WindowsModificarF(this);
		windowF.show(primaryStage,primaryStage.getIcons().get(0));
	}
	
	/***
	 * Muestra la formula pasada por parametro en la ventana principal
	 * @param s formula a ser mostrada
	 */
	public void setFormulaText(String s) {
		this.controller.setFormulaText(s);
	}
	
}
