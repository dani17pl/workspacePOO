package bitacora;

import java.util.LinkedList;

public class Programa {
	
	/**
	 * @param args 
	 */
	public static void main(String[] args) {
	Bitacora basica1 = new Bitacora("basica1");
	BitacoraInteligente inteligente1 = new BitacoraInteligente("inteligente1","facebook","thepiratebay");
	BitacoraInteligente inteligente2 = new BitacoraInteligente("inteligente2","foto","descargar");
	BitacoraUndo undo1 = new BitacoraUndo("undo1");
	
	LinkedList<Bitacora> bitacoras = new LinkedList<Bitacora>();
	bitacoras.add(basica1);
	bitacoras.add(inteligente1);
	bitacoras.add(inteligente2);
	bitacoras.add(undo1);
	

	for (Bitacora bitacora : bitacoras) {
		bitacora.registrarEntrada("Se ha producido un error en el servicio");
		bitacora.registrarEntrada("Puedes descargar el driver desde thepiratebay");
		bitacora.registrarEntrada("Las fotos están publicadas en facebook");	
	}
	
	for (Bitacora bitacora : bitacoras) {
		
		if(bitacora instanceof BitacoraUndo) {
			((BitacoraUndo) bitacora).deshacerEntrada();
		}
		
		System.out.println(bitacora.getNombre());
		for (Entrada entrada : bitacora.getEntradas()) {
			System.out.println(entrada.getSuceso()+ " -En la hora: " + entrada.getFecha());
		}
		System.out.println();
	}
	
	}
}
