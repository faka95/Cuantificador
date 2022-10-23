package org.exa.ui.mainwindow;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Table {
	
	private TableView<ResultRow> table;
	
	public Table(TableView<ResultRow> t) {
		table = t;
	}
	/***
	 * Coloca los elementos de la lista en la TableView pasada en el constructor de la clase
	 * @param data
	 */
	public void setData(ArrayList<ResultRow> data) {
		table.getColumns().clear();
		table.getColumns().addAll(ResultRow.getColumns());
		ObservableList<ResultRow> list = FXCollections.observableArrayList();
		list.addAll(data);
		table.setItems(list);
	}

}
