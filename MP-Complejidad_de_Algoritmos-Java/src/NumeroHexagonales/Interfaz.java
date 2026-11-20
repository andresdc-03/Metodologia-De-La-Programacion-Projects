package NumeroHexagonales;

/**
 * 
 * Interfaz de usuario.
 * ===============================
 * Contenido.
 * ===============================
 */

import java.util.Scanner;

public interface Interfaz {
	String usuario = System.getProperty("user.name");
	public static void interfaz() {}
	public static void bienvenida() { // Breve mensaje de bienvenida
		System.out.println();
		System.out.println("******************************************************************************************************************************");
		System.out.printf("***   Bienvenido al calculo de numeros hexagonales ***\n");
		System.out.println("******************************************************************************************************************************\n");        
	}

	public static int pedirOpcion() {
		int entrada = 0; // Variable que sera el numero de nuestra opcion elegida
		/* ---------------------------------------------------------------- */
		System.out.println("Selecciona una de las opciones disponibles: ");
		System.out.println("1- Por formula.");
        System.out.println("2- Por recursividad.");
        System.out.println("3- Por iteracion.");
        System.out.println("4- Finalizar programa.");
        System.out.print("");
        /* ---------------------------------------------------------------- */
        @SuppressWarnings("resource")		
		Scanner dato = new Scanner(System.in);
        entrada = dato.nextInt();
        /* ---------------------------------------------------------------- */
        return entrada;
	}
	
	public static double tiempoEjecucion() {
		double timer = System.nanoTime();
		return timer;
	}

	public static void finPrograma() {	
		System.out.println();
		System.out.println("Fin del programa!");
		System.out.println( "Gracias por usar nuestro programa de Numeros Hexagonales.");
		System.exit(0);
	}

	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t\t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();
		
	}
}
