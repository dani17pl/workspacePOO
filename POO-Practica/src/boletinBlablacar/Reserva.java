/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Dani_
 *
 */
public class Reserva {

	//Atributos
	private final String codigoReserva;
	private final String usuario;
	private final LocalDate fecha;
	
	public Reserva(String usuario) {
		this.usuario = usuario;
		this.codigoReserva = UUID.randomUUID().toString();
		this.fecha = LocalDate.now();
	}

	/**
	 * @return the codigoReserva
	 */
	public String getCodigoReserva() {
		return codigoReserva;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	//Metodo
	public String toString (){
	       
        return "Reserva: \n"
        		+ "usuario :" +this.usuario + "\n"
        		+ "codigo de reserva:" +this.codigoReserva + "\n"
        		+ "fecha:" +this.fecha + "\n"
        		;
    }
}
