package NInversiones;

/**
 * Clase que usa la ordenacion por combinacion.
 * 
 * Basicamente, cada elemento del array dato, 'datos', cuenta todos los elementos mas que a su izquierda y agrega el conteo a la salida.
 * Toda la magia ocurre dentro de la funcion de combinacion de clasificacion de combinacion.
 * 
 */
public class Mergesort {

	public static int mergesort(int[] datos, int[] copia, int inicio, int finD) {
		/*
		 *  Nos dan como base los datos de entrada con los que trabajaremos. --> int[] datos.
		 *  Y una copia del array --> int[] copy.
		 *
		 * Buscamos y resolvemos el caso base: Tama�o de ejecuci�n <= 1
		 */
		if (finD <= inicio ) {
			return 0;
		}
		/*
		 *   Encontramos el punto medio del problema.
		 *   Usamos la tecnica de bit shifting: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
		 *   
		 *   Comenzamos restando inicio de fin para obtener la longitud del intervalo. Luego, este valor, se divide entre 2 mediante el operador '>>', que realiza un desplazamiento
		 *   hacia la derecha en la representacion binaria del nomero, lo que es equivalente a una division por 2^n, donde 'n' es el numero de bits que se desplazan.
		 *   
		 *   El resultado se suma a inicio para obtener un valor medio, que se almacena en 'mitad', un entero que representa el indice medio del  intervalo del array datos.
		 */
		int mitad = ( inicio + ((finD - inicio ) >> 1 ));
		int inversionEncontrada = 0;
		/*
		 * Dividimos recursivamente las ejecuciones en dos mitrades hasta que las divisiones sean <= 1.
		 * Luego se unen y devuelven al array original
		 */

		// Dividimos la mitad izquierda
		inversionEncontrada += mergesort(datos, copia , inicio, mitad );
		// Dividimos la mitad derecha
		inversionEncontrada += mergesort(datos, copia , mitad +1 , finD );
		// Unimos las dos mitades recorridas
		inversionEncontrada +=merge(datos, copia, inicio, mitad, finD);
		
		// Devolvemos las inversiones realizadas
		return inversionEncontrada;
	}

	private static int merge(int[] datos, int[] aux, int min, int mid, int max) {
		int inicio = min, i = min, mitad = mid+1, fin = max;
		int inversionEncontrada = 0;
		/*
		 * Mientras existan elementos en los array, continuamos 
		 */
		while ( inicio <= mid && mitad <= fin) {
			if(datos[inicio]<=datos[mitad]) {
				aux[i++]=datos[inicio++]; 
			} else {
				aux[i++]=datos[mitad++];
				// El elemento de la derecha genera inversiones con todos los elementos restantes de la izquierda
				inversionEncontrada += (mid - inicio +1);
			}				
		}

		// Copiamos los elementos restantes que ya vienen ordenados en el array
		while ( inicio <= mid ) {
			aux[i++] = datos[inicio++];
		}

		// Copiamos los elementos restantes de la mitad derecha
		while (mitad <= fin) {
			aux[i++] = datos[mitad++];
		}

		// Copiamos el intervalo ordenado al array original
		for ( int p = min; p <= max; p++  ) {
			datos[p] = aux[p];
		}
		return inversionEncontrada;
	}
	
}
