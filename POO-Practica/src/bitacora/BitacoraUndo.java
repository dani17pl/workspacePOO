package bitacora;

public class BitacoraUndo extends Bitacora {

	//Atributos
	// propiedad calculada ultimaE ntrada
	
	//Constructor
	public BitacoraUndo(String nombre) {
		super(nombre);
	}
	
	
	
	//Nueva funcionalidad
	
	public Entrada getUltimaEntrada() {
		if(super.getEntradas()==null) {
			return null;
		}
		return super.getEntradas().get(super.getNumeroEntradas()-1);
	}
	
	public boolean deshacerEntrada() {
		if(super.getEntradas()==null) {
			return false;
		}else {
			super.getEntradas().remove(super.getNumeroEntradas()-1);
			return true;
		}
	}
	

}
