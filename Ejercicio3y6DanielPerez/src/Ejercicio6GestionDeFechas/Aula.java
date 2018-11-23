/**
 * 
 */
package Ejercicio6GestionDeFechas;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import Ejercicio3GestionLicensias.Licencia;
import Ejercicio3GestionLicensias.LicenciaTemporal;

/**
 * @author Dani_
 *
 */
public class Aula extends Espacios  implements Cloneable{

	private  HashSet<LocalDate> examenes;
	
	public Aula (String nombre, String ubicacion, int capacidad) {
		super(nombre,ubicacion,capacidad);
		examenes = new HashSet<LocalDate>();
		
	}
	public Aula (String nombre, String ubicacion) {
		super(nombre,ubicacion,30);
		examenes = new HashSet<LocalDate>();
	}
	
	public void addExamenes (LocalDate ...fechaexamenes) {
		for (LocalDate localDate : fechaexamenes) {
			examenes.add(localDate);
			
		}
	}
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
	
	@Override
	public Aula clone() {
		Aula copiaAula = (Aula) super.clone();
		//Modificamos para hacer la copia profunda
		 copiaAula.examenes = new HashSet<LocalDate>(this.examenes);
		return copiaAula;
	}
	
	@Override
	public String toString (){	       
        return "Aula: \n" + super.toString()
        		+ "examenes :" +this.examenes + "\n"
        		;
    }
	
	
}
