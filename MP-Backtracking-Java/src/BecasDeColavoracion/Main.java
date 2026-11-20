package BecasDeColavoracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

/* 
 ********************************
 * 
 *            Main
 *  
 ********************************
 */
    public static void main(String[] args) {
    	/* Fichero de entrada */
    	final String ArchivoBecas = "BECAS.dat";

    	/* Lectura del fichero */
    	List<Beca> becas = new ArrayList<>(); // Lista para guardar los datos que vamos a leer   
    	// Llamamos al metodo "leerFichero" para leer los datos y esto lo guardamos el la lista "becas"
    	becas = leerFichero(ArchivoBecas);

    	/* Planificamos las becas */
        PlanificadorBecas planificador = new PlanificadorBecas(becas); // Creamos un objeto para el planificar las becas y proporciona los datos para ello
        List<Beca> solucion = planificador.getSolucion(); // Guardamos la solucion del listado de las becas elegidas

        /* Impresión del resultado */
        int sueldoTotal = 0; // Guarda el resultado del calculo del sueldo total anual y por beca
        System.out.println("La combinacion de becas con mayor beneficio es el siguiente: ");
        for (int i = 0; i < solucion.size(); i++) {
        	int sueldo = solucion.get(i).getSalario()*(solucion.get(i).getMesFin()-solucion.get(i).getMesInicio());
            System.out.println(solucion.get(i).toString());
            System.out.println( sueldo + " Euros");            
            sueldoTotal += sueldo;
        }
        System.out.println("\n Beneficio total a percibir: " + sueldoTotal + " euros");
     
    }

    /**
	 * 
     * Metodo de lectura del fichero.
     * @param nombreArchivo
     * @return listaBecas
	 * 
     */
    public static List<Beca> leerFichero(String nombreArchivo) {    	
    	List<Beca> listaBecas = new ArrayList<>(); // Lista para guardar los datos que vamos ir leyendo y retonrnarlos
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo)); // Leemos el fichero
            String linea; // Variable para ir guardando cada linea         
			int tamanioLista = Integer.parseInt(br.readLine()); // Leemos la primera linea como tamanio de la lista (linea 1)
			int contadorLineas = 0; 

			int[] ids = new int[tamanioLista]; // Lista donde meteremos los Ids
			int contadorIds = 0; // Contador para ir guardando cada Id de beca en su posicion correspondiente

            if (tamanioLista > 0 ) { 
	            while ((linea = br.readLine()) != null) { // Mientras que haya lineas para leer en el fichero (linea 2-X)
	                String[] campos = linea.split("\t"); // Separamos la linea/campos por el caracter de tabulacion/espacios
	                
					// Añadimos los datos a cada variable
					int id = Integer.parseInt(campos[0]); // Id de la beca

					ids[contadorIds] = id; // Añadimos el Id a la lista de ids
					contadorIds++; // Pasamos a la siguiente posicion de la lista ids

	                int inicio = Integer.parseInt(campos[1]);
	                int fin = Integer.parseInt(campos[2]);
	                int monto = Integer.parseInt(campos[3]);

					// Comprobar que el id de la beca no se repite
					for(Beca b : listaBecas) {
						if (b.getId() == id) {
							System.out.println("El indice de la beca se repite.");
							System.out.println("Revise el fichero de datos de entrada.");
							System.exit(0);
						}
					}

	                // Comprobamos si la fecha de inicio es menor que la de fin
	                if (inicio > fin) {
						System.out.println();
						System.out.println("El mes de inicio es mayor que el mes de fin");
	                	System.out.println("Revise el fichero de datos de entrada.");
	                	System.out.println();
						System.exit(0);

	                // Comprobamos si la fecha de inicio y fin no sean iguales
					} else if ( inicio == fin ) {
						System.out.println();
	                	System.out.println("El mes de inicio coincide con el mis de fin");
	                	System.out.println("Revise el fichero de datos de entrada.");
	                	System.out.println();
						System.exit(0);

					// Comprobamos si el intervalo de las becas no esta dentro de los 12 meses
					} else if (( inicio > 0 && inicio < 12) && (fin > 0 && fin <= 12 )) {
	                	try {
		                	Beca beca = new Beca(id, inicio, fin, monto); // Creamos un objeto Beca con los campos correspondientes
			                listaBecas.add(beca); // Anadimos la beca a la lista
			                contadorLineas++;		                
		                } catch  (NumberFormatException e) {
		                	MiException.exSrtring();
		                	System.out.println(e);
		                	System.exit(0);
		                }
					} else {
						System.out.println();
	                	System.out.println("El numero de meses no esta en el intervalo 1-12.");
	                	System.out.println("Revise el fichero de datos de entrada.");
	                	System.out.println();
						System.exit(0);
	                }
	            }
            } else {
            	MiException.exNumNegativo();
            	System.exit(0);
            }
            br.close(); // ¡¡¡Cerramos la lectura del fichero!!!

            // Buscamos el numero de  lineas existente frente al encontrado.
            if ( contadorLineas != tamanioLista ) {
            	MiException.exTotalLines();
            	System.exit(0);
            }

    	} catch (ArrayIndexOutOfBoundsException fIndex) {
    		MiException.ArrayIndexOutOfBounds();
        	System.out.println(fIndex);
        	System.exit(0);
    	}catch (NumberFormatException ex) {
    		MiException.exSrtring();
        	System.out.println(ex);
        	System.exit(0);
    	}catch (IOException e) {
    		System.out.println("Error al leer el fichero  " + e.getMessage());    		
        	System.exit(0);
    	}
    	return listaBecas;
    }
}

/* 
 ***********************************************************************
 * 
 *                              Excepciones
 * 
 ***********************************************************************
 */

class MiException extends Exception {
	/**
	 * 
	 * Mensaje que se ejecuta cuando se detecta un numeros negativos
	 * 
	 */
	static void exNumNegativo() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Tamanio de becas invalida. \n
				El numero introducido es cero o negativo. \n
				Por favor, verifique el fichero DATOS.dat Y reinicie la ejecucion del programa
				===================================================== \n
				""");
	}

	/**
	 * 
	 * Mensaje que se ejecuta cuando falta algun dato en el fichero
	 * 
	 */
	public static void ArrayIndexOutOfBounds() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Entrada invalida. \n
				Se ha encontrado una fallo en el fichero de entrada. \n
				Revise los datos de entrada y vuelva a intentarlo de nuevo. \n
				===================================================== \n
				""");
		
	}

	/**
	 * 
	 * Mensaje que se ejecuta cuando se detecta un String o floats
	 * 
	 */
	public static void exSrtring() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				Ha introducido un dato incoherente, debe introducir solo numeros enteros. \n
				Revise los datos del fichero y vuelva a intentarlo de nuevo. \n
				===================================================== \n
				""");		
	}

	/**
	 * 
	 * Mensaje que se ejecuta cuando el numero de lineas introducido es distinto a los leidos en el fichero 
	 *
	 */
	public static void exTotalLines() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				No coinciden el numero de lineas. \n
				El numero  de lineas encontrado en el fichero VS numero el introducido en el fichero. \n
				no coinciden. \n
				REVISE EL FICHERO Y VUELVA A INTENTARLO DE NUEVO.
				===================================================== \n
				""");		
	}
}