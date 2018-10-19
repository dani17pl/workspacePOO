/**
 * 
 */
package ejercicio4;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class Examen {

	//Atributos
	private final String texto;
	private LinkedList<Pregunta> preguntas;
	private int numero_preguntas;
	
	/**
	 * @author Dani_
	 * @param texto es un String con el texto de la pregunta
	 */
	public Examen(String texto) {
		this.texto = texto;
		this.preguntas = new LinkedList<Pregunta>();
	}
	
	//Metodos consultivos
	/**
	 * @author Dani_
	 * @return el enuncido de la pregunta
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @author Dani_
	 * @return Lista de preguntas
	 */
	public List<Pregunta> getPreguntas() {
		List<Pregunta> preguntas = new LinkedList<Pregunta>(this.preguntas);
		return preguntas;
	}
	
	/**
	 * @author Dani_
	 * @return numero de preguntas
	 */
	public int getNumeroPreguntas() {
		this.numero_preguntas = this.preguntas.size();
		return this.numero_preguntas;
	}
	
	//Metodos
	/**
	 * @author Dani_
	 * @param pregunta add una pregunta a la lista de preguntas
	 */
	public void addPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	
	/**
	 * @author Dani_
	 * @param indice_pregunta indice de la pregunta que queremos obtener
	 * @return devuelve null si el indice no se encuentr en la lista si no devuelve la pregunta
	 */
	public Pregunta obtenerPregunta(int indice_pregunta) {
		if (indice_pregunta > this.preguntas.size() - 1) {
			return null;
		}
		
		return this.preguntas.get(indice_pregunta - 1);
	}
	
	/**
	 * @author Dani_
	 * @param indice_pregunta indice de la pregunta que queremos borrar
	 * @return devuelve false si el indice no se encuentr en la lista si no true si se borra
	 */
	public boolean  borrarPregunta(int indice_pregunta) {
		if (indice_pregunta > this.preguntas.size() - 1 || indice_pregunta < 1) {
			return false;
		}	
		this.preguntas.remove(indice_pregunta - 1);
		return true;
	}
	
	/**
	 * @author Dani_
	 * @param respuestas atributo variable que represent todas las respuestas
	 * @return devuelve -1 si las respuestas no coinciden con el numero de preguntas si no devuelve la nota
	 */
	public double corregir(String...respuestas) {
		if (this.getNumeroPreguntas() != respuestas.length) {
			return -1;
		}
		
		double preguntasAcertadas = 0;
		for (int i = 0; i < respuestas.length; i++) {
			if (respuestas[i] == this.preguntas.get(i).getRespuesta_correcta()) {
				preguntasAcertadas++;
			}	
		}
		return (preguntasAcertadas * 10) / this.getNumeroPreguntas();
	}
}