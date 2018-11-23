/**
 * 
 */
package Ejercicio6GestionDeFechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class SalaDeReunion extends Espacios  implements Cloneable{

	private HashMap<String,LinkedList<Reservas>> mapa;
	
	public SalaDeReunion (String nombre, String ubicacion, int capacidad) {
		super(nombre,ubicacion,capacidad);
		mapa = new  HashMap<String,LinkedList<Reservas>> ();
	}
	public SalaDeReunion (String nombre, String ubicacion) {
		this(nombre,ubicacion,30);
		
	}
	
	
	public ArrayList<String> getUsuariosReservas() {
		if (mapa.isEmpty()) {
			return null;
		}
		else {
		ArrayList<String> lista = new ArrayList<String>(mapa.size());
		for (String usuario : mapa.keySet()) {
			lista.add(usuario);
		}
		return lista;
		}	
	}
	
	public LinkedList<Reservas> getReservasDeUsuario(String usuario) {
		
		if (!mapa.isEmpty()) {
			if (mapa.containsKey(usuario)) {
			return mapa.get(usuario);
			}
		}
	
		return null;
		
	}
	@Override
	public boolean aplicable(String usuario,  LocalDate fecha) {
		if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY ) {
			return false;
		}
		
		LinkedList<Reservas> reservas = getReservasDeUsuario(usuario);
		if (reservas != null) {
			for (Reservas reserva : reservas) {
				if (reserva.getOcupacion().getFechaCaducidad().isAfter(LocalDate.now())) {
					return  false;
				}
			}
		}
		
		return true;
	}
	
	@Override 
	public Reservas reservar(String usuario, LocalDate fecha, Tramo tramo) {
		Reservas reserva = super.reservar(usuario, fecha, tramo);
		if(reserva != null) {
			if(mapa.containsKey(usuario)) {
				this.getReservasDeUsuario(usuario).add(reserva);
			}
			else {
				LinkedList<Reservas> reservas = new LinkedList<Reservas>(); 
				reservas.add(reserva);
				mapa.put(usuario,reservas);
			}
			return reserva;
		} else {
			return null;	
		}
		
	}
	
	@Override
	public SalaDeReunion clone() {
		SalaDeReunion copiaSalaDeReunion = (SalaDeReunion) super.clone();
		//Modificamos para hacer la copia profunda
		copiaSalaDeReunion.mapa = new  HashMap<String,LinkedList<Reservas>>(this.mapa);
		return copiaSalaDeReunion;
	}
	
	@Override
	public String toString (){	       
        return "Sala de reunion: \n" + super.toString()
        		+ "Reservas de usuario :" +this.mapa + "\n"
        		;
    }
	
}
