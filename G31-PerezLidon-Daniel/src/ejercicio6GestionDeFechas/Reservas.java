/**
 * 
 */
package ejercicio6GestionDeFechas;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservas.
 *
 * @author Dani_
 */
public class Reservas {

	/** El usuario que hace la reserva. */
	private final String usuario;
	
	/** El espacio que ha reservado el usuario. */
	private final Espacios espacio;
	
	/** La ocupacion del espacio reservado. */
	private final Ocupacion ocupacion;
	
	/**
	 * Instancia una nueva reserva.
	 *
	 * @param usuario el usuario que hace la reserva
	 * @param espacio el espacio que ocupara
	 * @param ocupacion la ocupacion que representa tramo y fecha que el espacio estara ocupado 
	 */
	public Reservas(String usuario, Espacios espacio, Ocupacion ocupacion) {
		this.usuario = usuario;
		this.espacio = espacio;
		this.ocupacion = ocupacion;
	}

	/**
	 * Retorna el usuario de la reserva.
	 *
	 * @return el usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * retorns el espacio de la reserva.
	 *
	 * @return the espacio
	 */
	public Espacios getEspacio() {
		return espacio;
	}

	/**
	 * Gets the ocupacion.
	 *
	 * @return the ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	
	/** Metodo que hereda de Object.
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Clase que representa si una reserva es igual a otra para 
	 * ello se comprueba si la reserva tiene el mismo usuario, ocupacion y espacio 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Reservas otro = (Reservas) obj;	
		return this.usuario.equals(otro.usuario) && this.ocupacion.equals(otro.ocupacion) 
				&& this.espacio.equals(otro.espacio);
	}
	
	/** Metodo que hereda de Object.
	 * @see java.lang.Object#hashCode()
	 * 
	 * Sobrescribimos el método para que se comporte de forma acorde a la que lo hace .equals()
	 */
	@Override
	public int hashCode() {
		int primo = 31;
		int result = 1;
		result = primo * result + this.usuario.hashCode();
		result = primo * result + this.ocupacion.hashCode();
		result = primo * result + this.espacio.hashCode();
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {	       
        return  "Usuario :" + this.usuario + "\n"
        		+ "Ocupacion :" + this.ocupacion + "\n"
        		+ "espacio:" + this.espacio.getDescripcion()  + "\n";
    }
}
