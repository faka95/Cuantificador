package org.exa.formula.traduccion;

import org.exa.Catedra;
import org.exa.formula.traduccion.variablesRCA.*;
import org.exa.constantes.ConstanteVariable;

public class Fabrica {

    public static Traductor getVariableObj(String nombre, Catedra cat){

        if(nombre.equals(ConstanteVariable.N)){
            return new VariableN(cat);
        } else if (nombre.equals(ConstanteVariable.O)){
            return new VariableO(cat);
        } else if (nombre.equals(ConstanteVariable.QP)){
            return new VariableQP(cat);
        }else if (nombre.equals(ConstanteVariable.QPE)){
            return new VariableQPE(cat);
        }
        return null;
    }

}
