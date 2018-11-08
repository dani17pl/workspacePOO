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
	
	//Funcionalidad
	
	public Reserva Reserva(String usuario) {
		
		if (LocalDate.now().isAfter(fechaSalida) || reservas.size() >=this.plazas) {
			return null;
		}
		
		Reserva reserva= new Reserva(usuario);
		reservas.add(reserva);
		return reserva;
	}
	
	public Reserva ReservaPorCodigo(String codigo) {
		for (Reserva reserva : reservas) {
			if (reserva.getCodigoReserva().equals(codigo)) {
				return reserva;
			}
		}
		return null;
	}
	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}
	/**
	 * @return the coche
	 */
	public String getCoche() {
		return coche;
	}
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @return the fechaSalida
	 */
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	/**
	 * @return the plazas
	 */
	public int getPlazas() {
		return plazas;
	}
	/**
	 * @return the reservas
	 */
	protected LinkedList<Reserva> getReservas() {
		return reservas;
	}
	
	
	public String toString (){
	       
        return "Viaje: \n"
        		+ "propietario :" +this.propietario + "\n"
        		+ "coche:" +this.coche + "\n"
        		+ "ruta:" +this.ruta + "\n"
        		+ "fecha de salida :" +this.fechaSalida + "\n"
        		+ "plazas:" +this.plazas + "\n"
        		+ "reservas:" +this.reservas + "\n"
        		;
    }
}
