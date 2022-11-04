package org.exa.formula.traduccion;

import org.exa.Catedra;
import org.exa.Errores;
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

    
    public static Traductor verificarInstancia(Traductor tr, String var) {
        if(tr == null){
            Errores.variableIncorrecta = false; 
            System.out.println("La variable "+ var + " NO fue declarada");
            return new Traductor() {
                @Override
                public Double getValue() {
                    return -1.0;
                }
            };  // TODO: verificar si se modifica la variable correcta
        }

        return tr;
    }

}
