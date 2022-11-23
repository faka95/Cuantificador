package org.exa.ui.mainwindow;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.constantes.ConstanteArchivo;
import org.exa.ui.addressModificationWindow.AddressModificationWindow;
import org.exa.ui.mainwindow.view.mainWindowController;
import org.exa.ui.windowModificarF.WindowsModificarF;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainWindow extends Application{
	
	public Stage primaryStage;
	public BorderPane mainLayout;
	
	//Variables estaticas donde se almacenan las direcciones de los archivos de entrada y la formula
	//puede ser que se las pase a la clase Estructura
		
	public static String direccionArchivoDocentes;
	public static String direccionArchivoCatedras;
	
	public mainWindowController controller;
	
	
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
		loadDirections();
		displayWindow();
		
	}


	/**
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
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			@Override
			public void handle(WindowEvent event) {
				saveDirections();
			}
		});
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	

	/**
	 * Crea una instancia de la ventana de modificion de las direcciones de los archivos de entrada
	 * y la muestra
	 */
	public void windowModifyAddresses() {
		AddressModificationWindow windowDirecciones = new AddressModificationWindow();
		windowDirecciones.show(primaryStage,primaryStage.getIcons().get(0));
	}
	

	/**
	 * Crea una instancia de la ventana de modificion de la formula y la muestra
	 */
	public void windowSetFormula() {
		WindowsModificarF windowF = new WindowsModificarF(this);
		windowF.show(primaryStage,primaryStage.getIcons().get(0));
	}
	

	/**
	 * Muestra la formula pasada por parametro en la ventana principal
	 * @param s formula a ser mostrada
	 */
	public void setFormulaText(String s) {
		this.controller.setFormulaText(s);
	}
	public static void saveDirections() {
		try {
			FileOutputStream fout=new FileOutputStream(ConstanteArchivo.RESOURCES_DIR + "/direcciones.txt");    
			ObjectOutputStream out=new ObjectOutputStream(fout);    
			out.writeObject(direccionArchivoCatedras);
			out.writeObject(direccionArchivoDocentes);
			out.flush();    
			//closing the stream    
			out.close();  
		}catch(Exception e){e.printStackTrace();}
	}


	public static void loadDirections() {
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(ConstanteArchivo.RESOURCES_DIR + "/direcciones.txt"));  
			direccionArchivoCatedras=(String)in.readObject();  
			direccionArchivoDocentes=(String)in.readObject();  
			//closing the stream  
			in.close();  
		}catch (Exception e){e.printStackTrace();}
	}
	
}
