package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstVariable;
import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQP extends Traductor{

    private Traductor n;

    
    public VariableQP(Catedra c){
        this.catedra = c;
        this.n = new VariableN(c);
    }


    private Double getQP(){
        Double resultado = 1.0;

        double cantInsciptos = catedra.getAtributo(ConstVariable.CANT_INSCRIPTOS);
        if ((catedra.getAtributo(ConstVariable.HORAS_TP) == 0) && (catedra.getAtributo(ConstVariable.HORAS_P) == 0))
            return resultado;
        if (catedra.getAtributo(ConstVariable.ANIO_MATERIA) < 3)
            resultado = Math.ceil((double) cantInsciptos /ConstanteFormula.cantAlumnosDocentePrimeros);
        else
            resultado = Math.ceil((double) cantInsciptos /ConstanteFormula.cantAlumnosDocenteUltimos);
        return resultado;

    }


    @Override
    public Double getValue() {
        Double qp = this.getQP();

        if(qp < 1.f){
            Double n = this.n.getValue();
            qp = n;
        }

        return qp;
    }

}