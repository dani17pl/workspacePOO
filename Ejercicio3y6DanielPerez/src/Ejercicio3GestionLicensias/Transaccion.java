/**
 * 
 */
package Ejercicio3GestionLicensias;

import java.time.LocalDate;

/**
 * @author Dani_
 *
 */
public class Transaccion {

	private final Licencia licencia;
	private final LocalDate fecha;
	
	public Transaccion (Licencia licencia, LocalDate fecha) {
		this.licencia = licencia;
		this.fecha = fecha;
	}

	/**
	 * @return the licencia
	 */
	public Licencia getLicencia() {
		return licencia;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	public String toString (){	       
        return "Transaccion: \n"
        		+ "licencia :" +this.licencia.getClass().getSimpleName() + "\n"
        		+ "fecha:" +this.fecha + "\n"
        		;
    }
} 
