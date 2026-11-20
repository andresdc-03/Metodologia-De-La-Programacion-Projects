package NInversiones;

/**
 * 
 * Interfaz de usuario
 * ===============================
 * Contenido.
 * ===============================
 * 
 */

import java.util.Scanner;

public interface Interfaz {
	String usuario = System.getProperty("user.name");
	// Fichero con los datos de entrada	
	public static String FICHERO_DATOS = "src/Caso2/Data/InversionesTest.dat";
	// Metodos de la interfaz
	public static void interfaz() {}

	public static void bienvenida() {
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println("***   Bienvenido al caso - Numeros de inversiones ***");
		System.out.println("********************************************************************************\n");        
	}
	
	public static int pedirOpcion() {
		int entrada = 0;
		/* ---------------------------------------------------------------- */
		System.out.println("Selecciona una de las opciones disponibles: ");
		System.out.println("");
		System.out.println("Inversion programada por: ");
		System.out.println("1- Fuerza Bruta.");
        System.out.println("2- Divide y venceras.");        
        System.out.println("3- Finalizar programa.");
        System.out.print("");
        /* ---------------------------------------------------------------- */
        @SuppressWarnings("resource")		
		Scanner dato = new Scanner(System.in);
        entrada = dato.nextInt();
        /* ---------------------------------------------------------------- */
        return entrada;
	}

	public static double tiempoEjecucion() { // Tiempo en este preciso momento en nanosegundos
		double timer = System.nanoTime();
		return timer;
	}

	public static void finPrograma() {	
		System.out.println();
		System.out.println("Fin del programa!");
		System.out.println("Gracias por usar nuestro programa de Numero de Inversiones.");
		System.exit(0);
	}

	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n",usuario);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();		
	}
}
