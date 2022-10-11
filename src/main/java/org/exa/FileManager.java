package org.exa;

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
		// return catedras;
    }

    /** 
	 * Crea una lista de docentes leidos desde un csv y la carga en la clase "Estructura"
	 * @param directorio un directorio abosoluto que contiene un csv con los datos de los docentes
	 * @return 
	 */
    public static void cargarDocente(String directorio){
        List<Docente> docentes = new ArrayList<>();
		
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
                Docente catedra = new Docente(nombre, horasT, horasP, horasTP, horasPE);
		        docentes.add(catedra);
			}
			entry.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("Archivo docentes no encontrado \n");
		}catch(Exception ie){
			System.out.println("El archivo docentes se encuentra mal cargado, no se cargaron todos los datos \n");
		}
        Estructura.docentes = docentes;
		// return docentes;
    }

    public static void guardarFormula(String formula){}

    public static void cargarFormula(String directorio){}

    public static void generarSalida(){}

}
