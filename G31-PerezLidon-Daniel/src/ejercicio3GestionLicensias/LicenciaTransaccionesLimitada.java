/**
 * 
 */
package ejercicio3GestionLicensias;

// TODO: Auto-generated Javadoc
/**
 * Clase LicenciaTransaccionesLimitada hereda de la clase Licencia.
 *
 * @author Dani_
 */
public class LicenciaTransaccionesLimitada extends Licencia  {

	/** El numero de transacciones que le queda a una Licencia. */
	private int numeroTransacciones;
	/** El numero maximo de transacciones de una Licencia. */
	private int maxNumeroTransacciones;
	/**
	 * Instancia una nueva licencia de transacciones limitada.
	 *
	 * @param email el email de la licencia
	 * @param servicio el servicio de la licencia
	 * @param numeroTransacciones el numero de transacciones. Al principio sera igual el 
	 * maxNumeroTransacciones y el numeroTransacciones
	 */
	public LicenciaTransaccionesLimitada(String email, String servicio, int numeroTransacciones) {
		super(email, servicio);
		this.numeroTransacciones = numeroTransacciones;
		this.maxNumeroTransacciones = numeroTransacciones;
	
	}
	
	/**
	 * retornar el numero de transacciones restantes.
	 *
	 * @return el numeroTransacciones
	 */
	public int getNumeroTransaccionesRestantes() {
		return numeroTransacciones;
	}
	
	/**
	 * retornar el numero transacciones de una licencia.
	 *
	 * @return el maxnumeroTransacciones
	 */
	public int getNumeroTransacciones() {
		return maxNumeroTransacciones;
	}

	/** Metodo que hereda de la clase Licencia(es metodo abstacto).
	 * @see ejercicio3GestionLicensias.Licencia#aplicable()
	 * 
	 * comprueba que el numero de transacciones restantes sea superior a 0
	 */
	@Override
	public boolean aplicable() {
		// TODO Auto-generated method stub
		if (this.numeroTransacciones > 0) {
			return true;
		} else {
			return false;
		}	
	}
	
	/** Metodo que hereda de la clase Licencia.
	 * @see ejercicio3GestionLicensias.Licencia#getAutorizacion()
	 * 
	 * Redefinimos el metodo para cuando se consigue la autorizacion restar uno al 
	 * numero de transicciones restantes 
	 */
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicenciaTransaccionesLimitada clone() {
		LicenciaTransaccionesLimitada copiaLicencia = (LicenciaTransaccionesLimitada) super.clone();
		//Modificamos para hacer la copia profunda
		 
		return copiaLicencia;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return super.toString()
        		+ "numeroTransacciones :" + this.numeroTransacciones + "\n";
    }
	
}
