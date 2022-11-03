package org.exa.formula;

import java.lang.Math;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.exa.Catedra;
import org.exa.Docente;
import org.exa.Estructura;
import org.exa.formula.traduccion.Fabrica;
import org.exa.formula.traduccion.Traductor;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;


public class Formula {

    private static List<String> func = new ArrayList<>();


    /**
     * Elimina las posibles funciones luego de interpretar el string que contiene
     * la expresion de la formula
     * @param varList Conjunto con todas las variables interpretadas de la expresion de la formula
     */
    private Set<String> verificarFunciones(Set<String> varList) {

        Set<String> res = new HashSet<>();

        func.add("max"); //TODO: acomodar mejor

        for (String var : varList) {
            if(!func.contains(var))
                res.add(var);
        }

        return res;
    }


    /**
     * A partir de la formula, se obtienen las variables que forman parte de la 
     * misma, interpretanto el string que almacena dicha formula. 
     * @return Un conjunto con las distintas variables presentes en la formula
     */
    private Set<String> getVariables(){
    
        Set<String> varList = null; 
        StringBuilder sb = null; 
        String expression = Estructura.formula;
       
        sb = new StringBuilder(); 

        varList = new HashSet<String>();

        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(expression);
        while (m.find()){
            varList.add(m.group());
        }
        Set<String> r = this.verificarFunciones(varList);

        return r;
    }


    /**
     * Aplica la formula con todos sus parametros obtenidos de los archivos y contemplando casos especiales.
     * @param minimoUno es una variable boolean donde nos informa atraves de la interfaz si se necesita como minimo un interino.
     * @return boolean informando si se pudo aplicar la formula.
     */
    public boolean chequearFormula(String formula){
        return true;
    }


    /**
     * 
     * @param minimoUno
     * @return
     */
    public boolean aplicarFormula(boolean minimoUno){
        Expression e;

        for (Catedra cat : Estructura.catedras) {
    
            List<Argument> argumentos = this.generadorDeVariables(cat);

            e = new Expression(Estructura.formula);
            this.cargarArgumentos(e, argumentos);
            int resultado = (int)Math.round(e.calculate());

            System.out.println(resultado);
            //Estructura.resultado.put(cat.getNombre(), resultado);

        }

        return true; //TODO verificar
    }


    /**
     * Se agregan los argumentos con los valores correspondiente a la expresion
     * @param e objeto que representa a la expresion de la formula
     * @param argumentos son las distintas variables con sus respectivos valores
     */
    private void cargarArgumentos(Expression e, List<Argument> argumentos) {
        for (Argument argument : argumentos) {
            e.addArguments(argument);
        }
    }

    public List<Argument> generadorDeVariables(Catedra c){
        List<Argument> retorno = new ArrayList<>();

        Set<String> varArchivo = c.getListaAtributos();

        Set<String> varFormula = this.getVariables();

        for (String s : varFormula) {
            Argument argument;
            if(!varArchivo.contains(s)){
                Traductor tr = Fabrica.getVariableObj(s, c);

                Double a = tr.getValue();

                argument = new Argument(s, a);

            }else{
                argument = new Argument(s, c.getAtributo(s));

            }
            retorno.add(argument);
        }
        return retorno;
    }

    public static void main(String[] args) {
        
        Catedra c1 = new Catedra("ciencias");

        c1.agregarAtributo("anioMateria", 2022.0);
        c1.agregarAtributo("horasT", 3.0);
        c1.agregarAtributo("horasP", 240.0);
        c1.agregarAtributo("horasTP", 111.0);
        c1.agregarAtributo("horasPE", 40.0);
        c1.agregarAtributo("tipoPE", 3.0);
        c1.agregarAtributo("cantInscriptos", 60.0);
        c1.agregarAtributo("cantRindieron", 40.0);

        List<Catedra> list = new ArrayList<>();
        list.add(c1);

        Docente d1 = new Docente("Juan");
        d1.agregarAtributo("horasT",2.0);
        d1.agregarAtributo("horasP",1.0);
        d1.agregarAtributo("horasTP",0.0);
        d1.agregarAtributo("horasPE",3.0);

        /*Docente d2 = new Docente("Octavio");
        d2.agregarAtributo("horasT",2.0);
        d2.agregarAtributo("horasP",2.0);
        d2.agregarAtributo("horasTP",2.0);
        d2.agregarAtributo("horasPE",2.0);
        */
        c1.agregarDocente(d1);
        //c1.agregarDocente(d2);
        
        Formula f = new Formula();
        Estructura.formula = "((n/qp) * (horasP + horasTP) + (n/qpe)*horasPE - o)/ (max(3,horasP+horasPE ))";
        
        Estructura.catedras = list;
        f.aplicarFormula(false);

    }


}
