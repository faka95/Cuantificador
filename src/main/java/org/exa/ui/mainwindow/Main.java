package org.exa.ui.mainwindow;

import javafx.application.Application;
import org.exa.Errores;
import org.exa.Estructura;
import org.exa.FileManager;
import org.exa.formula.Formula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    private String formula;
    private static boolean minimo=false;

    /***
     * Metodo para iniciar el programa
     * Si se ingresa sin parametros se abre la interfaz
     * Si se ingresa con parametros se abre sin usar la interfaz
     * posibles parametros:
     * 1) direccionArchivoCatedra, direcccionArchivoDocente, direccionResultado
     * 2) direccionArchivoCatedra, direcccionArchivoDocente, direccionResultado, minimo
     * 3) direccionArchivoCatedra, direcccionArchivoDocente, direccionResultado, formula, minimo
     * 4) direccionArchivoCatedra, direcccionArchivoDocente, direccionResultado, formula
     */
    public static void main(String[] args) {
        switch (args.length) {
            case 3:
                ejecutar(args[0], args[1], args[2]);
                break;
            case 4:
                switch(args[3]) {
                    case "false":
                        ejecutar(args[0], args[1], args[2], false);
                        break;
                    case "true":
                        ejecutar(args[0], args[1], args[2], true);
                        break;
                    default:
                        ejecutar(args[0], args[1], args[2], args[3]);
                }
                break;
            case 5:
                switch(args[4]) {
                    case "false":
                        ejecutar(args[0], args[1], args[2],args[3], false);
                        break;
                    case "true":
                        ejecutar(args[0], args[1], args[2], args[3], true);
                        break;
                    default:
                        System.out.println("ERROR: el parametro 'minimo' no es tipo boolean");
                }
                break;
            default:
                Application.launch(MainWindow.class, args);
        }
    }

    private static void ejecutarFormula(String direccionCatedras,String direccionDocentes,String direccionSalida,String form){
        FileManager.cargarCatedra(direccionCatedras);
        FileManager.cargarDocente(direccionDocentes);
        Formula f = new Formula();

        Formula.chequearFormula(form);

        if(Errores.esPosibleAplicar()){
            f.aplicarFormula(minimo);
        }


        if(!Errores.existenErrores()) {
            ArrayList<ResultRow> lista = new ArrayList<ResultRow>();
            Map<String, Integer> r = Estructura.resultado;
            //HAY QUE BORRAR ESTO CUANDO HAYA ALGO EN EL RESULTADO PARA MOSTRAR

				/*
				r = new HashMap<String, Integer>();
				Estructura.resultado = r;
				r.put("matematicas 1", 5);
				r.put("sistemas2", 8);
				*/

            //Generacion de la salida

            try {
                FileManager.generarSalida(direccionSalida);
            } catch (IOException e) {
                System.out.println("Error al generar la salida");
                e.printStackTrace();
            }
        }
        else
        {
            ArrayList<String> errores = Errores.getErrores();
            for (int i=0;i<errores.size();i++) {
                System.out.println(errores.get(i));
            }
        }


        //System.out.println(minimo.isSelected());
    }

    public static void ejecutar(String direccionCatedras,String direccionDocentes,String direccionSalida,String form){
        Estructura.formula = form;
        ejecutarFormula(direccionCatedras,direccionDocentes, direccionSalida, form);
    }

    public static void ejecutar(String direccionCatedras,String direccionDocentes,String direccionSalida){
        FileManager.cargarFormula();
        ejecutarFormula(direccionCatedras,direccionDocentes, direccionSalida, Estructura.formula);
    }

    public static void ejecutar(String direccionCatedras,String direccionDocentes,String direccionSalida,String form, boolean min){
        minimo=min;
        ejecutar(direccionCatedras,direccionDocentes, direccionSalida, form);
    }

    public static void ejecutar(String direccionCatedras,String direccionDocentes,String direccionSalida,boolean min){
        minimo = min;
        ejecutar(direccionCatedras,direccionDocentes, direccionSalida);
    }

}