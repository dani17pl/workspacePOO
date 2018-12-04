/**
 * 
 */
package ejercicio6GestionDeFechas;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * @author Dani_
 * 
 * Clase Aula.
 * Clase que representa el espacio denominado Aula desciende de Espacios
 */
public class Aula extends Espacios  implements Cloneable	{

	/** examenes. Propiedad que representa los dias que hay examenes en el aula*/
	private  HashSet<LocalDate> examenes;
	
	/**
	 * Instancia una nueva aula.
	 *
	 * @param nombre el nombre
	 * @param ubicacion la ubicacion
	 * @param capacidad la capacidad
	 */
	public Aula(String nombre, String ubicacion, int capacidad) {
		super(nombre, ubicacion, capacidad);
		examenes = new HashSet<LocalDate>();
		
	}
	
	/**
	 * Instancia un nuevo aula con capacidad por defecto 30.
	 *
	 * @param nombre the nombre
	 * @param ubicacion the ubicacion
	 */
	public Aula(String nombre, String ubicacion) {
		this(nombre, ubicacion, 30);
	}
	
	/**
	 * añade un argumento variable con las fechas que el aula tendra examen.
	 *
	 * @param fechaexamenes las fechas donde habran examenes
	 */
	public void addExamenes(LocalDate...fechaexamenes) {
		for (LocalDate localDate : fechaexamenes) {
			examenes.add(localDate);
			
		}
	}
	
	/** Metodo heredado de la clase Espacio(metodo abstracto).
	 * @see ejercicio6GestionDeFechas.Espacios#aplicable(java.lang.String, java.time.LocalDate)
	 * 
	 * comprueba si no hay examenes en los dias que se quiere reservar 
	 * y que el usuario no tenga una reserva posterior al dia del que intenta reservar
	 */
	@Override
	public boolean aplicable(String usuario, LocalDate fecha) {
		for (LocalDate localDate : examenes) {
			if (fecha.isEqual(localDate)) {
				return false;
			}
		}
		for (Reservas reserva : super.getReservas()) {
			if (reserva.getUsuario().equals(usuario)) {
				if (reserva.getOcupacion().getFechaCaducidad().isEqual(fecha)) {
					return  false;
				}
			}
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Aula clone() {
		Aula copiaAula = (Aula) super.clone();
		//Modificamos para hacer la copia profunda
		 copiaAula.examenes = new HashSet<LocalDate>(this.examenes);
		return copiaAula;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return "Aula: \n" + super.toString()
        		+ "examenes :" + this.examenes + "\n";
    }
	
	
}
