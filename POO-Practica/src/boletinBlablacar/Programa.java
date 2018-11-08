/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.time.Month;
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
		ViajeSelectivo viajeSelectivo = new ViajeSelectivo("José Antonio","Seat León","Murcia–Campus",LocalDate.of(2019,Month.JUNE,10),4);
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
			System.out.println();
			
		} 
	}

}
