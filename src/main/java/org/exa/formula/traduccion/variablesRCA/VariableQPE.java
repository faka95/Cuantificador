package org.exa.formula.traduccion.variablesRCA;

import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQPE extends Traductor{


    @Override
    public Double getValue() {

        return ConstanteFormula.QPE;

    }
}

