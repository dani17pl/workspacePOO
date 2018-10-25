/**
 * 
 */
package ejercicio3;

import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class Programa {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		
		Alumno alumno1 = new Alumno("Pepe", "34678904");
		Alumno alumno2 = new Alumno("Andrea", "17679456", 125);
		Alumno alumno3 = new Alumno("Antonio", "34972496", 200);
	
		Curso curso1 = new Curso("Diseño de bases de datos", 50, 2);
		Curso curso2 = new Curso("Administracion de bases de datos", 75, 5);
	
		LinkedList<Curso> cursos = new LinkedList<Curso>();
		cursos.add(curso1);
		cursos.add(curso2);	
	
		for (Curso curso : cursos) {
			curso.matricularAlumno(alumno1);
			curso.matricularAlumno(alumno2);
			curso.matricularAlumno(alumno3);
			
			System.out.println("Alumnos matriculados en " + curso.getTitulo() + ": ");
			for (Alumno alumno : curso.getAlumnosMatriculados()) {
				System.out.println("\t" + alumno.getNombre());
				curso.calificarAlumno(alumno, 10);
			}
			
			System.out.println("calificaciones en " + curso.getTitulo() + ": ");
			for (Calificacion calificacion : curso.getCalificaciones()) {
				System.out.println("\t" + calificacion.getAlumno().getNombre() 
						+ " tiene nota de: " + calificacion.getNota());
				
			}
			System.out.println();
		}	
	}
}
