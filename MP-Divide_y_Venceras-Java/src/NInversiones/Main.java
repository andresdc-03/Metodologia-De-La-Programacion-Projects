package NInversiones;

/**
 * 
 * <h1>Practicas. Caso de estudio 2.</h1>
 * <h2>Descripción del problema</h2>
 * <p>
 * Algunos sitios Web hacen uso de una técnica conocida como filtrado colaborativo.
 * Con ella, estos sitios intentan hacer concordar nuestras preferencias con las de otros usuarios. Una vez que el sitio Web ha identificado individuos con preferencias similares a
 * las nuestras -basándose en la comparación de cómo los usuarios hemos puntuado o calificado determinados productos- puede recomendarnos nuevos productos que los otros
 * usuarios hayan apreciado. Por ejemplo, un sitio de música puede intentar emparejar nuestras preferencias musicales con las de otros usuarios de la forma siguiente:
 * 
 * 		• Nosotros clasificamos n canciones
 * 		• El sitio Web consulta su base de datos para encontrar usuarios con gustos similares
 * 
 * El punto principal en una aplicación como esta es el problema de cómo comparar dos clasificaciones (rankings). Es decir, ¿cómo se determina la semejanza de dos rankings?
 * Un método directo sería clasificar n canciones (o el producto del que se trate) de 1 a n en función de nuestras preferencias. Ahora, comparamos con la otra clasificación
 * determinando cuantas parejas están “descolocadas”. Por ejemplo, en el caso de las canciones:
 * 		- Nuestra clasificación (la referencia): 1, 2, …, n
 * 		- Otra clasificación: a1, a2, …, an
 * 		- Las canciones i and j están invertidas (“descolocadas”) si i < j, pero ai > aj
 * 
 * Problema.
 *    Dada una permutación contar el número de inversiones.
 *
 */
public class Main {
	private static double a = 0;
	private static double b = 0;
	private static int nInversiones = 0;
	
    public static void main(String[] args) {
		// Mensaje de bienvenida.
        Interfaz.bienvenida();
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    public static void inicioPrograma() {

    	// Variables necesarias para interactuar con el usuario
    	int[] dEntrada = null;
    	int opcion = 0;
    	
    	// ------------------------------------------------------------------
        // Selecciónar opcion del programa.
        opcion = Interfaz.pedirOpcion();
        // Operar con la opcion seleccionada.
    	// ------------------------------------------------------------------        
    	try {
        	if ( opcion != 3 ) {
            	// ------------------------------------------------------------------
            	// Cargamos los datos de entrada al programa
            	System.out.println("Cargando los datos de entrada ... ");
            	// ------------------------------------------------------------------
        		dEntrada = Datos.dataEntry();
        	}
            switch (opcion) {
            	case 1 -> opcion1(dEntrada); // No está pedido pero así lo practicamos y vemos las diferencias de tiempos
            	case 2 -> opcion2(dEntrada); // Mergesort
            	case 3 -> salir(); // Salimos del programa
            	default -> opcionNoExiste(); // Si no es ninguna de las opciones, redirige al metodo "opcionNoExiste"
            }
        } catch( Exception e) {
        	System.out.println("Error: " + e);
        	System.out.println();
        	String sDirectorioTrabajo = System.getProperty("user.dir");
        	System.out.println("El directorio de trabajo es " + sDirectorioTrabajo);
        	System.exit(1);
        }        
    }

	private static void opcion1(int[] d) {    	
    	a = Interfaz.tiempoEjecucion();
    	nInversiones = FuerzaBruta.fuerzaBruta(d);
        b = Interfaz.tiempoEjecucion();  
        System.out.println();
        System.out.println("Resultado final: " + (b-a) + "ns");
		System.out.println("Numero de inversiones: " + nInversiones);
    }

    private static void opcion2(int[] d) {
    	a = Interfaz.tiempoEjecucion();
    	nInversiones = Mergesort.mergesort(d, new int[d.length], 0, d.length - 1);
        b = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: " + (b-a) + "ns");
		System.out.println("Numero de inversiones: " + nInversiones);
    }
    
    private static void salir() {
    	Interfaz.finPrograma(); // Te redirige al metodo de Interfaz.java de nombre "finPrograma"
	}

    private static void opcionNoExiste() {
    	Interfaz.opcionNoExiste(); // Te redirige al metodo de Interfaz.java de nombre "opcionNoExiste"
	}    
}
