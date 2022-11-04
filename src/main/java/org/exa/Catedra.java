package org.exa;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Catedra {
    private String nombre;
    private HashMap<String, Float> variables;
    private List<Docente> docentes;
    
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

    public void putValue(String key, Float value) {
        variables.put(key, value);
    }

     //-----------------------------GETTERS-----------------------------------------

    public String getNombre() {
        return nombre;
    }

    public Float getValue(String key) {
        return variables.get(key);
    }

    public Set<String> getKeys() {
        return variables.keySet();
    }

    //-----------------------------CLASS-METHODS-----------------------------------------

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
