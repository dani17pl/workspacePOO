/**
 * 
 */
package bitacora;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class BitacoraInteligente extends Bitacora{

	//Atributoos
	
	private final LinkedList<String> palabrasProhibidas;
	/**
	 * @return the palabrasProhibidas
	 */
	public LinkedList<String> getPalabrasProhibidas() {
		return palabrasProhibidas;
	}

	/**
	 * @return the spam
	 */
	public LinkedList<Entrada> getSpam() {
		return spam;
	}

	private LinkedList<Entrada> spam;
	
	public BitacoraInteligente(String nombre, String ...palabrasProhibidas) {
		super(nombre);
		this.palabrasProhibidas = new LinkedList<String>();
		this.palabrasProhibidas.addAll(Arrays.asList(palabrasProhibidas));
		spam = new LinkedList<Entrada>();
	}
	
	@Override
	public boolean registrarEntrada( String texto) {
		for (String palabra : palabrasProhibidas) {
			if (texto.contains(palabra)) {
				Entrada entrada = new Entrada(texto);
				spam.add(entrada);
				return false;
			}	
		}
		
		super.registrarEntrada(texto);
		return true;
	}
}
