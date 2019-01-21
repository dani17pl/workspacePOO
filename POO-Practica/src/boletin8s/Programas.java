/**
 * 
 */
package boletin8s;

import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class Programas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Evento Libre
		EventoLibre eventoLibre = new EventoLibre("Real Madrid - F.C. Barcelona", 1);
		Marcador marcador1 = new Marcador(5,0);
		eventoLibre.apostar("juan",marcador1);
		Marcador marcador2 = new Marcador(3,1);
		eventoLibre.apostar("pepe",marcador2);
		
		//Evento Restringido
		Marcador marcadorT1 = new Marcador(2,0);
		Marcador marcadorT2 = new Marcador(2,1);
		Marcador marcadorT3 = new Marcador(0,2);
		Marcador marcadorT4 = new Marcador(1,2);
		EventoRestringido eventoRestringido = new EventoRestringido("Nadal vs FEDERER", 3, marcadorT1,marcadorT2,marcadorT3,marcadorT4);
		eventoRestringido.apostar("juan", marcadorT1);
		eventoRestringido.apostar("pedro", marcadorT2);
		eventoRestringido.apostar("pepe", marcadorT1);
		
		
		LinkedList<Evento> eventos = new LinkedList<Evento>();
		eventos.add(eventoLibre);
		eventos.add(eventoRestringido);
		
		Marcador marcador5 = new Marcador(5,0);
		for (Evento evento : eventos) {
			System.out.println(evento);
			boolean resultado = evento.apostar("enrique", marcador5);
			System.out.println("La ha puesta se ha realizado? " + resultado );
		}
		

		for (Evento evento : eventos) {
			if (evento instanceof EventoRestringido) {
				System.out.println(((EventoRestringido) evento).getNumeroApuestas(marcadorT1));
			}

		}
	}

}
