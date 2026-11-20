package NumeroHexagonales;

/**
 * 
 * Aplicacion de la formula directa.
 *
 */

public class FormulaDirecta {
	
	public static double formulaDirecta(int valorEntrada) {
		double calculo = valorEntrada * (2 * valorEntrada-1); // Se calcula el valor de calculo utilizando el valor de valorEntrada usando la formuna (n*(2n-1))
		return calculo; // Se retorna el valor de calculo
	}
}
