/**
 * 
 */
package bitacora;

import java.util.HashSet;

/**
 * @author Dani_
 *
 */
public class Bitacora {

	private final String nombre;
	private HashSet<Entrada> entradas;
	//Nunmero entradas propiedad calculable
	
	//Constructor
	public Bitacora(String nombre) {
		this.nombre=nombre;
	}
	
	//Metodos consulta
	public String getNombre()
	{
		return nombre;
	}
	
	public HashSet<Entrada> getEntradas() {
		return entradas;
	}
	
	public int getNumeroEntradas() {
		return entradas.size();
	}
	
	//Metodos funcionalidad
	
	public boolean registrarEntrada(String texto) {
		Entrada entrada = new Entrada(texto);
		boolean insertado=entradas.add(entrada);
		return insertado;
	}
	
}
