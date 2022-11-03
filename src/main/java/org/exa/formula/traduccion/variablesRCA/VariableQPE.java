package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQPE extends Traductor{


    public VariableQPE(Catedra c){
        this.catedra = c;
    }


    @Override
    public Double getValue() {
        Double resultado = 1.0;

        double cantInscriptos = catedra.getAtributo("cantInscriptos");
        if ((catedra.getAtributo("horasTP") == 0) && (catedra.getAtributo("horasP") == 0))
            return resultado;
            
        switch(catedra.getAtributo("tipoPE").intValue()) {
            case 0:
                return resultado;
            case 1:
                return Math.ceil(cantInscriptos/ConstanteFormula.cantAlumnosPE_lab);
            case 2:
                return Math.ceil(cantInscriptos/ConstanteFormula.cantAlumnosPE_lab_exp);
            case 3:
                return Math.ceil(cantInscriptos/ConstanteFormula.cantAlumnosPE_alumnos_docentes);
            default:
                return -1.0;
        }
    }
}

