/**
 * 
 */
package Ejercicio3GestionLicensias;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * @author Dani_
 *
 */
public class LicenciaDiario extends LicenciaTransaccionesLimitada {

	

	private final int MaxlimiteDiario;
	private int limiteDiario;
	private int codigo;
	private HashMap<Integer,LinkedList<Transaccion>> mapa;
	private LocalDate fechaDia;
	
	
	public LicenciaDiario(String email, String servicio, int numeroTransacciones, int limiteDiario ) {
		super(email,servicio,numeroTransacciones);
		this.MaxlimiteDiario = limiteDiario;
		this.limiteDiario = limiteDiario;
		this.fechaDia = null;
		this.codigo = 0;
		this.mapa = new HashMap<Integer,LinkedList<Transaccion>>();
	}
	
	/**
	 * @return the maxlimiteDiario
	 */
	public int getMaxlimiteDiario() {
		return MaxlimiteDiario;
	}

	/**
	 * @return the limiteDiario
	 */
	public int getLimiteDiario() {
		return limiteDiario;
	}

	/**
	 * @return the mapa
	 */
	public HashMap<Integer, LinkedList<Transaccion>> getMapa() {
		return mapa;
	}

	/**
	 * @return the fechaDia
	 */
	public LocalDate getFechaDia() {
		return fechaDia;
	}
	
	@Override
	public boolean aplicable() {
		
		if(super.aplicable()) {
			if (limiteDiario > 0) {
				return true;
			}
		}
		
		return false;	
	}
	
	@Override
	public Transaccion getAutorizacion() {
		Transaccion transaccion = super.getAutorizacion();
		if (transaccion != null) {
			if(this.fechaDia!= null && LocalDate.now().isEqual(this.fechaDia)) {
				mapa.get(this.codigo).add(transaccion);
				this.limiteDiario --;
				return transaccion;
			} else {
				this.codigo ++;
				this.fechaDia = LocalDate.now();
				LinkedList<Transaccion> transacciones = new LinkedList<Transaccion>();
				transacciones.add(transaccion);
				mapa.put(codigo, transacciones);
				this.limiteDiario = MaxlimiteDiario;
				this.limiteDiario --;
				return transaccion;
			}
			
		} else {
			return null;
		}
	}

	public LicenciaDiario clone() {
		LicenciaDiario copiaLicencia = (LicenciaDiario) super.clone();
		//Modificamos para hacer la copia profunda
		copiaLicencia.mapa = new HashMap<Integer,LinkedList<Transaccion>>(this.mapa);
		return copiaLicencia;
	}
	
	@Override
	public String toString (){	       
        return super.toString()
        		+ "MaxlimiteDiario :" +this.MaxlimiteDiario + "\n"
        		+ "mapa :" +this.mapa + "\n"
        		;
    }
}