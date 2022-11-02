package org.exa;

public class Errores{
    public static boolean archivoIncorrecto = false;
    public static boolean catedraFaltante = true;
    public static boolean docenteFaltante = true;
    public static boolean datosErroneos = false;
    public static boolean resultadoIncorrecto = false;
    public static boolean variableIncorrecta = false;
    public static boolean errorSintactico = false;

    public static boolean existenErrores(){
        return !(archivoIncorrecto && catedraFaltante && docenteFaltante && datosErroneos && resultadoIncorrecto && resultadoIncorrecto && errorSintactico);
    }

}