package org.exa.ui.mainwindow.view;

import org.exa.ui.mainwindow.MainWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class mainWindowController {
	
	@FXML
	public void accion1() {
		
		MainWindow.newWindow();
	}

}
