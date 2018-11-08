/**
 * 
 */
package boletinBlablacar;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * @author Dani_
 *
 */
public class ViajeSelectivo extends Viaje {

	private HashSet<String> usuariosVetados;
	
	public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazas) {
		super(propietario, coche,ruta,fechaSalida,plazas);
		usuariosVetados = new HashSet<String>();
	}
	public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida) {
		super(propietario, coche,ruta,fechaSalida);
		usuariosVetados = new HashSet<String>();
	}
	
	//Funciones 
	public void addUsuarioVetado(String nombre) {
		usuariosVetados.add(nombre);
	}
	public void removeUsuarioVetado(String nombre) {
		usuariosVetados.remove(nombre);
	}
	
	@Override
	public Reserva Reserva(String usuario) {
		
		if (usuariosVetados.contains(usuario)) {
			return null;
		}
		else {
			return super.Reserva(usuario);
		}
		
	}
	
	public String toString (){
	       
        return super.toString() 
        		+ "usuariosVetados:" +this.usuariosVetados + "\n"
        		;
    }
	
}