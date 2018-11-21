/**
 * 
 */
package Ejercicio6GestionDeFechas;

import java.time.LocalDate;

/**
 * @author Dani_
 *
 */
public class Ocupacion {
	
	private final Tramo tramo;
	private final LocalDate fechaCaducidad;
	
	public Ocupacion (Tramo tramo,LocalDate fechaCaducidad ) {
		this.tramo = tramo;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Ocupacion otro = (Ocupacion) obj;
		
		return this.tramo == otro.tramo && this.fechaCaducidad.equals(otro.fechaCaducidad);
	}
	
	@Override
	public int hashCode() {
		int primo = 31;
		int result = 1;
		result = primo * result + this.tramo.hashCode();
		result = primo * result + this.fechaCaducidad.hashCode();
		return result;
	}
	
}
