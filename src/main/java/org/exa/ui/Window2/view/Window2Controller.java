package org.exa.ui.Window2.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.exa.FileManager;
import javafx.scene.control.TextField;
import org.exa.ui.Window2.Window2;
import org.exa.ui.mainwindow.MainWindow;

public class Window2Controller {
	@FXML
	public TextField direccionArchDocentes;
	@FXML
	public TextField direccionArchCatedras;
	@FXML
	public Button cancelar;

	public Window2Controller() {
		System.out.println("constructor");
		Window2.window2Controller=this;
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

		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

}
