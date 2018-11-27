/**
 * 
 */
package ejercicio3GestionLicensias;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
// TODO: Auto-generated Javadoc

/**
 * Clase LicenciaDiario hereda de la clase LicenciaTransaccionesLimitada.
 *
 * @author Dani_
 */
public class LicenciaDiario extends LicenciaTransaccionesLimitada {

	

	/** Las autoruzaciones que puede tener una Licencia en un dia. */
	private final int maxlimiteDiario;
	
	/** Las autorizaciones que le quedan en ese dia. */
	private int limiteDiario;
	
	/** El codigo que representa un dia donde hay transacciones. */
	private int codigo;
	
	/** El mapa. Representa las transacciones que hay en un dia */
	private HashMap<Integer, LinkedList<Transaccion>> mapa;
	
	/** La fecha del dia. */
	private LocalDate fechaDia;
	
	
	/**
	 * Instancia una licencia diaria.
	 *
	 * @param email el email
	 * @param servicio el servicio
	 * @param numeroTransacciones el numero de transacciones
	 * @param limiteDiario el limite diario
	 */
	public LicenciaDiario(String email, String servicio, int numeroTransacciones, int limiteDiario) {
		super(email, servicio, numeroTransacciones);
		this.maxlimiteDiario = limiteDiario;
		this.limiteDiario = limiteDiario;
		this.fechaDia = null;
		this.codigo = 0;
		this.mapa = new HashMap<Integer, LinkedList<Transaccion>>();
	}
	
	/**
	 * Retorna el maxlimite diario .
	 *
	 * @return the maxlimiteDiario
	 */
	public int getMaxlimiteDiario() {
		return maxlimiteDiario;
	}

	/**
	 * retorna el limite diario.
	 *
	 * @return the limiteDiario
	 */
	public int getLimiteDiario() {
		return limiteDiario;
	}

	/**
	 * Retorna el mapa.
	 *
	 * @return the mapa
	 */
	public Map<Integer, LinkedList<Transaccion>> getMapa() {
		HashMap<Integer, LinkedList<Transaccion>> mapa = 
				new HashMap<Integer, LinkedList<Transaccion>>(this.mapa);
		return mapa;
	}
	
	/*  Metodo que hereda de la clase LicenciaTransaccionesLimitada
	 * @see ejercicio3GestionLicensias.LicenciaTransaccionesLimitada#aplicable()
	 * 
	 * Comprueba si es no se ha superado el limite de esa licencia con una llamada al metodo del padre
	 * si no lo ha superado comprueba si no se ha superado el limite diario
	 */
	@Override
	public boolean aplicable() {	
		if (super.aplicable()) {
			if (limiteDiario > 0) {
				return true;
			}
		}
		
		return false;	
	}
	
	/* Metodo que hereda de la clase LicenciaTransaccionesLimitada
	 * @see ejercicio3GestionLicensias.LicenciaTransaccionesLimitada#getAutorizacion()
	 * 
	 * Si se ha podido hacer la autorizacion
	 * se resta una del limite diario si se encuentran en el mismo dia, si es otro dia 
	 * se establece el limite diario al maximo de la licencia y se resta uno.
	 * En un dia diferente tambien se cambia el codigo y se crea una nueva lista de transacciones
	 * y en los dos casos se añade la transaccion a la lista.
	 */
	@Override
	public Transaccion getAutorizacion() {
		Transaccion transaccion = super.getAutorizacion();
		if (transaccion != null) {
			if (this.fechaDia != null && LocalDate.now().isEqual(this.fechaDia)) {
				mapa.get(this.codigo).add(transaccion);
				this.limiteDiario--;
				return transaccion;
			} else {
				this.codigo++;
				this.fechaDia = LocalDate.now();
				LinkedList<Transaccion> transacciones = new LinkedList<Transaccion>();
				transacciones.add(transaccion);
				mapa.put(codigo, transacciones);
				this.limiteDiario = maxlimiteDiario;
				this.limiteDiario--;
				return transaccion;
			}
			
		} else {
			return null;
		}
	}

	/* Metodo que hereda de la clase LicenciaTransaccionesLimitada
	 * @see ejercicio3GestionLicensias.LicenciaTransaccionesLimitada#clone()
	 * Se modifica el atributo mapa para que sea una copia profunda
	 */
	@Override
	public LicenciaDiario clone() {
		LicenciaDiario copiaLicencia = (LicenciaDiario) super.clone();
		//Modificamos para hacer la copia profunda
		copiaLicencia.mapa = new HashMap<Integer, LinkedList<Transaccion>>(this.mapa);
		return copiaLicencia;
	}
	
	/*  Metodo que hereda de la clase LicenciaTransaccionesLimitada
	 * @see ejercicio3GestionLicensias.LicenciaTransaccionesLimitada#toString()
	 * 
	 * Añade las propiedades maxlimiteDiario, el limitediario y el mapa 
	 */
	@Override
	public String toString() {	       
        return super.toString()
        		+ "MaxlimiteDiario :" + this.maxlimiteDiario + "\n"
        		+ "limiteDiario :" + this.limiteDiario + "\n"
        		+ "mapa :" + this.mapa + "\n";
    }
}