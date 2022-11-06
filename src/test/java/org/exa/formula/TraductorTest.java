package org.exa.formula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.exa.Catedra;
import org.exa.Errores;
import org.exa.formula.traduccion.Fabrica;
import org.exa.formula.traduccion.Traductor;
import org.junit.jupiter.api.Test;

public class TraductorTest {
 
    private Traductor tr;


    @Test
    public void crearTraductorErroneo(){

        Catedra c1 = new Catedra("ciencias");
        Utils.cargarCatedra(c1);

        // Se crea una variable que no esta definida
        tr = Fabrica.getVariableTraductor("xrt", c1);

        Traductor resultado = Fabrica.verificarInstancia(tr);

        Double valoresResultado = resultado.getValue();
        Double valoresEsperado = -1.0;

        assertEquals(valoresResultado, valoresEsperado);

        boolean chequeo = Errores.variableIncorrecta;

        boolean chequeoEsperado = true;

        assertEquals(chequeo, chequeoEsperado);
    }   

    
}
