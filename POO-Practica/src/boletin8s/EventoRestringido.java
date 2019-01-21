/**
 * 
 */
package boletin8s;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author Dani_
 *
 */
public class EventoRestringido extends Evento{

	private HashMap<Marcador,Integer> opciones;
	
	public EventoRestringido(String nombreEvento, double apuesta,  Marcador ...opciones) {
		super(nombreEvento,apuesta);
		this.opciones = new HashMap<Marcador,Integer>();
		for (Marcador resultados : opciones) {
			this.opciones.put(resultados, 0);
		}	
	}
	
	@Override
	public boolean aceptar(String usuario, Marcador marcador) {
		if(opciones.containsKey(marcador)) {
			opciones.replace(marcador, opciones.get(marcador)+1);
			return true;
		}
		return false;
	}
	
	public int getNumeroApuestas(Marcador marcador) {
		return opciones.get(marcador);
	}

	/**
	 * @return the opciones
	 */
	public HashMap<Marcador, Integer> getOpciones() {
		HashMap<Marcador,Integer> opciones = new HashMap<Marcador,Integer>(this.opciones);
		return opciones;
	}
}
