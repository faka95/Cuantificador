package org.exa.ui.mainwindow.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.Formula;
import org.exa.ui.mainwindow.MainWindow;
import org.exa.ui.mainwindow.ResultRow;
import org.exa.ui.mainwindow.Table;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class mainWindowController implements Initializable{
	
	@FXML
	public TableView<ResultRow> table;
	@FXML
	private TextField formula;
	@FXML
	private CheckBox minimo;
	
	private MainWindow main;
	
	@FXML
	public void accion1() {
		
		main.newWindow();
	}
	@FXML
	public void AccionBotonAplicarFormula() {
		if((!MainWindow.direccionArchivoDocentes.equals(new String(""))) && (!MainWindow.direccionArchivoCatedras.equals(new String("")))){
			FileManager.cargarDocente(MainWindow.direccionArchivoDocentes);
			FileManager.cargarCatedra(MainWindow.direccionArchivoCatedras);
			Formula f = new Formula();
			f.parsearFormula(/*MainWindow.estructura.formula*/);
			//if()
				//chequear que el URL existe y formula bien escrita
			f.aplicarFormula(this.minimo.isSelected());
			ArrayList<ResultRow> lista = new ArrayList<ResultRow>();
			Map<String, Integer> r = Estructura.resultado;

			/**/
			r = new HashMap<String, Integer>();
			r.put("matematicas 1",5);
			r.put("sistemas2",8);
			/**/

			Object[] keys = r.keySet().toArray();
			for(int i = 0;i<r.size();i++ ) {
				lista.add(new ResultRow((String)keys[i],r.get(keys[i])));
			}
			Table t = new Table(table);
			t.setData(lista);
			FileManager.generarSalida();
			System.out.println(minimo.isSelected());
		}
	}
	
	@FXML
	public void AccionModificarF(){
		main.WindowSetFormula();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.formula.setText(Estructura.formula);
	}
	public void setFormulaText(String s) {
		this.formula.setText(s);		
	}
	public void setMain(MainWindow main) {
		this.main = main;
	}
}
