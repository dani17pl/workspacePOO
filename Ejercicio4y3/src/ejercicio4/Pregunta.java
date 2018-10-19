/**
 * 
 */
package ejercicio4;

/**
 * @author Dani_
 *
 */
public class Pregunta {
	
	//Atributos
	private final String texto;
	private final String respuesta_correcta;
	private final Dificultad dificultad;
	
	//Constructores
	/**
	 * @author Dani_
	 * @param texto es un String con el texto de la pregunta
	 * @param respuesta_correcta la solucion
	 * @param dificultad puede ser baja media o alta
	 */
	public Pregunta(String texto, String respuesta_correcta, Dificultad dificultad) {
		this.texto = texto;
		this.respuesta_correcta = respuesta_correcta;
		this.dificultad = dificultad;
	}
	
	/**
	 * @author Dani_
	 * @param texto es un String con el texto de la pregunta
	 * @param respuesta_correcta la solucion
	 */
	public Pregunta(String texto, String respuesta_correcta) {
		this.texto = texto;
		this.respuesta_correcta = respuesta_correcta;
		this.dificultad = Dificultad.media;
	}
	
	//Metodos consultivos
	/**
	 * @author Dani_
	 * @return devuelve el enunciado de la pregunta
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve la solucion de la pregunta
	 */
	public String getRespuesta_correcta() {
		return respuesta_correcta;
	}
	/**
	 * @author Dani_
	 * @return devuelve la dificultad de la pregunta
	 */
	public Dificultad getDificultad() {
		return dificultad;
	}

}
