/**
 * 
 */
package ejercicio3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dani_
 *
 */
public class Curso {

	//Atributos
	private final String titulo;
	private final double precioMatricula;
	private LinkedList<Alumno> alumnosMatriculados;
	private final int cupo;
	private LinkedList<Calificacion> calificaciones;
	// Numero de alumnos es una propiedad calculable
	
	//Constructor
	/**
	 * @author Dani_
	 * @param titulo nombre del curso
	 * @param precioMatricula el precio del curso
	 * @param cupo numero maximo de alumnos que admite el curso
	 */
	public Curso(String titulo, double precioMatricula, int cupo) {
		this.titulo = titulo;
		this.precioMatricula = precioMatricula;
		this.cupo = cupo;
		this.alumnosMatriculados = new LinkedList<Alumno>();
		this.calificaciones = new LinkedList<Calificacion>();
	}

	//Metodos consultores
	/**
	 * @author Dani_
	 * @return devuelve el titulo del curso
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve el Precio de la matricula
	 */
	public double getPrecioMatricula() {
		return precioMatricula;
	}
	/**
	 * @author Dani_
	 * @return devuelve la lista de alumnos matriculados
	 */
	public List<Alumno> getAlumnosMatriculados() {
		LinkedList<Alumno> alumnosMatriculados = new LinkedList<Alumno>(this.alumnosMatriculados);
		return alumnosMatriculados;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve el numero de alumnos matriculados
	 */
	public int getNumeroAlumnosMatriculados() {
		return  alumnosMatriculados.size();
	}

	/**
	 * @author Dani_
	 * @return devuelve el cupo del curso
	 */
	public int getCupo() {
		return cupo;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve la lista de calificaciomes
	 */
	public List<Calificacion> getCalificaciones() {
		LinkedList<Calificacion> calificaciones = new LinkedList<Calificacion>(this.calificaciones);
		return calificaciones; 
	}
	
	//Metodos operacionales
	/**
	 * @author Dani_
	 * @param alumno Alumno que se matriculara en el curso
	 * @return devuelve falso si el alumno no se puede matricular y verdadero en caso contrario
	 */
	public boolean matricularAlumno(Alumno alumno) {
		if (this.alumnosMatriculados.contains(alumno) || alumno.getCredito() < precioMatricula
				|| this.getNumeroAlumnosMatriculados() >= cupo) {
			return false;
		}
		
		this.alumnosMatriculados.add(alumno);
		alumno.decrementarCredito(precioMatricula);
		return true;
	}
	
	/**
	 * @author Dani_
	 * @param alumno Alumno que se matriculara en el curso
	 * @param nota obtenida por el alumno
	 * @return devuelve falso si el alumno no se puede calificarr y verdadero en caso contrario
	 */
	public boolean calificarAlumno(Alumno alumno, int nota) {
		if (!this.alumnosMatriculados.contains(alumno) || nota > 10 || nota < 0) {
			return false;
		}
		
		for (Calificacion calificacion : calificaciones) {
			if (alumno.equals(calificacion.getAlumno())) {
				return false;
			}
			
		}
		Calificacion calificacion = new Calificacion(nota, alumno);
		calificaciones.add(calificacion);
		return true;
	}
	
	
	
}
