package org.exa.ui.WindowsModificarF.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.exa.Estructura;
import org.exa.Formula;
import org.exa.ui.mainwindow.MainWindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowModificarFController implements Initializable {
	
	@FXML
	public TextField formula;
	@FXML
	private Button botonCancelar;
	private MainWindow main;
	private Stage stage;
	
	/***
	 * Accion del boton Aplicar. Verifica la formula, y si es valida la guarda en la clase Estructura. Luego cierra la ventana.
	 */
	@FXML
	public void aplicar() {
		//if(Formula.verificarFormula(formula.getText())) {
			Estructura.formula = formula.getText();
			main.setFormulaText(Estructura.formula);
			botonCancelar.fire();
			
		//}
		
	}
	/***
	 * Cierra la ventana sin guardar nada
	 */
	@FXML
	public void cancelar() {
		stage.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		formula.setText(Estructura.formula);		
	}
	/***
	 * Da acceso a este controlador a la ventana principal
	 * @param main Ventana principal
	 */
	public void setMain(MainWindow main) {
		this.main = main;
	}
	/***
	 * Da acceso a este controlador a la stage de la ventana  de modificar formula
	 * @param stage Stage de la ventana
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	

}
