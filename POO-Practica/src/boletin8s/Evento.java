/**
 * 
 */
package boletin8s;

import java.util.HashMap;

/**
 * @author Dani_
 *
 */
public abstract class Evento {

	private final String nombreEvento;
	private final double apuesta;
	private HashMap<String, Marcador> apuestas;
	private int numeroApuestas;
	private double recaudacion;
	
	public Evento(String nombreEvento, double apuesta) {
		this.nombreEvento = nombreEvento;
		this.apuesta = apuesta;
		this.apuestas = new HashMap<String, Marcador>();
		this.numeroApuestas = 0;
		this.recaudacion = 0;
	}
	
	
	
	/**
	 * @return the apuestas
	 */
	public HashMap<String, Marcador> getApuestas() {
		HashMap<String, Marcador> apuestas =new HashMap<String, Marcador>(this.apuestas);
		return apuestas;
	}

	/**
	 * @param apuestas the apuestas to set
	 */
	public void setApuestas(HashMap<String, Marcador> apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * @return the numeroApuestas
	 */
	public int getNumeroApuestas() {
		return numeroApuestas;
	}

	/**
	 * @param numeroApuestas the numeroApuestas to set
	 */
	public void setNumeroApuestas(int numeroApuestas) {
		this.numeroApuestas = numeroApuestas;
	}

	/**
	 * @return the recaudacion
	 */
	public double getRecaudacion() {
		return recaudacion;
	}



	/**
	 * @param recaudacion the recaudacion to set
	 */
	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}



	/**
	 * @return the nombreEvento
	 */
	public String getNombreEvento() {
		return nombreEvento;
	}



	/**
	 * @return the apuesta
	 */
	public double getApuesta() {
		return apuesta;
	}



	protected abstract boolean aceptar(String usuario, Marcador marcador);
	
	public boolean apostar(String usuario, Marcador marcador) {
		if (aceptar(usuario, marcador)) {
			apuestas.put(usuario, marcador);
			numeroApuestas ++;
			recaudacion = recaudacion + apuesta;
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString() {	       
        return "Evento: " + nombreEvento + "\n"
        		+ "	numero de Apuestas :" + numeroApuestas+ "\n"
        		+ "	recaudacion :" + recaudacion+ "\n"
        		+ apuestas;
    }
}
