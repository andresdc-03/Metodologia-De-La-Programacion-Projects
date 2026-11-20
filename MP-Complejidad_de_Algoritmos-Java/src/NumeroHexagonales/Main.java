package NumeroHexagonales;

/**
 * 
 * Problema.
 * 
 *         Un numero hexagonal es un numero poligonal que representa un hexagono. La expresion para calcular el n-esimo numero hexagonal es
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5934056aa3c555c0656808428d27b21e673861b0" alt="">
 *         Que se usaria en el caso de formula directa y para sacar la formula para la recursividad.
 * 
 *         Otra forma de obtener el enesimo numero hexagonal n tambien puede expresarse a traves de la siguiente suma:
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/91a4c4d6f5dfd958b0010695ced89828bea54009" alt="">
 *         Que se usaria en el casos de iteración.        
 * 
 *         Se pide:
 *         - Determinar la relacion de recurrencia correspondiente a la ecuacion (2).
 *         - Determinar teoricamente la complejidad de los tres algoritmos.
 *         - Implementar los tres algoritmos en un programa en Java.
 *         - Determinar empiricamente el tiempo de ejecucion de los tres algoritmos como funcion de n.
 *
 */

import java.util.Scanner;

public class Main {
    // Creamos las variables que representaran el inicio y el final del tiempo cronometrado
	static double incion = 0;
	static double fin = 0;
	
    public static void main(String[] args) {
        Interfaz.bienvenida(); // Breve mensaje de bienvenida
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    public static void inicioPrograma() {
        // Declaramos las variables que opcion representara el numero de la opcio elegida para elecutar y numero sera el numero elegido sobre el que vamos a trabajar  	
    	int numero = 0, opcion = 0; 
        opcion = Interfaz.pedirOpcion(); // Peticion y optencion del numero que corresponda con el metodo que quiera ejecutar     
    	try {
            // Si "opcion" es distinto de 4 pedimos que numero quiere hexagonal
        	if ( opcion != 4 ) {
        		System.out.println("Introduce que numero hexagonal quieres calcular: ");
            	@SuppressWarnings("resource")
    			Scanner dato = new Scanner(System.in);
            	numero = dato.nextInt();
        	}
            switch (opcion) {
            	case 1 -> opcion1(numero);
            	case 2 -> opcion2(numero);
            	case 3 -> opcion3(numero);
            	case 4 -> salir();
            	default -> opcionNoExiste();
            }
        } catch( Exception e) {
        	System.out.println("Error: " + e);
        }        
    }
    public static void opcion1(int entrada) {    	
    	System.out.println("Aplicacion del metodo directo, mediante formula:");
        incion = Interfaz.tiempoEjecucion();
        System.out.println(FormulaDirecta.formulaDirecta(entrada));
        fin = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (fin - incion) + "ns");
    }
    public static void opcion2(int entrada) {
        System.out.println("Aplicacion del metodo recursivo:");
	    incion = Interfaz.tiempoEjecucion();
    	System.out.println(Recursivo.recursivo(entrada));
        fin = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (fin - incion) + "ns");
    }
    public static void opcion3(int entrada) {
    	System.out.println("Aplicacion del metodo iterativo:");
        incion = Interfaz.tiempoEjecucion();
    	System.out.println(Iteracion.iteracion(entrada));
        fin = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (fin - incion) + "ns");
    }
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
