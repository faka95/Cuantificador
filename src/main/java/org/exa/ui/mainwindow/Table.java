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
	
	public void setData(ArrayList<ResultRow> data) {
		table.getColumns().clear();
		table.getColumns().addAll(ResultRow.getColumns());
		ObservableList<ResultRow> list = FXCollections.observableArrayList();
		list.addAll(data);
		table.setItems(list);
	}

}
