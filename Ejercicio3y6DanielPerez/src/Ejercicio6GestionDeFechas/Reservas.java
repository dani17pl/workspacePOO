/**
 * 
 */
package Ejercicio6GestionDeFechas;

/**
 * @author Dani_
 *
 */
public class Reservas {

	private final String usuario;
	private final Espacios espacio;
	private final Ocupacion ocupacion;
	
	public Reservas(String usuario, Espacios espacio, Ocupacion ocupacion) {
		this.usuario = usuario;
		this.espacio = espacio;
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return the espacio
	 */
	public Espacios getEspacio() {
		return espacio;
	}

	/**
	 * @return the ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Reservas otro = (Reservas) obj;
		
		return this.usuario.equals(otro.usuario) && this.ocupacion.equals(otro.ocupacion) && this.espacio.equals(otro.espacio);
	}
	
	@Override
	public int hashCode() {
		int primo = 31;
		int result = 1;
		result = primo * result + this.usuario.hashCode();
		result = primo * result + this.ocupacion.hashCode();
		result = primo * result + this.espacio.hashCode();
		return result;
	}
	
	@Override
	public String toString (){	       
        return 
        		 "Usuario :" +this.usuario + "\n"
        		+ "Ocupacion :" +this.ocupacion + "\n"
        		+ "espacio:" +this.espacio.getDescripcion()  + "\n"
        		;
    }
}
