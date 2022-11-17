package org.exa.ui.mainwindow;

import org.exa.FileManager;
import javafx.application.Application;
import org.exa.constantes.*;

public class Main {
    
    public static void main(String[] args) {
        FileManager.cargarConfig(ConstanteArchivo.PATH_ARCHIVO_CONFIG);
        Application.launch(MainWindow.class, args);

    }
    
}