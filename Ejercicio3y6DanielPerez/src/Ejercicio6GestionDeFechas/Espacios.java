/**
 * 
 */
package Ejercicio6GestionDeFechas;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public abstract class Espacios implements Cloneable {

	private String nombre;
	private String ubicacion;
	private String descripcion;
	private int capacidad;
	private LinkedList<Reservas> reservas;
	
	
	public Espacios(String nombre, String ubicacion, int capacidad) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.descripcion = nombre + "-" + ubicacion;
		reservas = new LinkedList <Reservas>();
	}
	
	public Espacios(String nombre, String ubicacion) {
		 this(nombre,ubicacion,30);	
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
		this.descripcion = nombre + "-" + ubicacion;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
		this.descripcion = nombre + "-" + ubicacion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the reservas
	 */
	public LinkedList<Reservas> getReservas() {
		LinkedList<Reservas> reservas= new LinkedList <Reservas>(this.reservas);
		return reservas;
	}


	public boolean consultar(LocalDate fecha, Tramo tramo) {
		Ocupacion ocupacion = new Ocupacion (tramo, fecha);
		for (Reservas reservas : reservas) {
			if (reservas.getOcupacion().equals(ocupacion)) {
				return false;
			}
		}
		return true;
	}
	
	public abstract boolean aplicable(String usuario,  LocalDate fecha);
	
	public Reservas reservar(String usuario, LocalDate fecha, Tramo tramo) {
		if (this.consultar(fecha,tramo) && aplicable(usuario,fecha)) {
			Ocupacion ocupacion = new Ocupacion (tramo, fecha);
			Reservas reserva = new Reservas(usuario,this,ocupacion);
			this.reservas.add(reserva);
			return reserva;
		}
		else {
			return null;
		}
	}
	
	public Reservas reservar(String usuario, Tramo tramo) {
		LocalDate fecha = LocalDate.now().plusDays(1);
		return this.reservar(usuario, fecha, tramo);
	}
	
	public boolean eliminarReserva(Reservas reserva) {
		return reservas.remove(reserva);
	}
	
	@Override
	public Espacios clone() {
		Espacios copiasEspacios = copiaSuperficial();
		//Modificamos para hacer la copia profunda
		copiasEspacios.reservas = new LinkedList <Reservas>(); 
		return copiasEspacios;
	}
	
	private Espacios copiaSuperficial () {
		 try{
		        Espacios copiaEspacio = (Espacios)super.clone();	 
		        return copiaEspacio;
		    }catch(CloneNotSupportedException e) {
		    	 System.err.println("La clase no es cloneable");
		    }
		 return null;
	}

	@Override
	public String toString (){	       
        return 
        		 "nombre :" +this.nombre + "\n"
        		+ "ubicacion:" +this.ubicacion + "\n"
        		+ "descripcion:" +this.descripcion + "\n"
        		+ "capacidad :" +this.capacidad + "\n"
        		+ "reservas:" +this.reservas + "\n"
        		;
    }
}
