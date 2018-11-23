/**
 * 
 */
package Ejercicio3GestionLicensias;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class LicenciaTemporal extends Licencia {
	
	private LocalDate fechaCaducidad;
	private boolean caducada;
	
	public LicenciaTemporal(String email, String servicio) {
		//super(email,servicio);	
		//this.fechaCaducidad= super.getFechaCreacion().plusMonths(3);
		//this.caducada = false;
		this(email,servicio,LocalDate.now().plusMonths(3));	
	}
	
	public LicenciaTemporal(String email, String servicio, LocalDate fechaCaducidad) {
		super(email,servicio);
		this.fechaCaducidad = fechaCaducidad;
		this.caducada = false;
	}
	
	public void extenderFecha (int Newmonth) {
		
		this.fechaCaducidad.plusMonths(Newmonth);
	}

	@Override
	public boolean aplicable() {
		if(LocalDate.now().isAfter(this.fechaCaducidad)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public Licencia clone() {
		LicenciaTemporal copiaLicencia = (LicenciaTemporal) super.clone();
		//Modificamos para hacer la copia profunda
		 
		return copiaLicencia;
	}
	
	@Override
	public String toString (){	       
        return super.toString()
        		+ "fechaCaducidad :" +this.fechaCaducidad + "\n"
        		;
    }
}
