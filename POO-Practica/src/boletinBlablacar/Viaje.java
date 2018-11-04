/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class Viaje {

	private final String propietario;
	private final String coche;
	private final String ruta;
	private final LocalDate fechaSalida;
	private final int plazas;
	private LinkedList<Reserva> reservas;
	
	//Constructor
	public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazas) {
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.fechaSalida = fechaSalida;
		this.plazas = plazas;
		reservas = new LinkedList<Reserva> ();
	}
	public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida) {
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.fechaSalida = fechaSalida;
		this.plazas = 1;
		reservas = new LinkedList<Reserva> ();
	}
	
}
