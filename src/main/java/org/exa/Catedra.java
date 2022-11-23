package org.exa;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Catedra {

    private String nombre;
    private HashMap<String, Double> variables;
    private List<Docente> docentes;


    public Catedra(String nombre) {
        this.nombre = nombre;
        variables = new HashMap<>();
        docentes = new ArrayList<>();
    }


    public Catedra(String nombre, HashMap<String, Double> variables){
        this.nombre = nombre;
        this.variables = variables;
        docentes = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }


    public void putValue(String key, Double value) {
        variables.put(key, value);
    }


    public int cantAtributos() {
        return 0;
    }


    public Double getValue(String key) {
        return variables.get(key);
    }


    public Set<String> getKeys() {
        return variables.keySet();
    }


    public int getCantDocentes() {
        return docentes.size();
    }


    @Override
    public String toString() {
        return "Catedra [nombre=" + nombre + ", variables=" + variables + ", docentes=" + docentes + "]";
    }


    public boolean equals(Object obj) {
        Catedra compare = (Catedra) obj;
        return this.toString().equals(compare.toString());
    }


    public void agregarDocente(Docente docente){
        docentes.add(docente);
    }


    public Double getAtributo(String string) {

        Double res = this.variables.get(string);;

        if(res == null){
            res = -1.0;
            System.out.println("Variable dinamica no encontrada!");
            Errores.variableIncorrecta = true;
        }

        return res;
    }


	public Set<String> getListaAtributos() {
        Set<String> res = new HashSet<>();

        for (Map.Entry<String,Double> entry : variables.entrySet()) {
            res.add(entry.getKey());
        }

		return res;
	}

    
    public List<Docente> getDocentes(){
        return this.docentes;
    }
}
