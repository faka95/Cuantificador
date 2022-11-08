package org.exa.formula;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.exa.Catedra;
import org.exa.Errores;
import org.exa.Estructura;
import org.exa.formula.traduccion.Fabrica;
import org.exa.formula.traduccion.Traductor;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;


public class Formula {

    private static List<String> funcionesAceptadas = new ArrayList<>(){{
        add("max");
    }};


    /**
     * Elimina las posibles funciones luego de interpretar y obtener las variables de
     * la expresion de la formula
     * @param variables Conjunto con todas las variables interpretadas de la expresion de la formula
     */
    private Set<String> verificarFunciones(Set<String> variables) {
        Set<String> resultado = new HashSet<>();

        for (String var : variables) {
            if(!funcionesAceptadas.contains(var))
            resultado.add(var);
        }

        return resultado;
    }


    /**
     * A partir de la formula, se obtienen las variables que forman parte de la 
     * misma, interpretando el string que almacena dicha formula. 
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
        Set<String> resultado = this.verificarFunciones(varList);

        return resultado;
    }


    /**
    * Setea el flag de errorSintactico de acuerdo a la sintaxis de la formula
    * @param formula es la formula que queremos evaluar
    * @return boolean informando si la formula está bien escrita
    */
    public static boolean chequearFormula(String formula){
        Expression e = new Expression(formula);
        boolean res = !e.checkLexSyntax();
        Errores.errorSintactico = res;
        return res;
    }


    /**
     * Aplica la formula con todos sus parametros obtenidos de los archivos y contemplando casos especiales.
     * @param minimoUno es una variable boolean donde nos informa atraves de la interfaz si se necesita como minimo un interino.
     * @return boolean informando si se pudo aplicar la formula.
     */
    public boolean aplicarFormula(boolean minimoUno){
        Expression e;

        for (Catedra cat : Estructura.catedras) {  
            List<Argument> argumentos = this.generadorDeVariables(cat);

            e = new Expression(Estructura.formula);
            this.cargarArgumentos(e, argumentos);

            int resultado = (int)Math.round(e.calculate());

            // Casos especiales
            if(resultado == 0 && minimoUno)
                resultado = 1;
            if(cat.getCantDocentes() == 1 && resultado == 0)
                resultado = 1;
            if(cat.getCantDocentes() == 0 && resultado < 2)
                resultado = 2;

            Estructura.resultado.put(cat.getNombre(), resultado);

        }

        return true; //TODO verificar
    }


    /**
     * Se agregan los argumentos con los valores correspondiente a la expresion
     * 
     * @param e objeto que representa a la expresion de la formula
     * @param argumentos son las distintas variables con sus respectivos valores
     */
    private void cargarArgumentos(Expression e, List<Argument> argumentos) {
        for (Argument argument : argumentos) {
            e.addArguments(argument);
        }
    }


    /**
     * A partir de las variables que se obtienen de las columnas de los archivos (cargados
     * en la clase de la catedra) y de las variables que se interpretan de la expresion 
     * dada por el usuario, se realiza lo siguiente: 
     *     - Si hay una correspondencia directa, entonces se obtiene el valor directamente
     *     - Si una variable no se encuentra en el archivo pero si en la formula, entonces se
     *       debera definir una clase que extiende de traduccion.Traduccion.java y definir 
     *       en el metodo getValue() el comportamiento que debe tener
     * 
     * @param catedra catedra actual de la cual se obtienen los atributos que fueron cargados en los archivos
     * @return lista de argumentos que formaran parte de la expresion de la formula
     */
    public List<Argument> generadorDeVariables(Catedra catedra){
        List<Argument> retorno = new ArrayList<>();

        Set<String> varArchivo = catedra.getListaAtributos();
        Set<String> varFormula = this.getVariables();

        for (String s : varFormula) {
            Argument argument;

            if(!varArchivo.contains(s)){
                Traductor tr = Fabrica.getVariableTraductor(s, catedra);
                tr = Fabrica.verificarInstancia(tr);
                argument = new Argument(s, tr.getValue());

            }else{
                Double a = catedra.getAtributo(s);
                argument = new Argument(s, a);
            }
            retorno.add(argument);
        }

        return retorno;
    }

}
