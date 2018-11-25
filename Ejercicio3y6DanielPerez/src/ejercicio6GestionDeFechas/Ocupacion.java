/**
 * 
 */
package ejercicio6GestionDeFechas;

import java.time.LocalDate;

/**
 * @author Dani_
 *
 *Clase que representa una ocupacion 
 */
public class Ocupacion {
	
	/** El tramo. Representa si la ocupacion es por la tarde o mañana */
	private final Tramo tramo;
	
	/** La fecha caducidad. Representa la fecha de la ocupacion */
	private final LocalDate fechaCaducidad;
	
	/**
	 * Instancia una nueva ocupacion.
	 *
	 * @param tramo el tramo de la ocupacion
	 * @param fechaCaducidad La fecha de la ocupacion
	 */
	public Ocupacion(Tramo tramo, LocalDate fechaCaducidad) {
		this.tramo = tramo;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	/**
	 * @return the tramo
	 */
	public Tramo getTramo() {
		return tramo;
	}

	/**
	 * @return the fechaCaducidad
	 */
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	/* 
	 * Metodo heredado de Object
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Clase que representa si una ocupacion es igual a otra para 
	 * ello se comprueba si la ocupacion tiene el mismo tramo y fecha
	 * 
	 *  @param obj Objecto que se casteara en ocupacion
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Ocupacion otro = (Ocupacion) obj;
		
		return this.tramo.equals(otro.tramo) && this.fechaCaducidad.equals(otro.fechaCaducidad);
	}
	

	/* Metodo heredado de Object
	 * @see java.lang.Object#hashCode()
	 * 
	 * sobrescribimos el método para que se comporte de forma acorde a la que lo hace .equals()
	 */
	@Override
	public int hashCode() {
		int primo = 31;
		int result = 1;
		result = primo * result + this.tramo.hashCode();
		result = primo * result + this.fechaCaducidad.hashCode();
		return result;
	}

	/* Metodo que hereda de Object 
	 * @see java.lang.Object#toString()
	 * 
	 * Mostrara como se representa en pantalla el espacio
	 */
	@Override
	public String toString() {	       
        return 
        		 "tramo :" + this.tramo + "\n"
        		+ "fechaCaducidad:" + this.fechaCaducidad;
    }
	
}
