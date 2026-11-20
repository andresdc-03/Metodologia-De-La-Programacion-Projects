package BecasDeColavoracion;

import java.util.ArrayList;
import java.util.List;

public class PlanificadorBecas {

    private List<Beca> becas; // Creamos una lista becas que es donde nos mostrara la lista de las becas disponibles 
    private List<Beca> solucionActual; // Otra lista de las becas donde guardaremos la solucion actual mas conveniente
    private int salarioMaximo;// El salaraio maximo encontrado hasta el momento
    private int salarioTotal; // El total de todas las becas asignadas 
    
    /**
     * 
     * Constructor del planificador de becas
     * @param becas
     * 
     */
    public PlanificadorBecas(List<Beca> becas) {
        this.becas = becas;
        this.solucionActual = new ArrayList<>();
        this.salarioMaximo = 0;
        this.salarioTotal = 0;
    }

    /**
     * 
     * Devuelve la solucion.
     * @return solucion
     * 
     */
    public List<Beca> getSolucion() { // Creamos un metodo de tipo lista que nos devolvera las becas asignadas
        resolver(new ArrayList<Beca>(), 0, 0); // Llamos al metodo resolver con la lista de las becas y el salario actual
        return solucionActual; // Devolvemos la solucion actual, el cual como declaramoses un array de las becas asignadas
    }

    /**
     * 
     * Busca la solucion de la lista disponible
     * @param candidatos
     * @param salarioActual
     * @param inicio
     * 
     */
    // Aqui hacemos el backtracking para encontrar la solucion 
    public void resolver(List<Beca> candidatos, int salarioActual, int inicio) { // Pasamos la lista de las becas y el salario actual
    	// Verificamos si los candidatos actuales y el salario actual forman una solucion. 
    	if (esSolucion(salarioActual)) { //Si es solución 
            procesarSolucion(candidatos, salarioActual); // Llama al metodo procesarSolucion
        } else {
            for (int i = inicio; i < becas.size(); i++) { // Iteramos sobre las becas disponibles 
                Beca beca = becas.get(i); // Tomamos una beca y la guardamos en la varible beca 
                // Llamamos a los metodos es valido y sesolapa 
                if (esValido(beca, candidatos)) { // Si es valida y no se solapa
                    candidatos.add(beca); // Anadimos a la lista candidatos que corresponde a nuestra lista beca 
                    resolver(candidatos, salarioActual + beca.getSalario(), i + 1);//llamamos el metodo de nuevo para realizar la recursividad con el salario y las becas actualziadas
                    candidatos.remove(beca);//eliminamos esa beca de la lista para probar con otras becas y no caer en la misma
                }
            }
        }
    }

/* 
 ***********************************************************************
 * 
 *                 Complovaciones de validez de la beca
 * 
 ***********************************************************************
 */
    /**
     * 
     * Comprueba si las fechas disponibles son validas.
     * @param beca
     * @param candidatos
     * @return boolean
     * 
     */
    public boolean esValido(Beca beca, List<Beca> candidatos) {
    	// Guardamos los meses de inicio y fin
    	int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) { // Recorremos la lista de candidatos
        	// Guardamos los meses de inicio y fin de la beca candidata 
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();
            // Comprobamos si no es valida comparando que los meses de la beca candidata 
            // no coincida dentro de los meses de las becas de la planificacion que ya hemos elegido
            if ((mesInicioBeca >= mesInicioCandidata && mesInicioBeca <= mesFinCandidata) ||
                (mesFinBeca >= mesInicioCandidata && mesFinBeca <= mesFinCandidata) ) {
                return false;
            }
        }
        return true;
    }

/* 
 ***********************************************************************
 * 
 *                     Comprobacion solucion Beca
 * 
 ***********************************************************************
 */
    /**
     * 
     * Devuelve el salario más alto actualizado
     * @param candidatos
     * @param salarioActual
     * @return salarioActual > salarioMaximo (boolean)
     * 
     */
    // Comprueba si la asignacion actual es una solucion. Devuelve verdadero si 
    // el salario actual es mayor que el salario maximo y falso en caso contrario.
    public boolean esSolucion(int salarioActual) {
    	return salarioActual > salarioMaximo;
    }

	/**
     * 
	 * Proceso que calcula el beneficio maximo por beca 
	 * @param candidatos
	 * @param salarioActual
     * 
	 */
    public void procesarSolucion(List<Beca> candidatos, int salarioActual) {
        solucionActual = new ArrayList<>(candidatos);// Creamos una nueva lista con una copia de lista de becas candidatas
        salarioMaximo = salarioActual;
        salarioTotal += salarioActual; // Suma el salario actual al salario total existente
    }

    /**
     * 
     * Devuelve el salario total obtenido.
     * @return salarioTotal
     * 
     */
    public int getSalarioTotal() {
        return salarioTotal;
    }
}