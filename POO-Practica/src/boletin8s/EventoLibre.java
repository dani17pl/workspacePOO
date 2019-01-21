/**
 * 
 */
package boletin8s;

/**
 * @author Dani_
 *
 */
public class EventoLibre extends Evento {
	
	public EventoLibre(String nombreEvento, double apuesta) {
		super(nombreEvento,apuesta);
	}
	
	@Override
	public boolean aceptar(String usuario, Marcador marcador) {
		for (Marcador marcadoraux: super.getApuestas().values()) {
			if(marcador.equals(marcadoraux)) {
				return false;
			}
		}
		return true;
	}
	
}
