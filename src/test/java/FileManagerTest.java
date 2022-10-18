import org.exa.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;

public class FileManagerTest {

    @Test
    public void guardarFormulaTest() throws IOException { // test método guardarFormula
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\test.txt"; // path para el archivo de formula
        Estructura.pathFormula = path;
        FileManager.guardarFormula("1+2*3"); // metodo a testar
        String resultado = new String(Files.readAllBytes(Paths.get(path))); // obtengo resultado
        Assertions.assertEquals("1+2*3",resultado); // asert esperado-resultado
    }
}
