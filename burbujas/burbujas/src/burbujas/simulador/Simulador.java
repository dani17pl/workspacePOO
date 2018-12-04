package burbujas.simulador;

import java.awt.Point;

import burbujas.elementos.Burbuja;
import burbujas.geometria.Circulo;
import burbujas.geometria.Punto;

/**
 * Simulador gráfico del proyecto burbujas.
 * Hace uso de las clases <code>Alarma</code> y <code>Pantalla</code> ofrecidas por la librería <code>burbujas-vista.jar</code>.
 * Las teclas para controlar la simulación son: 'c' para chocar, 'e' para explotar y 'f' para salir. 
 *
 */
public class Simulador {

	// Declaración de constantes
	
	private static final int TIEMPO_PARADA = 100;
	private static final String TECLA_CHOCAR = "c";
	private static final String TECLA_EXPLOTAR = "e";
	private static final String TECLA_SALIR = "f";

	
	
	private final int ancho;
	private final int alto;
	private Pantalla pantalla;

	/**
	 * Construye un simulador gráfico estableciendo sus dimensiones.
	 * @param ancho anchura en píxeles del simulador.
	 * @param alto altura en píxeles del simulador.
	 */
	public Simulador(int ancho, int alto) {

		this.ancho = ancho;
		this.alto = alto;
		this.pantalla = new Pantalla(ancho, alto);
	}

	/**
	 * Retorna la anchura de la pantalla de simulación.
	 * @return número que representa el ancho de la pantalla en píxeles.
	 */
	public int getAncho() {
		return ancho;
	}
	
	/**
	 * Retorna la altura de la pantalla de simulación.
	 * @return número que representa el alto de la pantalla en píxeles.
	 */
	public int getAlto() {
		return alto;
	}
	
	/**
	 * Esta operación realiza la simulación interactiva de una burbuja.
	 * @param burbuja burbuja para que vamos a realizar la simulación.
	 */
	public void simular(Burbuja burbuja) {

		pantalla.setBarraEstado("Pulse una tecla para empezar ...");

		while (!pantalla.hayTecla()) {
			Alarma.dormir(TIEMPO_PARADA);
		}

		pantalla.leerTecla(); // se ignora

		boolean finSimulacion = false;

		Circulo region = burbuja.getRegion();
		Punto centro = region.getCentro();

		while (centro.getY() - region.getRadio() <= this.alto && !burbuja.isExplotada() && !finSimulacion) {

			Alarma.dormir(TIEMPO_PARADA);
			burbuja.ascender();
			
			String accion = "";

			if (pantalla.hayTecla()) {
				
				String tecla = pantalla.leerTecla();
				if (tecla.equals(TECLA_CHOCAR)) {
					burbuja.chocar();
					accion = "chocar";
				}
				else if (tecla.equals(TECLA_EXPLOTAR)) {
					burbuja.explotar();
					accion = "explotar";
				}
				else if (tecla.equals(TECLA_SALIR)) {
					finSimulacion = true;
				}			
				
			}
			
			String info = burbuja.getInfo() + " " + accion;
			pantalla.setBarraEstado(info);
			
			pantalla.resetear();
			Point punto = new Point(centro.getX(), centro.getY()); 
			pantalla.addCirculo(punto, region.getRadio(), burbuja.getColor());
			pantalla.dibujar();
			
			region = burbuja.getRegion();
			centro = region.getCentro();
			
		}

		pantalla.resetear();
		pantalla.dibujar();
		pantalla.setBarraEstado("");
		
	}
}
