package org.exa;

import java.util.ArrayList;

public class Errores{
    public static boolean archivoIncorrecto = false;
    public static boolean catedraFaltante = true;
    public static boolean docenteFaltante = true;
    public static boolean datosErroneos = false;
    public static boolean resultadoIncorrecto = false;
    public static boolean variableIncorrecta = false;
    public static boolean errorSintactico = false;

    public static boolean existenErrores(){
        return (archivoIncorrecto || catedraFaltante || docenteFaltante || datosErroneos || resultadoIncorrecto || resultadoIncorrecto || errorSintactico);
    }
    
    private static String archivoIncorrecto_mensaje = "El archivo es incorrecto";
    private static String catedraFaltante_mensaje = "Falta el archivo de catedras";
    private static String docenteFaltante_mensaje = "Falta el archivo de docentes";
    private static String datosErroneos_mensaje = "Hay un error en los datos de entrada";
    private static String resultadoIncorrecto_mensaje = "Hubo un error en la aplicacion de la formula";
    private static String variableIncorrecta_mensaje = "Hay una variable incorrecta dentro de la formula";
    private static String errorSintactico_mensaje = "Hay un error sintactico en la formula";

    public static ArrayList<String> getErrores(){
        ArrayList<String> errores= new ArrayList<String>();
        if(archivoIncorrecto) errores.add(archivoIncorrecto_mensaje);
        if(catedraFaltante) errores.add(catedraFaltante_mensaje);
        if(docenteFaltante) errores.add(docenteFaltante_mensaje);
        if(datosErroneos) errores.add(datosErroneos_mensaje);
        if(resultadoIncorrecto) errores.add(resultadoIncorrecto_mensaje);
        if(variableIncorrecta) errores.add(variableIncorrecta_mensaje);
        if(errorSintactico) errores.add(errorSintactico_mensaje);
        return errores;
    }

}