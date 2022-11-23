import org.exa.*;
import org.exa.constantes.ConstanteFormula;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class FileManagerTest {

    @Test
    public void guardarFormulaTest() throws IOException { // test metodo guardarFormula
        String path = System.getProperty("user.dir")+"/src/test/java/test.txt"; // path para el archivo de formula
        Estructura.pathFormula = path;
        FileManager.guardarFormula("1+2*3"); // metodo a testear
        String resultado = new String(Files.readAllBytes(Paths.get(path))); // obtengo resultado
        Assertions.assertEquals("1+2*3",resultado); // assert esperado-resultado
    }
    

    @Test
    public void  cargarConfigTest() throws IOException {
        String directorio = System.getProperty("user.dir")+"/src/test/java/configTest.json";
    	FileManager.cargarConfig(directorio);    	
    	Object ob = new Object();
        try{
            ob = new JSONParser().parse(new FileReader(directorio));
        }catch(Exception e){

        }
    	JSONObject jso = (JSONObject) ob;
    	Assertions.assertEquals(21.0, ConstanteFormula.QPE);
    }


    @Test
    public void cargarCatedraDocente() throws IOException{
        String path = System.getProperty("user.dir")+"/src/test/java";
        
        FileManager.cargarCatedra(path + "/Catedra.csv");
        FileManager.cargarDocente(path + "/Docente.csv");
        List<Catedra> catedras = Estructura.catedras;
        Catedra catedraEsperada = new Catedra("Introduccion_a_la_Programacion_I");
        catedraEsperada.putValue("anioMateria",1.0);
        catedraEsperada.putValue("tipoPE",3.0);
        catedraEsperada.putValue("horasP",3.0);
        catedraEsperada.putValue("horasTP",2.0);
        catedraEsperada.putValue("horasPE",1.0);
        catedraEsperada.putValue("cantInscriptos",328.0);
        catedraEsperada.putValue("cantRindieron",255.0);
        
        Docente docente = new Docente("Cobo Hernan");
        docente.put("horasT",0.0);
        docente.put("horasP",0.0);
        docente.put("horasPE",0.0);

        docente.put("horasTP",60.0);


        catedraEsperada.agregarDocente(docente);
        List<Catedra> catedrasTest = new ArrayList();
        catedrasTest.add(catedraEsperada);
        Assertions.assertEquals(catedrasTest,catedras); 
    }
    
 
   @Test
    public void cargarFormulaTest() throws IOException{
       String path = System.getProperty("user.dir")+"/src/test/java";
       Estructura.pathFormula = path + "/formula.txt";
       FileManager.cargarFormula();
       String formulaEsperada = "n+qp+p+tp+qpe+pe+o";
       String formula = Estructura.formula;
       Assertions.assertEquals(formulaEsperada,formula);
    }
}
