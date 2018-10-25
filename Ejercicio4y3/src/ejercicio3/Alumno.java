/**
 * 
 */
package ejercicio3;

/**
 * @author Dani_
 *
 */
public class Alumno {

	//Atributos
	private final String nombre;
	private final String dni;
	private double credito;
	
	//Constructores
	/**
	 * @author Dani_
	 * @param nombre Hace referencia al nombre del alumno
	 * @param dni Hace referencia al dni del alumno
	 * @param credito Hace referencia al credito del alumno
	 */
	public Alumno(String nombre, String dni, double credito) {
		this.nombre = nombre;
		this.dni = dni;
		this.credito = credito;
	}
	
	/**
	 * @author Dani_
	 * El credito se inicializa por defecto a 100
	 * @param nombre Hace referencia al nombre del alumno
	 * @param dni Hace referencia al dni del alumno
	 */
	public Alumno(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.credito = 100;
	}
	
	//Metodos consultores
	/**
	 * @author Dani_
	 * @return devuelve el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve el dni del alumno
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * @author Dani_
	 * @return devuelve el credito del alumno
	 */
	public double getCredito() {
		return credito;
	}
	
	//Metodos 
	/**
	 * @author Dani_
	 * Aumentamos el credito una cierta cantidad
	 * @param incremento Hace referencia al aumento del credito de alumno
	 */
	public void incrementarCredito(double incremento) {
		this.credito = this.credito + incremento;
	}
	
	/**
	 * @author Dani_
	 * Disminuye el credito una cierta cantidad
	 * @param decremento Hace referencia a la disminucion del credito de alumno
	 */
	public void decrementarCredito(double decremento) {
		this.credito = this.credito - decremento;
	}
}
