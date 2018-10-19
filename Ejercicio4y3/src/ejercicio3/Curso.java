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
	private final double precio_matricula;
	private LinkedList<Alumno> alumnos_matriculados;
	private int numero_alumnos_matriculados;
	private final int cupo;
	private LinkedList<Calificacion> calificaciones;
	
	//Constructor
	public Curso(String titulo, double precio_matricula, int cupo) {
		this.titulo=titulo;
		this.precio_matricula = precio_matricula;
		this.cupo = cupo;
		this.alumnos_matriculados = new LinkedList<Alumno>();
		this.calificaciones=new LinkedList<Calificacion>();
	}

	//Metodos consultores
	public String getTitulo() {
		return titulo;
	}

	public double getPrecio_matricula() {
		return precio_matricula;
	}

	public List<Alumno> getAlumnos_matriculados() {
		LinkedList<Alumno>alumnos_matriculados=new LinkedList<Alumno>(this.alumnos_matriculados);
		return alumnos_matriculados;
	}

	public int getNumero_alumnos_matriculados() {
		this.numero_alumnos_matriculados=alumnos_matriculados.size();
		return numero_alumnos_matriculados;
	}

	public int getCupo() {
		return cupo;
	}

	public List<Calificacion> getCalificaciones() {
		LinkedList<Calificacion>calificaciones=new LinkedList<Calificacion>(this.calificaciones);
		return calificaciones;
	}
	
	//Metodos operacionales
	
	public boolean matricularAlumno(Alumno alumno) {
		if (this.alumnos_matriculados.contains(alumno) || alumno.getCredito() < precio_matricula
				|| this.getNumero_alumnos_matriculados() >= cupo) {
			return false;
		}
		
		this.alumnos_matriculados.add(alumno);
		alumno.decrementarCredito(precio_matricula);
		return true;
	}
	
	public boolean calificarAlumno(Alumno alumno, int nota) {
		if (!this.alumnos_matriculados.contains(alumno) || nota > 10 || nota < 0 ) {
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
