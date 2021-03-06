/**
 * 
 */
package ejercicio6GestionDeFechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * The Class SalaDeReunion.
 *
 * @author Dani_
 * 
 * Clase que representa el espacio denominado Sala de reunion desciende de Espacios
 */
public class SalaDeReunion extends Espacios  implements Cloneable {

	/** The mapa. Que representa las reservas de un usuario */
	private HashMap<String, LinkedList<Reservas>> mapa;
	
	/**
	 * Instancia una nueva sala de reunion.
	 *
	 * @param nombre el nombre de la sale de reunion
	 * @param ubicacion la ubicacion de la sala de reunion
	 * @param capacidad la capacidad de la sala de reunion
	 */
	public SalaDeReunion(String nombre, String ubicacion, int capacidad) {
		super(nombre, ubicacion, capacidad);
		mapa = new  HashMap<String, LinkedList<Reservas>>();
	} 
	
	/**
	 * Instancia una nueva sala de reunion con capacidad por defecto 30.
	 *
	 * @param nombre el nombre de la sale de reunion
	 * @param ubicacion la ubicacion de la sala de reunion
	 */
	public SalaDeReunion(String nombre, String ubicacion) {
		this(nombre,  ubicacion, 30);
		
	}
	
	
	/**
	 * Retorna los usuarios que tiene reservas.
	 *
	 * @return los usuarios que tienen reservas o null si no hay reservas 
	 */
	public Set<String> getUsuariosReservas() {
		if (this.mapa.isEmpty()) {
			return null;
		} else {
		HashSet<String> mapa = new HashSet<String>(this.mapa.keySet());
		
		return mapa;
		}	
	}
	
	/**
	 * retorna las reservas de un usuario.
	 *
	 * @param usuario del que queremos sus reservas
	 * @return las reservas del usuario en caso de que el usuario no tenga reservas retorna null
	 */
	public List<Reservas> getReservasDeUsuario(String usuario) {
		
		if (!mapa.isEmpty()) {
			if (mapa.containsKey(usuario)) {
				LinkedList<Reservas> lista = new LinkedList<Reservas>(mapa.get(usuario));
				return lista;
			}
		}
	
		return null;
		
	}
	
	/** Metodo heredado de la clase Espacio(Era un metodo abstracto).
	 * @see ejercicio6GestionDeFechas.Espacios#aplicable(java.lang.String, java.time.LocalDate)
	 * 
	 * Comprueba que la fecha no coincida con un dia de la semana que sea Sabado y Domingo
	 * y que el usuario no tenga una reserva posterior al dia del que intenta reservar
	 */
	@Override
	public boolean aplicable(String usuario,  LocalDate fecha) {
		if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return false;
		}
		
		LinkedList<Reservas> reservas = (LinkedList<Reservas>) getReservasDeUsuario(usuario);
		if (reservas != null) {
			for (Reservas reserva : reservas) {
				if (reserva.getOcupacion().getFechaCaducidad().isAfter(LocalDate.now())) {
					return  false;
				}
			}
		}
		
		return true;
	}
	
	/** Metodo heredado de la clase Espacio.
	 * @see ejercicio6GestionDeFechas.Espacios#reservar(java.lang.String, java.time.LocalDate, 
	 * ejercicio6GestionDeFechas.Tramo)
	 * 
	 * Llama al metodo de la clase padre(Espacio) si se consigue hacer una reserva esta se 
	 * anade a la listas de reservas del usuario si tiene reservas  o se crea su lista de reservas con esta reserva
	 */
	@Override 
	public Reservas reservar(String usuario, LocalDate fecha, Tramo tramo) {
		Reservas reserva = super.reservar(usuario, fecha, tramo);
		if (reserva != null) {
			if (mapa.containsKey(usuario)) {
				this.getReservasDeUsuario(usuario).add(reserva);
			} else {
				LinkedList<Reservas> reservas = new LinkedList<Reservas>(); 
				reservas.add(reserva);
				mapa.put(usuario, reservas);
			}
			return reserva;
		} else {
			return null;	
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalaDeReunion clone() {
		SalaDeReunion copiaSalaDeReunion = (SalaDeReunion) super.clone();
		//Modificamos para hacer la copia profunda
		copiaSalaDeReunion.mapa = new  HashMap<String, LinkedList<Reservas>>(this.mapa);
		return copiaSalaDeReunion;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return  super.toString()
        		+ "Reservas de usuario :" + this.mapa + "\n";
    }
	
}
