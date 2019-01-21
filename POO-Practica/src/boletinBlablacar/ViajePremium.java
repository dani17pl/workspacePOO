/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class ViajePremium extends Viaje {

	public ViajePremium(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazas) {
		super(propietario, coche,ruta,fechaSalida,plazas);
	}
	public ViajePremium(String propietario, String coche, String ruta, LocalDate fechaSalida) {
		super(propietario, coche,ruta,fechaSalida);
	}
	
	//Funcionalidad
	public boolean CancelarViaje(String codigo) {
		for (Reserva reserva : super.getReservas()) {
			if (reserva.getCodigoReserva().equals(codigo)) {
				super.EliminarReserva(reserva);
				return true;
			}
		}
		return false;
	}	
	
	@Override
	public ViajePremium clone() {
		ViajePremium copiasViaje =(ViajePremium) super.clone();
		//Modificamos para hacer la copia profunda
		return copiasViaje;
	}
}