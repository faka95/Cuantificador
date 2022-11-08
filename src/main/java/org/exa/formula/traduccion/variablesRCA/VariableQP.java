package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstVariable;
import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQP extends Traductor{
    
    
    public VariableQP(Catedra c){
        this.catedra = c;
    }


    @Override
    public Double getValue() {
        
        Double anioMateria = this.catedra.getAtributo(ConstVariable.ANIO_MATERIA);

        if(anioMateria <= 2)
            return ConstanteFormula.QP_PRIMER_ANIO;

        return ConstanteFormula.QP_ULTIMOS_ANIOS;
    }

}