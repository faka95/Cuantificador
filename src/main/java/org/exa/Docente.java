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
}
