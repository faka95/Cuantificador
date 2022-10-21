package org.exa;

import java.lang.Math;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;


public class Formula {

    public boolean aplicarFormula(boolean minimoUno){
        int horasP, horasPE, o, horasTP;
        float n;
        double qp;
        double qpe;

        Expression e = new Expression(Estructura.formula);
        // el siguiente metodo retorna verdadero si la expresion es correcta
        if(!e.checkSyntax())
            return false;

        for (Catedra cat : Estructura.catedras) {
            n = (cat.getCantInscriptos() + cat.getCantRindieron())/2; //cantidad media de alumnos

            horasP = cat.getHorasP();
            horasTP = cat.getHorasTP();
            horasPE = cat.getHorasPE();
            o = horasP + horasPE + horasTP; // Horas practicas semanales

            // Para los casos de practicas con un menor numero de alumnos por docente
            // que lo que se establece en qp y qpe (cuando esto pasa estos valores valen menos que 1)
            // se consideraran los cocientes n/qp=1 y n/qpe=1
            qp = getQP(cat);
            if(qp < 1.f)
                qp = n;
            qpe = getQPE(cat);
            if(qpe < 1.f)
                qpe = n;

            Argument nVar= new Argument("n", n);
            Argument oVar= new Argument("o", o);
            Argument pVar= new Argument("p", horasP);
            Argument peVar= new Argument("pe", horasPE);
            Argument tpVar= new Argument("pe", horasTP);
            Argument qpVar= new Argument("qp", qp);
            Argument qpeVar= new Argument("qpe", qpe);

            e = new Expression(Estructura.formula, nVar, oVar, pVar, peVar, tpVar, qpVar, qpeVar);

            int resultado = (int)Math.round(e.calculate());
            // Casos especiales
            if(resultado == 0 && minimoUno)
                resultado = 1;
            if(cat.getCantDocentes() == 1 && resultado == 0)
                resultado = 1;
            if(cat.getCantDocentes() == 0 && resultado < 2)
                resultado = 2;
            //evaluacion de la formula. Retorna Double.NaN en caso de error en la evaluacion
            Estructura.resultado.put(cat.getNombre(), resultado);
        }
        return true;
    }

    public  Double  getQP (Catedra catedraAsociada){ 
        Double resultado= 1.0;
        if ((catedraAsociada.getHorasTP() == 0 ) && (catedraAsociada.getHorasP() == 0))
            return resultado;
        if (catedraAsociada.getAnioMateria() < 3)
            resultado = Math.ceil( (double) catedraAsociada.getCantInscriptos()/Constante.cantAlumnosDocentePrimeros);
        else
            resultado = Math.ceil( (double) catedraAsociada.getCantInscriptos()/Constante.cantAlumnosDocenteUltimos);
        return resultado;    
    }

    public  Double  getQPE (Catedra catedraAsociada){
        Double resultado= 1.0;
        if ((catedraAsociada.getHorasTP() == 0 ) && (catedraAsociada.getHorasP() == 0))
            return resultado;
            
        switch(catedraAsociada.getTipoPE()) {
            case 0:
                return resultado;
            case 1:
                //"Corresponde al laboratorio con informatica"
                return Math.ceil(catedraAsociada.getCantInscriptos()/Constante.cantAlumnosPE_lab);
            case 2:
                //"Corresponde al laboratorio experimental"
                return Math.ceil(catedraAsociada.getCantInscriptos()/Constante.cantAlumnosPE_lab_exp);
            case 3:
                //"Corresponde a las calses de practicas docentes"
                return Math.ceil(catedraAsociada.getCantInscriptos()/Constante.cantAlumnosPE_alumnos_docentes);
            default:
                //"La catedra no presenta practicas especiales"
                return -1.0;
            }
    }

}
