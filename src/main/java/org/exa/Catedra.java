package org.exa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catedra {
    private String nombre;
    private HashMap<String, Float> variables;
    private List<Docente> docentes;

    /*private int anioMateria;
    private int horasT;
    private int horasP;
    private int horasTP;
    private int horasPE;

       //0 = sin lab |  1 = lab de informatica | 
       //2 = lab para practicas experimentales | 3 = practicas docentes
    
    private int tipoPE; //AGREGAR A ARCHIVO. 
    private int cantInscriptos;
    private int cantRindieron;
    */
    
    //---------------------------CONSTRUCTOR------------------------------------------- 

    public Catedra(String nombre) {
        this.nombre = nombre;
        variables = new HashMap<>();
        docentes = new ArrayList<>();
    }


    //---------------------------SETTERS-----------------------------------------------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public void setAnioMateria(int anioMateria) {
    //     this.anioMateria = anioMateria;
    // }

    // public void setHorasT(int horasT) {
    //     this.horasT = horasT;
    // }

    // public void setHorasP(int horasP) {
    //     this.horasP = horasP;
    // }

    // public void setHorasTP(int horasTP) {
    //     this.horasTP = horasTP;
    // }

    // public void setHorasPE(int horasPE) {
    //     this.horasPE = horasPE;
    // }

    // public void setTipoPE(char tipoPE) {
    //     this.tipoPE = tipoPE;
    // }

    // public void setCantInscriptos(int cantInscriptos) {
    //     this.cantInscriptos = cantInscriptos;
    // }

    // public void setCantRindieron(int cantInscriptos) {
    //     this.cantInscriptos = cantInscriptos;
    // }

    // public void setDocentes (List<Docente> docentes) {
    //     this.docentes = docentes;
    // }

     //-----------------------------GETTERS-----------------------------------------

    public String getNombre() {
        return nombre;
    }

    // public int getAnioMateria() {
    //     return anioMateria;
    // }

    // public int getHorasT() {
    //     return horasT;
    // }

    // public int getHorasP() {
    //     return horasP;
    // }

    // public int getHorasTP() {
    //     return horasTP;
    // }

    // public int getHorasPE() {
    //     return horasPE;
    // }

    // public int getTipoPE(){
    //     return tipoPE;
    // }

    // public int getCantInscriptos() {
    //     return cantInscriptos;
    // }

    // public int getCantRindieron() {
    //     return cantRindieron;
    // }

    // public List<Docente> getDocentes() {
    //     List<Docente> aux = this.docentes;
    //     return aux;
    // }

    // public int getCantDocentes() {
    //     return docentes.size();
    // }



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
