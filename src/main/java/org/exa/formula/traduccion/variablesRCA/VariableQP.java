package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQP extends Traductor{

    public VariableQP(Catedra c){
        this.catedra = c;
    }

    @Override
    public Double getValue() {
        Double resultado = 1.0;
        double cantInsciptos = catedra.getAtributo("cantInscriptos");
        if ((catedra.getAtributo("horasTP") == 0) && (catedra.getAtributo("HorasP") == 0))
            return resultado;
        if (catedra.getAtributo("anioMateria") < 3)//CORREGIR ANIO MATERIA
            resultado = Math.ceil((double) cantInsciptos /ConstanteFormula.cantAlumnosDocentePrimeros);
        else
            resultado = Math.ceil((double) cantInsciptos /ConstanteFormula.cantAlumnosDocenteUltimos);
        return resultado;
    }
}