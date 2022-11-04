import org.exa.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

public class FileManagerTest {

    @Test
    public void guardarFormulaTest() throws IOException { // test metodo guardarFormula
        String path = System.getProperty("user.dir")+"/src/test/java/test.txt"; // path para el archivo de formula
        Estructura.pathFormula = path;
        FileManager.guardarFormula("1+2*3"); // metodo a testear
        String resultado = new String(Files.readAllBytes(Paths.get(path))); // obtengo resultado
        Assertions.assertEquals("1+2*3",resultado); // assert esperado-resultado
    }

   /* @Test
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
    }*/
 
   /* @Test
    public void cargarFormulaTest() throws Exception{
       String path = System.getProperty("user.dir")+"/src/test/java";
       Estructura.pathFormula = path + "/formula.txt";
       FileManager.cargarFormula();
       String formulaEsperada = "2+5";
       String formula = Estructura.formula;
       Assertions.assertEquals(formulaEsperada,formula);
    }

    @Test
    public void generarSalidaTest()throws IOException{
        String path = System.getProperty("user.dir")+"/src/test/java";
        FileManager.cargarCatedra(path + "/Catedra.csv"); // carga catedras en Estructura
        FileManager.generarSalida(path); // genera archivo de salida csv con las catedras encontradas
        String fileOutput = "", expectedOutput = "";
        for (Catedra c : Estructura.catedras){ // se carga el resultado esperado dentro del csv
            expectedOutput += c.getNombre() + "," + Estructura.resultado.get(c.getNombre()) + "\n";
        }
        
        FileReader reader = new FileReader(new File(path + "/salida.csv")); // se lee el archivo csv
        int read = reader.read();
        while (read != -1){
            fileOutput += (char) read;
            read = reader.read();
        }
        Assertions.assertEquals(fileOutput,expectedOutput); // se verifica que el contenido en el archivo y el esperado sean identicos
	}*/
}
