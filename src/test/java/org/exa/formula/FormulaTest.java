package org.exa.formula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.exa.Catedra;
import org.exa.Estructura;
import org.exa.constantes.ConstVariable;
import org.junit.jupiter.api.Test;
import org.mariuszgromada.math.mxparser.Argument;


/**
 * Testeo de los metodos de la clase Formula. 
 * Notar que para testear los metodos que son privados se hace uso de reflexion
 */
public class FormulaTest {

    Formula f = new Formula();


    @Test
    public void testVerificarFunciones() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        Set<String> variables = new HashSet<>(){{
            add("a");
            add("b");
            add("c");
            add("max");
        }};

        Method method = Formula.class.getDeclaredMethod("verificarFunciones", Set.class);
        method.setAccessible(true);

        Set<String> varResultado = (Set<String>)method.invoke(f, variables);

        Set<String> varResultadoEsperado = new HashSet<>(){{
            add("a");
            add("b");
            add("c");
        }};

        assertEquals( varResultado, varResultadoEsperado);
    }


    @Test
    public void testInterpreteVariables() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

        Set<String> variablesEsperadas = new HashSet<>(){{
            add("a");
            add("b");
            add("c");
        }};

        Estructura.formula = "a/b + c*a + 2";

        Method method = Formula.class.getDeclaredMethod("getVariables");
        method.setAccessible(true);

        Set<String> variablesResultado = (Set<String>)method.invoke(f);

        assertEquals(variablesResultado, variablesEsperadas);
    }


    /**
     * Clase anidada, usada de respaldo para solucionar el problema de que la biblioteca
     * mxparser no tiene definido el metodo equals() por lo que no se puede hacer
     * un AssertEquals para testeo. 
     */
    private class ArgumentTest{

        public String nombre;
        public Double valor;

        public ArgumentTest(String nombre, Double valor){
            this.nombre = nombre;
            this.valor = valor;
        }


        @Override
        public boolean equals(Object obj) {
            ArgumentTest otroArgumento = (ArgumentTest)(obj);

            boolean a = this.nombre.equals(otroArgumento.nombre) && this.valor.equals(otroArgumento.valor);
            return a;
        }
    };


    /**
     * Convierte una lista que contiene objetos de la biblioteca mxparser a una 
     * lista cuyos objetos tienen definido el metodo equals() en la clase ArgumentTest
     * @param listaArgumentos 
     * @return
     */
    public List<ArgumentTest> convertirLista(List<Argument> listaArgumentos){
            
        List<ArgumentTest> resultado = new ArrayList<>();

        for (Argument var : listaArgumentos) {
            resultado.add(new ArgumentTest(var.getArgumentName(), var.getArgumentValue()));
        }
        
        return resultado;
    }


    @Test
    public void testGeneradorDeVariables() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Catedra c1 = new Catedra("prog1");
        Utils.cargarCatedra(c1);

        Method method = Formula.class.getDeclaredMethod("generadorDeVariables", Catedra.class);
        method.setAccessible(true);

        Estructura.formula = ConstVariable.HORAS_P  + "+" + ConstVariable.HORAS_TP + "+" + ConstVariable.QP;

        List<Argument> valorResultado = (List<Argument>)method.invoke(f, c1);

        List<Argument> valoresEsperado = new ArrayList<>(){{
            add(new Argument(ConstVariable.HORAS_P, 2.0));
            add(new Argument(ConstVariable.HORAS_TP, 1.0));
            add(new Argument(ConstVariable.QP, 25.0));
        }};

        List<ArgumentTest> a1 = this.convertirLista(valorResultado);
        List<ArgumentTest> a2 = this.convertirLista(valoresEsperado);

        assertEquals(a1, a2);

    }

}
