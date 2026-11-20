package NumeroHexagonales;

/**
 * 
 * Aplicacion del metodo recursivo.
 * 
 * paso: 1:
 *  	Establecemos el caso base que sera cuando el valor de la entrada es 1, por lo que el return sera 1 ya que es el caso base	
 *  
 * paso 2: 
 * 		Estabelcemos el metrodo recursivo aplicando la formula H(n-1) + 4n-3 y siendo el H(N-1). Lo que aplicamos en la recursividad 
 * 		llamando de nuevo a nuestro metodo con el valor restando uno para llegar hasta el caso base, y posteriormente colocamos la continucacion
 * 		de la formula a la que llegamos en nuestro algoritmo obteniendo asi nuestro valores de los numeros hexagonales correspondientes.
 * 
 */
public class Recursivo {	
	public static double recursivo(int valorEntrada) {
		// Caso base   
		if (valorEntrada == 1) {  		
	        return 1;
		// Caso recursivo
	    } else { 
			return  recursivo(valorEntrada - 1) + 4 * valorEntrada - 3 ;
	    }
	}
}
