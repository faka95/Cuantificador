package org.exa.ui.mainwindow;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultRow {
	
	private String catedra;
	private int ayudantes;
	
	public ResultRow(String catedra, int ayudantes) {
		this.catedra = catedra;
		this.ayudantes = ayudantes;
	}
	
	public static ArrayList<TableColumn<ResultRow, String>> getColumns(){
		ArrayList<TableColumn<ResultRow, String>> columns = new ArrayList<TableColumn<ResultRow,String>>();
		TableColumn<ResultRow,String> catCol = new TableColumn<ResultRow,String>("Catedra");
		catCol.setCellValueFactory(new PropertyValueFactory<ResultRow,String>("catedra"));
		TableColumn<ResultRow,String> ayuCol = new TableColumn<ResultRow,String>("Ayudantes Asignados");
		ayuCol.setCellValueFactory(new PropertyValueFactory<ResultRow,String>("ayudantes"));
		columns.add(catCol);
		columns.add(ayuCol);
		return columns;
	}
	
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public int getAyudantes() {
		return ayudantes;
	}
	public void setAyudantes(int ayudantes) {
		this.ayudantes = ayudantes;
	}
	

}
