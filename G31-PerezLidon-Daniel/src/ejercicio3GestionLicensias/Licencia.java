/**
 * 
 */
package ejercicio3GestionLicensias;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * Clase abstracta Licencia.
 *
 * @author Dani_
 */
public abstract class Licencia implements Cloneable {

	/** El email.  */
	private final String email;
	
	/** La fecha creacion. */
	private final LocalDate fechaCreacion;
	
	/** El codigo. */
	private final String codigo;
	
	/** Las transacciones. */
	private LinkedList<Transaccion> transacciones;
	
	/**  revocada. Representa si la licencia sigue en curso o no */
	private boolean revocada;
	
	/** El servicio. */
	private final String servicio;
	
	/**
	 * Instancia una nueva licencia.
	 *
	 * @param email El email de la licencia
	 * @param servicio El servicio de la licencia
	 */
	protected Licencia(String email, String servicio) {
		this.email = email;
		this.servicio = servicio;
		this.codigo = UUID.randomUUID().toString();
		this.fechaCreacion = LocalDate.now();
		this.transacciones = new  LinkedList<Transaccion>();
		this.revocada = false;
		
	}

	/**
	 * Retorna el email de la licencia.
	 *
	 * @return el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * retorna la fecha de creacion de la licencia.
	 *
	 * @return la fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Retorna el codigo de la licencia.
	 *
	 * @return El codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	

	/**
	 * Retorna las transacciones de la licencias.
	 *
	 * @return las transacciones
	 */
	public List<Transaccion> getTransacciones() {
		LinkedList<Transaccion> transacciones = new  LinkedList<Transaccion>(this.transacciones);
		return transacciones;
	}
	
	/**
	 * Retorna el numero de transacciones.
	 *
	 * @return 0 si no hay transacciones o el tamano de la lista de transacciones
	 */
	public int getNumeroTransaccionesRestantes() {
		
		if (this.transacciones.isEmpty() || this.transacciones == null) {
			return 0;
		} else {
		return this.transacciones.size();
		}
	}

	/**
	 * Comprueba si la licencia esta revocada.
	 *
	 * @return revocada
	 */
	public boolean isRevocada() {
		return revocada;
	}

	/**
	 * Retorna el servicio.
	 *
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}
	
	//Funcionalidad
	
	/**
	 * Revocar. pone el atributo revocar en true por tanto la licencia queda revocada
	 */
	public void revocar() {
		this.revocada = true;
	}
	
	/**
	 * Consigue la autorizacion para la licencia.
	 * Para eso la licencia no puede estar revocada y debe ser aplicable
	 * cada clase que herede de esta clase debera definir cuando su licencia se puede aplicar
	 * 
	 * @return la transacion si se ha podido autorizar o null en caso contrario
	 */
	public Transaccion getAutorizacion() {
		
		if (aplicable() && !this.revocada) {
			Transaccion transaccion = new Transaccion(this, LocalDate.now());
			this.transacciones.add(transaccion);
			return transaccion;
		} else {
			return null;
		}
		
	}
	
	/**
	 * Aplicable. Metodo abstracto que definiran las clases que hereden de esta para saber cuando
	 * es aplicable su licencia
	 *
	 * @return true, si la licencia es aplicable y false en caso contrario
	 */
	public abstract boolean aplicable();
	
	/** Metodo heredado de la clase Object.
	 * @see java.lang.Object#clone()
	 * 
	 * Metodo que realizara una copia de la licencia
	 * Modifica el atributo transacciones 
	 *  
	 * @return retorna la licencia
	 **/
	@Override
	public Licencia clone() {
		Licencia copiaLicencia = copiaSuperficial();
		//Modificamos para hacer la copia profunda
		copiaLicencia.transacciones = new LinkedList<Transaccion>(this.transacciones);	 
		return copiaLicencia;
	}
	
	/**
	 * Copia superficial. Realiza una copia superficial utilizando el metodo clone de la clsae object
	 *
	 * @return retorna la licencia
	 */
	private Licencia copiaSuperficial() {
		 try {
		        Licencia copiaLicencia = (Licencia) super.clone();	 
		        return copiaLicencia;
		    } catch (CloneNotSupportedException e) {
		    	 System.err.println("La clase no es cloneable");
		    }
		 return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return "Licencia: \n"
        		+ "email :" + this.email + "\n"
        		+ "fecha de creacion:" + this.fechaCreacion + "\n"
        		+ "codigo:" + this.codigo + "\n"
        		+ "transacciones :" + this.transacciones + "\n"
        		+ "revocada:" + this.revocada + "\n"
        		+ "servicio:" + this.servicio + "\n";
    }
}

