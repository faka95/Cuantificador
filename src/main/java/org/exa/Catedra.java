package org.exa;

import java.util.ArrayList;
import java.util.List;

public class Catedra {
    private String nombre;
    private int horasT;
    private int horasP;
    private int horasTP;
    private int horasPE;

    private int cantInscriptos;
    private int cantRindieron;

    private List<Docente> docentes;

    public Catedra(String nombre, int horasT, int horasP, int horasTP, int horasPE, int cantInscriptos,
            int cantRindieron) {
        this.nombre = nombre;
        this.horasT = horasT;
        this.horasP = horasP;
        this.horasTP = horasTP;
        this.horasPE = horasPE;
        this.cantInscriptos = cantInscriptos;
        this.cantRindieron = cantRindieron;
        this.docentes = new ArrayList();
    }

    public String getNombre(){
        return nombre;
    }

    public void agregarDocente(Docente docente){
        docentes.add(docente);
    }

    @Override
    public String toString() {
        return "Catedra [nombre=" + nombre + ", horasT=" + horasT + ", horasP=" + horasP + ", horasTP=" + horasTP
                + ", horasPE=" + horasPE + ", cantInscriptos=" + cantInscriptos + ", cantRindieron=" + cantRindieron
                + ", docentes=" + docentes + "]";
    }
}
