package org.exa.ui.Window2.view;

import javafx.event.ActionEvent;
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

	@FXML
	public void examinarArchDocentes() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);
		String path=file.getPath();
		this.direccionArchDocentes.setText(path);
	}
	public void examinarArchCatedras() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);
		String path=file.getPath();
		this.direccionArchCatedras.setText(path);
	}


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
	@FXML
	private void cancelar(ActionEvent event) {

		/*Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();*/
		stage.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		direccionArchDocentes.setText(MainWindow.direccionArchivoDocentes);		
		direccionArchCatedras.setText(MainWindow.direccionArchivoCatedras);
	}
	public void setFocusOnCancel() {
		this.cancelar.requestFocus();
	}
	public void setImage(Image image) {
		visualizadorDeImagen.setImage(image);
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
