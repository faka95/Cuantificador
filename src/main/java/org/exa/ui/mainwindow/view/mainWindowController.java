package org.exa.ui.mainwindow.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.exa.FileManager;
import org.exa.Formula;
import org.exa.ui.mainwindow.MainWindow;
import org.exa.ui.mainwindow.ResultRow;
import org.exa.ui.mainwindow.Table;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;


public class mainWindowController {
	
	@FXML
	public TableView<ResultRow> table;
	
	@FXML
	public void accion1() {
		
		MainWindow.newWindow();
	}
	@FXML
	public void AccionBotonAplicarFormula() {
		if((MainWindow.direccionArchivoDocentes!="") && (MainWindow.direccionArchivoCatedras!="")){
			FileManager.cargarDocente(MainWindow.direccionArchivoDocentes);
			FileManager.cargarCatedra(MainWindow.direccionArchivoCatedras);
			Formula f = new Formula();
			f.parsearFormula(/*MainWindow.estructura.formula*/);
			//if()
				//chequear que el URL existe y formula bien escrita
			f.aplicarFormula();
			ArrayList<ResultRow> lista = new ArrayList<ResultRow>();
			Map<String, Integer> r = MainWindow.estructura.resultado;

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
		}
	}

}
