package org.exa;

import java.lang.Math;

import org.exa.constantes.ConstanteFormula;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;


public class Formula {

    /**
     * Aplica la formula con todos sus parametros obtenidos de los archivos y contemplando casos especiales.
     * @param minimoUno es una variable boolean donde nos informa atraves de la interfaz si se necesita como minimo un interino.
     * @return boolean informando si se pudo aplicar la formula.
     */
    public boolean chequearFormula(String formula){
        return true;
    }

    public boolean aplicarFormula(boolean minimoUno){
        int horasP, horasPE, o, horasTP;
        float n;
        double qp;
        double qpe;

        Expression e = new Expression(Estructura.formula);
        // el siguiente metodo retorna verdadero si la expresion es correcta
        if(!e.checkLexSyntax()) {
            return false;
        }
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
            Argument tpVar= new Argument("tp", horasTP);
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

    /**
     * Calcula la proporcion de alumnos por docente de cada anio.
     * @param catedraAsociada el parametro define un objeto de tipo Catedra.
     * @return un Double que es el resultado de docentes segun el anio de la materia.
     */

    public  Double  getQP (Catedra catedraAsociada){ 
        Double resultado= 1.0;
        if ((catedraAsociada.getHorasTP() == 0 ) && (catedraAsociada.getHorasP() == 0))
            return resultado;
        if (catedraAsociada.getAnioMateria() < 3)
            resultado = Math.ceil( (double) catedraAsociada.getCantInscriptos()/ConstanteFormula.cantAlumnosDocentePrimeros);
        else
            resultado = Math.ceil( (double) catedraAsociada.getCantInscriptos()/ConstanteFormula.cantAlumnosDocenteUltimos);
        return resultado;    
    }

    /**
     * Calcula la proporcion de alumnos por docente segun el tipo de practica especial.
     * @param catedraAsociada el parametro define un objeto de tipo Catedra.
     * @return un Double que es el resultado de docentes segun el tipo de practica especial.
     */
    public  Double  getQPE (Catedra catedraAsociada){
        Double resultado= 1.0;
        if ((catedraAsociada.getHorasTP() == 0 ) && (catedraAsociada.getHorasP() == 0))
            return resultado;
            
        switch(catedraAsociada.getTipoPE()) {
            case 0:
                return resultado;
            case 1:
                //"Corresponde al laboratorio con informatica"
                return Math.ceil(catedraAsociada.getCantInscriptos()/ConstanteFormula.cantAlumnosPE_lab);
            case 2:
                //"Corresponde al laboratorio experimental"
                return Math.ceil(catedraAsociada.getCantInscriptos()/ConstanteFormula.cantAlumnosPE_lab_exp);
            case 3:
                //"Corresponde a las calses de practicas docentes"
                return Math.ceil(catedraAsociada.getCantInscriptos()/ConstanteFormula.cantAlumnosPE_alumnos_docentes);
            default:
                //"La catedra no presenta practicas especiales"
                return -1.0;
            }
    }
}
