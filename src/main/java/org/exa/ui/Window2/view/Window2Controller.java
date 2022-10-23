package org.exa.ui.Window2.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.exa.ui.mainwindow.MainWindow;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Window2Controller implements Initializable {
	@FXML
	public TextField direccionArchDocentes;
	@FXML
	public TextField direccionArchCatedras;
	@FXML
	public Button cancelar;
	@FXML
	public ImageView visualizadorDeImagen;
	
	private Stage stage;

	/***
	 * Crea y llama un FileChoser para seleccionar el archivo de docentes, y coloca el path en el TextField que corresponde
	 */
	@FXML
	public void examinarArchDocentes() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);
		String path=file.getPath();
		this.direccionArchDocentes.setText(path);
	}
	/***
	 * Crea y llama un FileChoser para seleccionar el archivo de catedras, y coloca el path en el TextField que corresponde
	 */
	public void examinarArchCatedras() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);
		String path=file.getPath();
		this.direccionArchCatedras.setText(path);
	}

	/***
	 * Accion del boton Aceptar. En el caso de que un TextField no este Vacio, guarda su contenido en la variable estatica
	 *  correspondiente en MainWindow. Luego cierra la Ventana
	 */
	@FXML
	public void aceptar(){
		String direccionDocentes= direccionArchDocentes.getText();
		String direccionCatedras= direccionArchCatedras.getText();
		if(direccionDocentes!=null || direccionDocentes!=""){
			MainWindow.direccionArchivoDocentes=direccionDocentes;

		}
		if(direccionCatedras!=null || direccionCatedras!=""){
			MainWindow.direccionArchivoCatedras=direccionCatedras;
		}
		cancelar.fire();
	}
	/***
	 * Cierra la ventana sin guardar nada
	 */
	@FXML
	private void cancelar() {

		stage.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		direccionArchDocentes.setText(MainWindow.direccionArchivoDocentes);		
		direccionArchCatedras.setText(MainWindow.direccionArchivoCatedras);
	}
	/***
	 * Coloca el foco de la ventana en el boton de Cancelar
	 */
	public void setFocusOnCancel() {
		this.cancelar.requestFocus();
	}
	/***
	 * muestra la imagen en ImageView
	 * @param image Imagen a mostrar
	 */
	public void setImage(Image image) {
		visualizadorDeImagen.setImage(image);
	}
	/***
	 * Da acceso a este controlador a la stage de la ventana  de modificar direcciones de archivos de entrada
	 * @param stage Stage de la ventana
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
