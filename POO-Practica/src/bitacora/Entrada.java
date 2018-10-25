/**
 * 
 */
package bitacora;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Dani_
 *
 */
public class Entrada {

	//Atributios
	
	private final String suceso;
	private final LocalDate fecha;
	
	//Constructor
	public Entrada(String suceso) {
		this.suceso = suceso;
		fecha = java.time.LocalDate.now();
	}

	public String getSuceso() {
		return suceso;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
