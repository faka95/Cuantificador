package org.exa.formula;

import java.util.ArrayList;
import java.util.List;

import org.exa.Catedra;
import org.exa.Docente;
import org.exa.constantes.ConstVariable;

public class Utils {
    
    public static void cargarCatedra(Catedra c1){

        c1.agregarAtributo(ConstVariable.ANIO_MATERIA, 1.0);
        c1.agregarAtributo(ConstVariable.HORAS_P, 2.0);
        c1.agregarAtributo(ConstVariable.HORAS_TP, 1.0);
        c1.agregarAtributo(ConstVariable.HORAS_PE, 0.0);
        c1.agregarAtributo(ConstVariable.TIPO_PE, 3.0);
        c1.agregarAtributo(ConstVariable.CANT_INSCRIPTOS, 60.0);
        c1.agregarAtributo(ConstVariable.CANT_RINDIERON, 40.0);

        List<Catedra> list = new ArrayList<>();
        list.add(c1);

        Docente d1 = new Docente("Juan");
        d1.agregarAtributo(ConstVariable.HORAS_P,1.0);
        d1.agregarAtributo(ConstVariable.HORAS_TP,3.0);
        d1.agregarAtributo(ConstVariable.HORAS_PE,0.0);

        c1.agregarDocente(d1);
    }
}
