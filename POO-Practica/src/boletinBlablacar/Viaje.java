/**
 * 
 */
package boletinBlablacar;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;


/**
 * @author Dani_
 *
 */
public class Viaje implements Cloneable, Comparable<Viaje>{

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
	protected boolean EliminarReserva(Reserva reserva) {
		if (this.reservas.remove(reserva))
		{
		     return true;
		}
		else return false;
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
	
	protected LinkedList<Reserva> getReservas(Comparator<Reserva> c) {
		reservas.sort(c);
		return reservas;
	}
	
	@Override
	public Viaje clone() {
		Viaje copiasViaje = copiaSuperficial();
		//Modificamos para hacer la copia profunda
		 copiasViaje.reservas =new LinkedList( this.reservas );
		
		return copiasViaje;
	}
	
	/**
	 * Metodo que realiza una copia superficial del espacio llamando al metodo
	 * clone de la clase onject.
	 *
	 * @return the espacios
	 */
	private Viaje copiaSuperficial() {
		 try {
		        Viaje copiaviaje = (Viaje) super.clone();	 
		        return copiaviaje;
		    } catch (CloneNotSupportedException e) {
		    	 System.err.println("La clase no es cloneable");
		    }
		 return null;
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

	@Override
	public int compareTo(Viaje o) {
		  int resultado=0;
	        if (this.fechaSalida.isBefore(o.fechaSalida)) {   resultado = -1;      }

	        else if (this.fechaSalida.isAfter(o.fechaSalida)) {    resultado = 1;      }
	        else {resultado =-1;}
		return resultado;
	}
	
}
