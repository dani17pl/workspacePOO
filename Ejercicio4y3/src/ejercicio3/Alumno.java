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
	
	public Alumno(String nombre, String dni, double credito) {
		this.nombre=nombre;
		this.dni=dni;
		this.credito=credito;
	}
	
	public Alumno(String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
		this.credito=100;
	}
	
	//Metodos consultores
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getCredito( ) {
		return credito;
	}
	
	//Metodos 
	
	public void incrementarCredito(double incremento) {
		this.credito=this.credito+incremento;
	}
	
	public void decrementarCredito(double decremento) {
		this.credito=this.credito-decremento;
	}
}
