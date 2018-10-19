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
	
	public Calificacion(int nota, Alumno alumno) {
		this.nota=nota;
		this.alumno=alumno;
	}

	//Metodos consultores
	public int getNota() {
		return nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}
}
