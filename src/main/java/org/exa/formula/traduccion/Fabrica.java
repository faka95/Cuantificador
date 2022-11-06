package org.exa.formula.traduccion;

import org.exa.Catedra;
import org.exa.Errores;
import org.exa.formula.traduccion.variablesRCA.*;
import org.exa.constantes.ConstVariable;

public class Fabrica {

    public static Traductor getVariableTraductor(String nombre, Catedra cat){

        if(nombre.equals(ConstVariable.N)){
            return new VariableN(cat);
        } else if (nombre.equals(ConstVariable.O)){
            return new VariableO(cat);
        } else if (nombre.equals(ConstVariable.QP)){
            return new VariableQP(cat);
        }else if (nombre.equals(ConstVariable.QPE)){
            return new VariableQPE(cat);
        }

        return null;
    }

    
    /**
     * Verifica que la el traductor dado por parametro no sea nulo
     * @param tr traductor el cual puede ser o no nulo
     * @return en caso de que no sea nulo, retorna una referencia hacia el mismo traductor. 
     *         Caso contrario, retorna una clase anonima, donde en el metodo getValue se define un valor discernible
     */
    public static Traductor verificarInstancia(Traductor tr) {
        if(tr == null){
            Errores.variableIncorrecta = true; 
            System.out.println("Variable NO declarada");

            return new Traductor() {
                @Override
                public Double getValue() {
                    return -1.0;
                }
            }; 
        }

        return tr;
    }

}
