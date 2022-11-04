package org.exa;

import java.util.HashMap;

public class Docente {
    private String nombre;
    private HashMap<String, Float> variables;

    //---------------------------CONSTRUCTOR------------------------------------------- 
    
    public Docente ( String nombre) {
        this.nombre = nombre;
        variables = new HashMap<>();
   }

    //---------------------------SETTERS-----------------------------------------------
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void put(String key, Float value) {
        variables.put(key,value);
    }

    //-----------------------------GETTERS-----------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public Float getValue(String key) {
        return variables.get(key);
    }

    @Override
    public String toString() {
        // return "Docente [nombre=" + nombre + ", horasT=" + horasT + ", horasP=" + horasP + ", horasTP=" + horasTP
        //         + ", horasPE=" + horasPE + "]";
        return "Docente [nombre=" + nombre + "]";
    }
    
}
