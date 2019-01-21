package boletin8s;


public class Marcador {

	private final int tanteoLocal;
	private final int tanteVisitante;
	
	public Marcador(int tanteoLocal,int tanteVisitante ) {
		this.tanteoLocal = tanteoLocal;
		this.tanteVisitante = tanteVisitante;
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
		
		Marcador otro = (Marcador) obj;	
		return (this.tanteoLocal==otro.tanteoLocal && this.tanteVisitante == otro.tanteVisitante);
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
		result = primo * result + this.tanteoLocal;
		result = primo * result + this.tanteVisitante;
		return result;
	}
	
	@Override 
	public String toString() {	       
        return tanteoLocal + " - " + tanteVisitante; 
    }
}
