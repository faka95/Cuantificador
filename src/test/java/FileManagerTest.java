import org.exa.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void cargarCatedraDocente() throws Exception{
        String path = System.getProperty("user.dir")+"/src/test/java";
        
        FileManager.cargarCatedra(path + "/Catedra.csv");
        FileManager.cargarDocente(path + "/Docente.csv");
        List<Catedra> catedras = Estructura.catedras;
        List<Catedra> catedrasEsperadas = new ArrayList<>();
        Catedra cat = new Catedra("Matematica",2022, 3, 2, 1, 0,3, 60, 40);
        cat.agregarDocente(new Docente("Pedro",2,1,0,3));
        catedrasEsperadas.add(cat);
        Catedra cat2 = new Catedra("Fisica",2022, 3, 2, 1, 0, 3, 60,40);
        cat2.agregarDocente(new Docente("Maxi",2,1,0,3));
        catedrasEsperadas.add(cat2);
        Catedra cat3 = new Catedra("Programacion",2022, 3, 2, 1,0,3 , 60, 40);
        cat3.agregarDocente(new Docente("Maria",2,1,0,3));
        catedrasEsperadas.add(cat3);
        Catedra cat4 = new Catedra("Discreta",2022, 3, 2, 1, 0,3, 60, 40);
        cat4.agregarDocente(new Docente("Victoria",2,1,0,3));
        catedrasEsperadas.add(cat4);
        Catedra cat5 = new Catedra("Lineal",2022, 3, 2, 1, 0,3, 60, 40);
        cat5.agregarDocente(new Docente("Pablo",2,1,0,3));
        catedrasEsperadas.add(cat5);

        Assertions.assertEquals(catedrasEsperadas,catedras); 
    }
}
