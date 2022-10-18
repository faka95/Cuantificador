package org.exa;

public class Docente {

    private String nombre;
    private int horasT;
    private int horasP;
    private int horasTP;
    private int horasPE;
    public Docente(String nombre, int horasT, int horasP, int horasTP, int horasPE) {
        this.nombre = nombre;
        this.horasT = horasT;
        this.horasP = horasP;
        this.horasTP = horasTP;
        this.horasPE = horasPE;
    }
    @Override
    public String toString() {
        return "Docente [nombre=" + nombre + ", horasT=" + horasT + ", horasP=" + horasP + ", horasTP=" + horasTP
                + ", horasPE=" + horasPE + "]";
    }
    
}
