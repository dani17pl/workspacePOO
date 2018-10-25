/**
 * 
 */
package ejercicio3;

/**
 * @author Dani_
 *
 */
public class Calificacion {

	//Atributos
	private final int nota;
	private final Alumno alumno;
	
	//Constructor
	/**
	 * @author Dani_
	 * @param nota Hace referencia a la nota obteneida por el alumno
	 * @param alumno que ha sido calificado con una cierta nota
	 */
	public Calificacion(int nota, Alumno alumno) {
		this.nota = nota;
		this.alumno = alumno;
	}

	//Metodos consultores
	/**
	 * @author Dani_
	 * @return devuelve la nota 
	 */
	public int getNota() {
		return nota;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve el alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}
}
