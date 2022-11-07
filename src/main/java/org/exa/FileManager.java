package org.exa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class FileManager {

private static String[] readFirstLine(String line){
	return line.split(",");
}

/** 
 * Crea una lista de catedras leidas desde un csv y la carga en la clase "Estructura"
 * @param directorio un directorio abosoluto que contiene un csv con los datos de las catedras
 * @return 
 */
public static void cargarCatedra(String directorio){
	if (!directorio.endsWith(".csv")) {
		System.out.println("El archivo especificado para Catedras no es un csv.");
		Errores.catedraFaltante = true;
		Errores.archivoIncorrecto = true;
	}
	else {
		List<Catedra> catedras = new ArrayList<>();
		HashMap<String, Double> variables = new HashMap<>();
		
		
		try {
			FileReader fileReader = new FileReader(directorio);
			BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
			String entrada = new String(); 
			entrada = entry.readLine();
			String nombreVariables[] = readFirstLine(entrada);
			
			while ( (entrada = entry.readLine()) != null) {
				//Procesamiento de los datos
				String datos[] = entrada.split(",");
				String nombre = new String();
				int ni = -1; //posicion de la variable nombre
				for(int i = 0; i < nombreVariables.length; i++){
					if( nombreVariables[i].toUpperCase().equals("CATEDRA") )
						ni = i;
					else
						variables.put(nombreVariables[i], Double.parseDouble(datos[i]));
				}
				nombre = datos[ni];
				Catedra catedra = new Catedra(nombre, variables);//va a haber un constructor sin lista?? si no hay que enviar una vacia
				catedras.add(catedra);
			}
			entry.close();
			
		}catch (FileNotFoundException e) {
			Errores.catedraFaltante = true;
			System.out.println("Archivo catedras no encontrado \n");
		}catch(Exception ie){
			Errores.archivoIncorrecto = true;
			System.out.println("El archivo catedras se encuentra mal cargado, no se cargaron todos los datos \n");
			ie.printStackTrace();
		}
		Estructura.catedras = catedras;
	}
}

/** 
 * Crea una lista de docentes leidos desde un csv y la carga en la clase "Estructura, para que funcione correctamente es necesario ejecutar previamente el cargarCatedras"
 * @param directorio un directorio absoluto que contiene un csv con los datos de los docentes
 * @return 
 */
public static void cargarDocente(String directorio){
	if (!directorio.endsWith(".csv")) {
		System.out.println("El archivo especificado para Docentes no es un csv.");
		Errores.docenteFaltante = true;
		Errores.archivoIncorrecto = true;
	}
	else {
		try {
			FileReader fileReader = new FileReader(directorio);  
			BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
			String entrada;
			String[] nombreValores = entry.readLine().split(",");
			while ( (entrada = entry.readLine()) != null) {
				//Procesamiento de los datos
				String[] datos = entrada.split(",");
				String nombre = datos[0];
				String nombreCatedra = datos[1];
				Docente docente = new Docente(nombre);
				for(int i = 2; i<nombreValores.length; i++) {
					try {
						docente.put(nombreValores[i], Double.parseDouble(datos[i]));
					} catch (NumberFormatException | NullPointerException e) {
						Errores.datosErroneos = true;
					}
				}
				Catedra catedra = Estructura.getCatedraByName(nombreCatedra);
				if(catedra != null){
					catedra.agregarDocente(docente);
				}
				else{
					Errores.catedraFaltante = true;
					System.out.println("La catedra del docente " + nombre + " no existe");
				}
			}
			entry.close();
			
		}catch (FileNotFoundException e) {
			Errores.catedraFaltante = true;
			System.out.println("Archivo docentes no encontrado \n");
		}catch(Exception ie){
			Errores.archivoIncorrecto = true;
			System.out.println("El archivo docentes se encuentra mal cargado, no se cargaron todos los datos \n");
		}
	}
}

/**
 * Crea o modifica el archivo de fórmula con el valor indicado por el parámetro.
 * @param formula string que representa la fórmula matemática que se escribe en el archivo.
 */
public static void guardarFormula(String formula) {
	String path = Estructura.pathFormula;
	try {
		FileWriter fw = new FileWriter(path);
		PrintWriter pw = new PrintWriter(fw);
		pw.print(formula);
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

/** 
 * Lee desde un directorio la formula utilizada para calcular ayudantes por catedra y la carga en la clase "Estructura".
 */
public static void cargarFormula() {
	String formula = new String();
	
	try {
		FileReader fileReader = new FileReader(Estructura.pathFormula);  
		BufferedReader entry= new BufferedReader(fileReader);//creo el lector de archivos
		String entrada = entry.readLine();	
		if (entrada != null) {
			formula = entrada;
		}
		entry.close();
	}catch (FileNotFoundException e) {
		Errores.archivoIncorrecto = true;
		System.out.println("Archivo de formula no encontrado \n");
	}catch(Exception ie){
		System.out.println("El archivo formula se encuentra mal cargado, no se cargaron todos los datos \n");
		ie.printStackTrace();
	}
	Estructura.formula = formula;
}

/** 
 * Genera en el directorio pasado por parametro un listado en formato csv de las catedras encontradas en Estructura y la cantidad de ayudantes correspondientes segun la formula.
 * @param directorio directorio donde se generara el listado csv.
*/
public static void generarSalida(String directorio) throws IOException{
	try {
		FileWriter fileWriter = new FileWriter(directorio);
		for (Catedra c : Estructura.catedras){
			fileWriter.write(c.getNombre() + "," + Estructura.resultado.get(c.getNombre()) + "\n");
		}
		fileWriter.close();
	} catch (IOException e){
		e.printStackTrace();
		throw new IOException(e);
	}
}
}
