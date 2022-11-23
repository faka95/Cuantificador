package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstVariable;
import org.exa.formula.traduccion.Traductor;

public class VariableN extends Traductor{

    
    public VariableN(Catedra c){
        this.catedra = c;
    }
    
    
    @Override
    public Double getValue() {
        return (catedra.getAtributo(ConstVariable.CANT_INSCRIPTOS) + catedra.getAtributo(ConstVariable.CANT_RINDIERON))/ 2;
    }
    
}
