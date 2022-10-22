package org.exa;

import java.util.ArrayList;
import java.util.List;

public class Catedra {
    private String nombre;
    private int anioMateria;
    private int horasT;
    private int horasP;
    private int horasTP;
    private int horasPE;

    private int tipoPE;
    private int cantInscriptos;
    private int cantRindieron;

    private List<Docente> docentes;



    public Catedra(String nombre, int anioMateria, int horasT, int horasP, int horasTP, int horasPE, int tipoPE,
            int cantInscriptos, int cantRindieron) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.horasT = horasT;
        this.horasP = horasP;
        this.horasTP = horasTP;
        this.horasPE = horasPE;
        this.tipoPE = tipoPE;
        this.cantInscriptos = cantInscriptos;
        this.cantRindieron = cantRindieron;
        docentes = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void agregarDocente(Docente docente){
        docentes.add(docente);
    }

    @Override
    public String toString() {
        return  docentes.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Catedra compare = (Catedra) obj;
        return this.toString().equals(compare.toString());
    }
}
