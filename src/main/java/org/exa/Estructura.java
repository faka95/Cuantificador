package org.exa;

import java.util.List;
import java.util.Map;

public class Estructura {
    public static List<Catedra> catedras;
    public static Map<String, Integer> resultado;
    public static String formula; 
    public static String pathFormula;


    /**
     * Busca en la lista de catedras la catedra con el mismo nombre
     * @param name Nombre de la catedra a buscar
     * @return Catedra buscada en caso de ser correcto, null en caso de no encontrarla
     */
    public static Catedra getCatedraByName(String name){
        for(Catedra catedra: catedras){
            if(catedra.getNombre().equals(name))
                return catedra;
        }
        return null;
    }

}
