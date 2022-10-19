package org.exa.ui.WindowsModificarF.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.exa.Estructura;
import org.exa.Formula;
import org.exa.ui.mainwindow.MainWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowModificarFController implements Initializable {
	
	@FXML
	public TextField formula;
	@FXML
	private Button botonCancelar;
	private MainWindow main;
	
	@FXML
	public void aplicar() {
		if(Formula.verificarFormula(formula.getText())) {
			Estructura.formula = formula.getText();
			main.setFormulaText(Estructura.formula);
			botonCancelar.fire();
			
		}
		
	}
	@FXML
	public void cancelar(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		formula.setText(Estructura.formula);		
	}
	public void setMain(MainWindow main) {
		this.main = main;
	}
	
	

}
