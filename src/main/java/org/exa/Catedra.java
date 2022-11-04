package org.exa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Catedra {
    private String nombre;
    private HashMap<String, Double> variables;
    private List<Docente> docentes;


    public Catedra(String nombre){
        this.nombre = nombre;
        variables = new HashMap<>();
        docentes = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
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


    public List<Docente> getDocentes(){
        return this.docentes;
    }


    public int cantAtributos() {
        return 0;
    }


    public void agregarAtributo(String nombre, Double i) {
        this.variables.put(nombre, i);
    }


	public Set<String> getListaAtributos() {
        Set<String> res = new HashSet<>();

        for (Map.Entry<String,Double> entry : variables.entrySet()) {
            res.add(entry.getKey());
        }

		return res;
	}
    
}

