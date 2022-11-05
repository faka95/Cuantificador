package org.exa.formula.traduccion.variablesRCA;


import org.exa.Catedra;
import org.exa.formula.traduccion.Traductor;

public class VariableN extends Traductor{

    
    public VariableN(Catedra c){
        this.catedra = c;
    }
    
    
    @Override
    public Double getValue() {
        return (catedra.getAtributo("cantInscriptos")+catedra.getAtributo("cantRindieron"))/ 2;
    }
    
}
