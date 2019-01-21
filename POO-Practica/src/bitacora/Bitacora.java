/**
 * 
 */
package bitacora;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dani_
 *
 */
public class Bitacora {

	private final String nombre;
	private LinkedList<Entrada> entradas;
	//Nunmero entradas propiedad calculable
	
	//Constructor
	public Bitacora(String nombre) {
		this.nombre = nombre;
		this.entradas = new LinkedList<Entrada>();
	}
	
	//Metodos consulta
	public String getNombre()
	{
		return nombre;
	}
	
	public List<Entrada> getEntradas() {
		if(entradas.isEmpty()) {
			return null;
		}
	//	LinkedList<Entrada> entradas = new LinkedList<Entrada>(this.entradas);
		return entradas;
	}
	
	public int getNumeroEntradas() {
		return entradas.size();
	}
	
	//Metodos funcionalidad
	
	protected boolean registrarEntrada(String texto) {
		Entrada entrada = new Entrada(texto);
		boolean insertado=entradas.add(entrada);
		return insertado;
	}
	
}
