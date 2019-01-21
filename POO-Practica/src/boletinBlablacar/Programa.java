/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
/**
 * @author Dani_
 *
 */
public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Viaje viaje = new Viaje("José Antonio","Seat León","Murcia-Cartagena",LocalDate.of(2019,Month.JUNE,9));
		ViajeSelectivo viajeSelectivo = new ViajeSelectivo("José Antonio","Seat León","Murcia-Campus",LocalDate.of(2019,Month.JUNE,10),4);
		viajeSelectivo.addUsuarioVetado("Beatriz");
		ViajePremium viajePremium = new ViajePremium("José Antonio","Seat León","Murcia-Barcelona",LocalDate.of(2019,Month.JUNE,15),6);
		
		String Alberto="Alberto";
		viaje.Reserva(Alberto);
		viaje.Reserva(Alberto);
		
		String Enrique ="Enrique";
		viajeSelectivo.Reserva(Enrique);
		viajeSelectivo.Reserva(Enrique);
		viajeSelectivo.Reserva(Enrique);
		
		viajeSelectivo.Reserva("Beatriz");
		
		String Ana = "Ana";
		viajePremium.Reserva(Ana);
		Reserva reserva = viajePremium.Reserva(Ana);
		viajePremium.CancelarViaje(reserva.getCodigoReserva());
		
		LinkedList<Viaje> viajes = new LinkedList<Viaje> ();
		viajes.add(viaje);
		viajes.add(viajeSelectivo);
		viajes.add(viajePremium);
		
		for (Viaje viaje2 : viajes) {
			if (viaje2 instanceof ViajeSelectivo) {
				((ViajeSelectivo) viaje2).removeUsuarioVetado("Beatriz");
			}
			System.out.println(viaje2);		
		} 
		LinkedList<Viaje> viajesCopia = new LinkedList<Viaje> ();
		for (Viaje viaje2 : viajes) {
			viaje = viaje2.clone();
			viajesCopia.add(viaje);
			if (viaje2 instanceof ViajePremium) {
				viaje.getReservas().removeAll(viaje.getReservas());
			}	
		}
		for (Viaje viaje3 : viajesCopia) {
			System.out.println(viaje3);
			System.out.println();
	}
		
		Collections.sort(viajes);
		for (Viaje viaje4 : viajes) {
			System.out.println(viaje4);
	}
		System.out.println();
		
		//viajes.sort(new OrdenarViajePorRuta());
		viajes.sort(Comparator.comparing(Viaje::getRuta)); // Java 8
		viajes.forEach(System.out::println);
	}
}
