package org.exa.formula.traduccion.variablesRCA;

import java.util.List;

import org.exa.Catedra;
import org.exa.Docente;
import org.exa.formula.traduccion.Traductor;

public class VariableO extends Traductor{

    public VariableO(Catedra c){
        this.catedra = c;
    }

    @Override
    public Double getValue() {
        List<Docente> list = catedra.getDocentes();
        double res = 0.0;

        for (Docente docente : list) {
            res += docente.getSumaHoras();
        }
        return res;
    }
}