/**
 * 
 */
package Ejercicio3GestionLicensias;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.UUID;

/**
 * @author Dani_
 *
 */
public abstract class Licencia implements Cloneable{

	private final String email;
	private final LocalDate fechaCreacion;
	private final String codigo;
	private LinkedList<Transaccion> transacciones;
	private boolean revocada;
	private final String servicio;
	
	public Licencia(String email,String servicio) {
		this.email = email;
		this.servicio = servicio;
		this.codigo = UUID.randomUUID().toString();
		this.fechaCreacion = LocalDate.now();
		this.transacciones = new  LinkedList<Transaccion>();
		this.revocada = false;
		
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	

	/**
	 * @return the transacciones
	 */
	public LinkedList<Transaccion> getTransacciones() {
		LinkedList<Transaccion> transacciones = new  LinkedList<Transaccion>(this.transacciones);
		return transacciones;
	}
	
	/**
	 * @return the revocada
	 */
	public int getNumeroTransacciones() {
		
		if(this.transacciones.isEmpty() || this.transacciones == null) {
			return 0;
		}
		else {
		return this.transacciones.size();
		}
	}

	/**
	 * @return the revocada
	 */
	public boolean isRevocada() {
		return revocada;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}
	
	//Funcionalidad
	
	public void revocar() {
		this.revocada = true;
	}
	
	public Transaccion getAutorizacion() {
		
		if(aplicable() && !this.revocada) {
			Transaccion transaccion = new Transaccion (this,LocalDate.now());
			this.transacciones.add(transaccion);
			Transaccion transaccionAux = new Transaccion (transaccion.getLicencia(),transaccion.getFecha());
			return transaccionAux;
		}
		else {
			return null;
		}
		
	}
	
	public abstract boolean aplicable();
	
	@Override
	public Licencia clone() {
		Licencia copiaLicencia = copiaSuperficial();
		//Modificamos para hacer la copia profunda
		copiaLicencia.transacciones = new LinkedList<Transaccion>(this.transacciones);	 
		return copiaLicencia;
	}
	
	private Licencia copiaSuperficial () {
		 try{
		        Licencia copiaLicencia = (Licencia)super.clone();	 
		        return copiaLicencia;
		    }catch(CloneNotSupportedException e) {
		    	 System.err.println("La clase no es cloneable");
		    }
		 return null;
	}
	
	@Override
	public String toString (){	       
        return "Licencia: \n"
        		+ "email :" +this.email + "\n"
        		+ "fecha de creacion:" +this.fechaCreacion + "\n"
        		+ "codigo:" +this.codigo + "\n"
        		+ "transacciones :" +this.transacciones + "\n"
        		+ "revocada:" +this.revocada + "\n"
        		+ "servicio:" +this.servicio + "\n"
        		;
    }
}

