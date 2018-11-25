/**
 * 
 */
package ejercicio6GestionDeFechas;

import java.time.LocalDate;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * Clase abstracta que representa un Espacio.
 *
 * @author Dani_
 */
public abstract class Espacios implements Cloneable {

	/** Nombre. */
	private String nombre;
	
	/** Ubicacion. */
	private String ubicacion;
	
	/** Descripcion. */
	private String descripcion;
	
	/** Capacidad. */
	private int capacidad;
	
	/** Reservas. */
	private LinkedList<Reservas> reservas;
	
	
	/**
	 * Instancia un nuevo espacio.
	 *
	 * @param nombre El nombre del espacio
	 * @param ubicacion La ubicacion del espacio
	 * @param capacidad La capacidad del espacio
	 * La desceripcion del espacio es una concatenacion del nombre y la ubicacion
	 */
	public Espacios(String nombre, String ubicacion, int capacidad) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.descripcion = nombre + "-" + ubicacion;
		reservas = new LinkedList<Reservas>();
	}
	
	/**
	 * Instancia un nuevo espacio con capacidad para 30 personas.
	 *
	 * @param nombre El nombre del espacio
	 * @param ubicacion La ubicacion del espacio
	 */
	public Espacios(String nombre, String ubicacion) {
		 this(nombre, ubicacion, 30);	
	}

	/**
	 * Retorna el nombre del espacio.
	 *
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre del espacio.
	 * Se modifica la descripcion con el nuevo nombre
	 * @param nombre el nuevo nombre del espacio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
		this.descripcion = nombre + "-" + ubicacion;
	}

	/**
	 * Retorna la ubicacion.
	 * Se modifica la descripcion con la nueva ubicacion
	 * @return la ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Cambia la ubicacion del espacio.
	 *
	 * @param ubicacion La nueva ubicacion del espacio
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
		this.descripcion = nombre + "-" + ubicacion;
	}

	/**
	 * Retorna la descripcion.
	 *
	 * @return la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * Retorna la capacidad del espacio.
	 *
	 * @return la capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Cambia la capacidad del espacio.
	 *
	 * @param capacidad La nueva capacidad del espacio
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Retorna las reservas del espacio.
	 *
	 * @return las reservas
	 */
	public LinkedList<Reservas> getReservas() {
		LinkedList<Reservas> reservas = new LinkedList<Reservas>(this.reservas);
		return reservas;
	}


	/**
	 * Consultar Consultar si hay reservas para una fecha y un tramo .
	 *
	 * @param fecha La fecha a consultar
	 * @param tramo El tramo a consultar
	 * @return true, Si no hay una reserva para esa fecha y tramo
	 */
	public boolean consultar(LocalDate fecha, Tramo tramo) {
		Ocupacion ocupacion = new Ocupacion(tramo, fecha);
		for (Reservas reservas : reservas) {
			if (reservas.getOcupacion().equals(ocupacion)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Aplicable. Metodo que implementaran las clases descencientes
	 * para saber si un usuario puede reservar el espacio
	 * 
	 * @param usuario El usuario que quiere hacer la reserva
	 * @param fecha La fecha del dia que quiere hacer la reserva
	 * @return true, Si cumple con los requisitos de las clases descendientes
	 */
	public abstract boolean aplicable(String usuario,  LocalDate fecha);
	
	/**
	 * Reservar. Reserva un espacio siempre y cuando no tenga reserva para ese dia y tramo (metodo consultar)
	 * y cumpla con las condiciones de ese espacio en particular (metodo aplicable)
	 *
	 * @param usuario El usuario que quiere hacer la reserva
	 * @param fecha La fecha representa el dia que se quiere reservar el espacio
	 * @param tramo El tramo representa si se quiere reservar por la mañana o por la tarde
	 * @return La reserva si se ha podido reservar o null en caso contrario
	 */
	public Reservas reservar(String usuario, LocalDate fecha, Tramo tramo) {
		if (this.consultar(fecha, tramo) && aplicable(usuario, fecha)) {
			Ocupacion ocupacion = new Ocupacion(tramo, fecha);
			Reservas reserva = new Reservas(usuario, this, ocupacion);
			this.reservas.add(reserva);
			return reserva;
		} else {
			return null;
		}
	}
	
	/**
	 * Reservar. Llama al metodo anterior con fecha de mañana
	 *
	 * @param usuario el usuario
	 * @param tramo el tramo
	 * @return La reserva si se ha podido reservar o null en caso contrario
	 */
	public Reservas reservar(String usuario, Tramo tramo) {
		LocalDate fecha = LocalDate.now().plusDays(1);
		return this.reservar(usuario, fecha, tramo);
	}
	
	/**
	 * Eliminar reserva del espacio.
	 *
	 * @param reserva La reserva que se quiere eliminar
	 * @return true, si se ha podido eliminar
	 */
	public boolean eliminarReserva(Reservas reserva) {
		return this.reservas.remove(reserva);
	}
	
	/* 
	 * Clase que hereda de Object Realiza una copia profunda del espacio
	 */
	@Override
	public Espacios clone() {
		Espacios copiasEspacios = copiaSuperficial();
		//Modificamos para hacer la copia profunda
		copiasEspacios.reservas = new LinkedList<Reservas>(); 
		return copiasEspacios;
	}
	
	/**
	 * Metodo que realiza una copia superficial del espacio llamando al metodo
	 * clone de la clase onject.
	 *
	 * @return the espacios
	 */
	private Espacios copiaSuperficial() {
		 try {
		        Espacios copiaEspacio = (Espacios) super.clone();	 
		        return copiaEspacio;
		    } catch (CloneNotSupportedException e) {
		    	 System.err.println("La clase no es cloneable");
		    }
		 return null;
	}

	/* 
	 * Metodo que hereda de Object Mostrara como se representa en pantalla el espacio
	 */
	@Override
	public String toString() {	       
        return 
        		 "nombre :" + this.nombre + "\n"
        		+ "ubicacion:" + this.ubicacion + "\n"
        		+ "descripcion:" + this.descripcion + "\n"
        		+ "capacidad :" + this.capacidad + "\n"
        		+ "reservas:" + this.reservas + "\n";
    }
}
