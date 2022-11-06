package org.exa.formula.traduccion.variablesRCA;

import org.exa.Catedra;
import org.exa.constantes.ConstVariable;
import org.exa.constantes.ConstanteFormula;
import org.exa.formula.traduccion.Traductor;

public class VariableQPE extends Traductor{

    private Traductor n;

    
    public VariableQPE(Catedra c){
        this.catedra = c;
        this.n = new VariableN(c);
    }


    private Double getQPE(){
        Double resultado = 1.0;

        double cantInscriptos = catedra.getAtributo(ConstVariable.CANT_INSCRIPTOS);
        if ((catedra.getAtributo(ConstVariable.HORAS_TP) == 0) && (catedra.getAtributo(ConstVariable.HORAS_P) == 0))
            return resultado;
            
        switch(catedra.getAtributo(ConstVariable.TIPO_PE).intValue()) {
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


    @Override
    public Double getValue() {
        Double qpe = this.getQPE();
        
        if(qpe < 1.f){
            Double n = this.n.getValue();
            qpe = n; 
        }
        return qpe;
    }
}

