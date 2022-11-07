package org.exa;

import java.util.HashMap;
import java.util.Map;

public class Docente {
    private String nombre;
    private HashMap<String, Double> variables;
 
    public Docente ( String nombre) {
        this.nombre = nombre;
        variables = new HashMap<>();
    } 
    

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void put(String key, Double value) {
        variables.put(key,value);
    }

    //-----------------------------GETTERS-----------------------------------------
    
    public String getNombre() {
        return nombre;
    }


    public Double getAtributo(String string) {
        return this.variables.get(string);
    }


    public double getSumaHoras() {
        double res = 0.0;

        for (Map.Entry<String,Double> entry : variables.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }


    public void agregarAtributo(String nombre, Double i) {
        this.variables.put(nombre, i);
    
    }
    
    
    public Double getValue(String key) {
        return variables.get(key);
    }


    @Override
    public String toString() {
        // return "Docente [nombre=" + nombre + ", horasT=" + horasT + ", horasP=" + horasP + ", horasTP=" + horasTP
        //         + ", horasPE=" + horasPE + "]";
        return "Docente [nombre=" + nombre + "]";
    }

}
