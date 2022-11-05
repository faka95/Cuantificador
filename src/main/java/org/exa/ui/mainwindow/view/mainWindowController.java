package org.exa.ui.mainwindow.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import org.exa.Errores;
import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.Formula;
import org.exa.ui.mainwindow.MainWindow;
import org.exa.ui.mainwindow.ResultRow;
import org.exa.ui.mainwindow.Table;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class mainWindowController implements Initializable{
	
	@FXML
	public TableView<ResultRow> table;
	@FXML
	private TextField formula;
	@FXML
	private CheckBox minimo;

	@FXML
	private ImageView imagenFormula;
	
	private MainWindow main;
	@FXML
	private Label label_error;
	/***
	 * Accion del boton para modificar las direcciones de los archivos de entrada.
	 * Llama a la funcion newWindow de la clase MainWindow
	 */
	@FXML
	public void accion1() {
		
		main.newWindow();
	}
	/***
	 * Accion del boton Aplicar Formula. Si las direcciones de los archivos de entrada no estan vacias,
	 * Llama la funcion FileManager.cargarDocente(MainWindow.direccionArchivoDocentes).
	 * Llama la funcion FileManager.cargarCatedra(MainWindow.direccionArchivoCatedras).
	 * Llama la funcion parsearFormula(Estructura.formula) (COMENTADO POR EL MOMENTO).
	 * Llama la funcion aplicarFormula(Minimo1).
	 * Luego formatea los resultado para poder mostrarlos en la TableView de la ventana principal y los musetra.
	 * Luego llama a la funcion FileManager.generarSalida();
	 * 
	 */
	@FXML
	public void AccionBotonAplicarFormula() {
			FileManager.cargarCatedra(MainWindow.direccionArchivoCatedras);
			FileManager.cargarDocente(MainWindow.direccionArchivoDocentes);
			Formula f = new Formula();
			f.aplicarFormula(this.minimo.isSelected());
			if(!Errores.existenErrores()) {
				ArrayList<ResultRow> lista = new ArrayList<ResultRow>();
				Map<String, Integer> r = Estructura.resultado;
				System.out.println(Estructura.formula);
				System.out.println(Estructura.resultado);
				System.out.println(f.aplicarFormula(this.minimo.isSelected()));
				//HAY QUE BORRAR ESTO CUANDO HAYA ALGO EN EL RESULTADO PARA MOSTRAR

				r = new HashMap<String, Integer>();
				Estructura.resultado = r;
				r.put("matematicas 1", 5);
				r.put("sistemas2", 8);


				Object[] keys = r.keySet().toArray();
				for (int i = 0; i < r.size(); i++) {
					lista.add(new ResultRow((String) keys[i], r.get(keys[i])));
				}
				Table t = new Table(table);
				t.setData(lista);

				//Generacion de la salida

				try {
					FileManager.generarSalida(Estructura.resultadoPath);
				} catch (IOException e) {
					System.out.println("Error al generar la salida");
					e.printStackTrace();
				}
			}
			else
			{
				ventanaDeErrores(Errores.getErrores());
			}
			//System.out.println(minimo.isSelected());

	}
	private void ventanaDeErrores(ArrayList<String> errores) {
		/*Stage stage1 = new Stage();
		BorderPane pane = new BorderPane();
		VBox vBox = new VBox();*/
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Errores");
		String content = new String("-" + errores.get(0));
		for(int i=1;i<errores.size();i++) {
			content = content + "\n" + "-" + errores.get(i);
		}
		Label label = new Label(content);
		GridPane.setVgrow(label, Priority.ALWAYS);
		GridPane.setHgrow(label, Priority.ALWAYS);
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		alert.getDialogPane().setContent(expContent);
		alert.getDialogPane().autosize();
		alert.initOwner(main.primaryStage);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.showAndWait();
		
		/*
		ObservableList<Label> labels = FXCollections.observableArrayList();
		for(int i=0;i<errores.size();i++) {
			
			Label newLabel = new Label(errores.get(i));
			newLabel.setPrefHeight(20);
			labels.add(newLabel);
		}
		vBox.getChildren().addAll(labels);
		vBox.setSpacing(10);
		pane.setCenter(vBox);
		pane.setPadding(new Insets(10));
		//pane.setPrefHeight(vBox.getPrefHeight());
		Scene scene1 = new Scene(pane,-1,-1);//20*2*labels.size());
		stage1.setScene(scene1);
		stage1.initModality(Modality.WINDOW_MODAL);
		stage1.initOwner(main.primaryStage);

		stage1.showAndWait();*/
	}
	
	/***
	 * Llamaa la funcion WindowSetFormula() en la clase MainWindow, para abrir la ventana de modificacion de la formula
	 */
	@FXML
	public void AccionModificarF(){
		main.WindowSetFormula();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.formula.setText(Estructura.formula);
		this.imagenFormula.setImage(new Image(getClass().getResource("warning_icon.png").toString()));
		this.setFormulaWarning();
	}
	/***
	 * Muestra la el texto pasado por parametro en el TextField de la ventana principal
	 * @param s formula a ser mostrada
	 */
	public void setFormulaText(String s) {
		this.formula.setText(s);		
	}
	/***
	 * Da acceso a este controllador a la ventana principal
	 * @param main Ventana Principal
	 */
	public void setMain(MainWindow main) {
		this.main = main;
	}

	public void setFormulaWarning(){
		if(!(new Formula().chequearFormula(formula.getText()))) {
			imagenFormula.setVisible(true);
			label_error.setVisible(true);
		}
		else {
			imagenFormula.setVisible(false);
			label_error.setVisible(false);
		}
	}
}
