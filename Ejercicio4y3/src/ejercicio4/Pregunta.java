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
	private final String respuestaCorrecta;
	private final Dificultad dificultad;
	
	//Constructores
	/**
	 * @author Dani_
	 * @param texto es un String con el texto de la pregunta
	 * @param respuestaCorrecta la solucion
	 * @param dificultad puede ser baja media o alta
	 */
	public Pregunta(String texto, String respuestaCorrecta, Dificultad dificultad) {
		this.texto = texto;
		this.respuestaCorrecta = respuestaCorrecta;
		this.dificultad = dificultad;
	}
	
	/**
	 * @author Dani_
	 * @param texto es un String con el texto de la pregunta
	 * @param respuestaCorrecta la solucion
	 */
	public Pregunta(String texto, String respuestaCorrecta) {
		this.texto = texto;
		this.respuestaCorrecta = respuestaCorrecta;
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
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	/**
	 * @author Dani_
	 * @return devuelve la dificultad de la pregunta
	 */
	public Dificultad getDificultad() {
		return dificultad;
	}

}
