/**
 * 
 */
package bitacora;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Dani_
 *
 */
public class BitacoraInteligente extends Bitacora{

	//Atributoos
	
	private final HashSet<String> palabrasProhibidas;
	private HashSet<Entrada> spam;
	
	public BitacoraInteligente(String nombre, String ...palabrasProhibidas) {
		super(nombre);
		this.palabrasProhibidas = new HashSet<String>();
		this.palabrasProhibidas.addAll(Arrays.asList(palabrasProhibidas));
		spam = new HashSet<Entrada>();
	}
	
	@Override
	public boolean registrarEntrada( String texto) {
		for (String palabra : palabrasProhibidas) {
			if (texto.contains(palabra)) {
				Entrada entrada = new Entrada(texto);
				spam.add(entrada);
			}	
		}
		
		super.registrarEntrada(texto);
		return true;
	}
}
