/**
 * 
 */
package ejercicio3GestionLicensias;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * Clase Transaccion.
 *
 * @author Dani_
 */
public class Transaccion {

	/** La licencia. */
	private final Licencia licencia;
	
	/** La fecha. */
	private final LocalDate fecha;
	
	/**
	 * Instancia una nueva transaccion.
	 *
	 * @param licencia la licencia
	 * @param fecha la fecha
	 */
	public Transaccion(Licencia licencia, LocalDate fecha) {
		this.licencia = licencia;
		this.fecha = fecha;
	}

	/**
	 * Retorna la licencia.
	 *
	 * @return la licencia
	 */
	public Licencia getLicencia() {
		return licencia;
	}

	/**
	 * Retorna la fecha.
	 *
	 * @return la fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return "Transaccion: \n"
        		+ "licencia :" + this.licencia.getClass().getSimpleName() + "\n"
        		+ "fecha:" + this.fecha + "\n";
    }
} 
