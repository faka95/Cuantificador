package org.exa;

public class Docente {
    private String nombre;
    private int horasT;
    private int horasP;
    private int horasTP;
    private int horasPE;


    //---------------------------CONSTRUCTOR------------------------------------------- 

    public Docente ( String nombre , int horasT , int horasP , int horasTP , int horasPE ) {
         this.nombre = nombre;
         this.horasT = horasT;
         this.horasP = horasP;
         this.horasTP = horasTP;
         this.horasPE = horasPE;
    }

    //---------------------------SETTERS-----------------------------------------------
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }

    public void setHorasP(int horasP) {
        this.horasP = horasP;
    }

    public void setHorasTP(int horasTP) {
        this.horasTP = horasTP;
    }

    public void setHorasPE(int horasPE) {
        this.horasPE = horasPE;
    }

    //-----------------------------GETTERS-----------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public int getHorasT() {
        return horasT;
    }

    public int getHorasP() {
        return horasP;
    }

    public int getHorasTP() {
        return horasTP;
    }

    public int getHorasPE() {
        return horasPE;
    }
    

    @Override
    public String toString() {
        return "Docente [nombre=" + nombre + ", horasT=" + horasT + ", horasP=" + horasP + ", horasTP=" + horasTP
                + ", horasPE=" + horasPE + "]";
    }
    
}
