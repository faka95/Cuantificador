	package org.exa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

	public class FileManager {
    
    /** 
	 * Crea una lista de catedras leidas desde un csv y la carga en la clase "Estructura"
	 * @param directorio un directorio abosoluto que contiene un csv con los datos de las catedras
	 * @return 
	 */
    public static void cargarCatedra(String directorio){
        List<Catedra> catedras = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(directorio);
			BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
			String entrada = new String(); 
				
			while ( (entrada = entry.readLine()) != null) {
		        //Procesamiento de los datos
                String datos[] = entrada.split(",");
                String nombre = datos[0];
                int horasT = Integer.parseInt(datos[1]);
                int horasP = Integer.parseInt(datos[2]);
                int horasTP = Integer.parseInt(datos[3]);
                int horasPE = Integer.parseInt(datos[4]);
                int cantInscriptos = Integer.parseInt(datos[5]);
                int cantRindieron = Integer.parseInt(datos[6]);
                Catedra catedra = new Catedra(nombre, horasT, horasP, horasTP, horasPE, cantInscriptos,cantRindieron);//va a haber un constructor sin lista?? si no hay que enviar una vacia
		        catedras.add(catedra);
			}
			entry.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("Archivo catedras no encontrado \n");
		}catch(Exception ie){
			System.out.println("El archivo catedras se encuentra mal cargado, no se cargaron todos los datos \n");
		}
        Estructura.catedras = catedras;
    }

    /** 
	 * Crea una lista de docentes leidos desde un csv y la carga en la clase "Estructura, para que funcione correctamente es necesario ejecutar previamente el cargarCatedras"
	 * @param directorio un directorio abosoluto que contiene un csv con los datos de los docentes
	 * @return 
	 */
    public static void cargarDocente(String directorio){
		try {
			FileReader fileReader = new FileReader(directorio);  
			BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
			String entrada = new String(); 
				
			while ( (entrada = entry.readLine()) != null) {
		        //Procesamiento de los datos
                String datos[] = entrada.split(",");
                String nombre = datos[0];
				String nombreCatedra = datos[1];
                int horasT = Integer.parseInt(datos[2]);
                int horasP = Integer.parseInt(datos[3]);
                int horasTP = Integer.parseInt(datos[4]);
                int horasPE = Integer.parseInt(datos[5]);
                Docente docente = new Docente(nombre, horasT, horasP, horasTP, horasPE);
		        Catedra catedra = Estructura.getCatedraByName(nombreCatedra);
				if(catedra != null){
					catedra.agregarDocente(docente);
				}
				else{
					System.out.println("La catedra del docente " + nombre + " no existe");
				}
			}
			entry.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("Archivo docentes no encontrado \n");
		}catch(Exception ie){
			System.out.println("El archivo docentes se encuentra mal cargado, no se cargaron todos los datos \n");
		}
    }

    public static void guardarFormula(String formula) throws IOException {
		String path = Estructura.pathFormula;
		try {
			FileWriter fw = new FileWriter(path.substring(0,path.indexOf('.'))+".txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.print(formula);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

    /** 
	 * Lee desde un directorio la formula utilizada para calcular ayudantes por catedra y la carga en la clae "Estructura".
	 * @param directorio un directorio abosoluto que contiene un archivo de texto con la formula en su primer linea.
	 * @return string con la formula a utilizar
	 */
    public static void cargarFormula(String directorio) {
    	String formula = new String();
    	
    	try {
			FileReader fileReader = new FileReader(directorio);  
			BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
			String entrada = entry.readLine();	
			if (entrada != null) {
				formula = entrada;
			}
			entry.close();
		}catch (FileNotFoundException e) {
			System.out.println("Archivo de formula no encontrado \n");
		}catch(Exception ie){
			System.out.println("El archivo fomula se encuentra mal cargado, no se cargaron todos los datos \n");
		}
    	Estructura.formula = formula;
    }

    public static void generarSalida(){}

}
