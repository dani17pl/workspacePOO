/**
 * 
 */
package Ejercicio3GestionLicensias;

import java.time.LocalDate;

/**
 * @author Dani_
 *
 */
public class LicenciaTransaccionesLimitada extends Licencia  {

	private int numeroTransacciones;
	
	public LicenciaTransaccionesLimitada(String email, String servicio, int numeroTransacciones ) {
		super(email,servicio);
		this.numeroTransacciones = numeroTransacciones;
	
	}
	/**
	 * @return the numeroTransacciones
	 */
	public int getNumeroTransacciones() {
		return numeroTransacciones;
	}

	@Override
	public boolean aplicable() {
		// TODO Auto-generated method stub
		if(this.numeroTransacciones > 0) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	@Override
	public Transaccion getAutorizacion() {
		Transaccion transaccion = super.getAutorizacion();
		if (transaccion != null) {
			this.numeroTransacciones--;
			return transaccion;
		} else {
			return null;
		}
	}
	
	public LicenciaTransaccionesLimitada clone() {
		LicenciaTransaccionesLimitada copiaLicencia = (LicenciaTransaccionesLimitada) super.clone();
		//Modificamos para hacer la copia profunda
		 
		return copiaLicencia;
	}
	
	
	@Override
	public String toString (){	       
        return super.toString()
        		+ "numeroTransacciones :" +this.numeroTransacciones + "\n"
        		;
    }
	
}
