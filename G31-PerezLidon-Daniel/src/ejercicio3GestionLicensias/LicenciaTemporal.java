/**
 * 
 */
package ejercicio3GestionLicensias;

import java.time.LocalDate;


// TODO: Auto-generated Javadoc
/**
 * The Class LicenciaTemporal.
 *
 * @author Dani_
 */
public class LicenciaTemporal extends Licencia {
	
	/** La fecha de caducidad de la licencia. */
	private LocalDate fechaCaducidad;
	
	/** caducada. Representa si una licencia esta caducada */
	private boolean caducada;
	
	/**
	 * Instancia una nueva licencia temporal.
	 *
	 * @param email el email
	 * @param servicio el servicio
	 * @param fechaCaducidad la fecha de caducidad
	 */
	public LicenciaTemporal(String email, String servicio, LocalDate fechaCaducidad) {
		super(email, servicio);
		this.fechaCaducidad = fechaCaducidad;
		this.caducada = false;
	}
	/**
	 * Instancia una nueva licencia temporal con fecha de caducidad dentro de 3 meses.
	 *
	 * @param email el email
	 * @param servicio el servicio
	 */
	public LicenciaTemporal(String email, String servicio) {
		this(email, servicio, LocalDate.now().plusMonths(3));	
	}
	
	
	/**
	 * Extender la fecha de caducidad.
	 *
	 * @param newmonth Los meses que se extiende la fecha de caducidad
	 */
	public void extenderFecha(int newmonth) {
		
		this.fechaCaducidad.plusMonths(newmonth);
	}

	/** Metodo que hereda de la clase Licencia (es metodo abstacto).
	 * @see ejercicio3GestionLicensias.Licencia#aplicable()
	 * 
	 * Comprueba que la fecha actual no sea superior a la fecha de caducidad
	 */
	@Override
	public boolean aplicable() {
		if (LocalDate.now().isAfter(this.fechaCaducidad)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicenciaTemporal clone() {
		LicenciaTemporal copiaLicencia = (LicenciaTemporal) super.clone();
		return copiaLicencia;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return super.toString()
        		+ "fechaCaducidad :" + this.fechaCaducidad + "\n"
        		+ "caducada :" + this.caducada + "\n";
    }
}
