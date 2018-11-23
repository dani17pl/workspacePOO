/**
 * 
 */
package Ejercicio6GestionDeFechas;

import java.time.LocalDate;
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
		Aula aula1 = new Aula("A.01","Aulario norte",165);
		aula1.addExamenes(LocalDate.of(2019, 1, 10),LocalDate.of(2019, 1, 11));
		Aula aula2 = aula1.clone();
		Aula aula3 = aula1.clone();
		aula2.setNombre("A.02");
		aula3.setNombre("A.03");
		
		SalaDeReunion sala1 = new SalaDeReunion ("2.01","Fecultad de informatica",12);
		SalaDeReunion sala2 = new SalaDeReunion ("2.02","Fecultad de informatica",12);
		SalaDeReunion sala3 = new SalaDeReunion ("2.03","Fecultad de informatica");
		
		LinkedList <Espacios> espacios = new LinkedList <Espacios>();
		espacios.add(aula1);
		espacios.add(aula2);
		espacios.add(aula3);
		espacios.add(sala1);
		espacios.add(sala2);
		espacios.add(sala3);
		
		for (Espacios espacio : espacios) {
			System.out.println(espacio);
			System.out.println("-----------------------------------------------------------------------------------");
		}
		
		for (Espacios espacio : espacios) {
			System.out.println("ESPACIO---->" + espacio.getDescripcion());
			Reservas reserva = espacio.reservar("juan@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE);
			if (reserva !=null) {
				System.out.println("Aceptada" +reserva);
			}
			else {
				System.out.println("Rechazada " +espacio.getDescripcion());
			}
			
			System.out.println("--------------------------------------------------------------");
			espacio.consultar(LocalDate.of(2019, 1, 9), Tramo.TARDE);
			espacio.consultar(LocalDate.of(2019, 1, 9), Tramo.MA�ANA);
			reserva = espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE);
			if (reserva !=null) {
				System.out.println("Aceptada " +reserva);
			}
			else {
				System.out.println("Rechazada " +espacio.getDescripcion());
			}
			reserva = espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.MA�ANA);
			if (reserva !=null) {
				System.out.println("Aceptada" +reserva);
			}
			else {
				System.out.println("Rechazada " +espacio.getDescripcion());
			}
			
			reserva = espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 10), Tramo.MA�ANA);
			if (reserva !=null) {
				System.out.println("Aceptada" +reserva);
			}
			else {
				System.out.println("Rechazada " +espacio.getDescripcion());
			}
			
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
		}
		
		for (Espacios espacio : espacios) {
			System.out.println(espacio);
			System.out.println("-----------------------------------------------------------------------------------");
		}
		
		for (Espacios espacio : espacios) {
			if (espacio instanceof SalaDeReunion) {
				System.out.println(((SalaDeReunion) espacio).getUsuariosReservas());
				System.out.println(((SalaDeReunion) espacio).getReservasDeUsuario("juan@um.es"));
			}
			
		}
	}
	

}