package burbujas.pruebas;

import java.util.Collections;
import java.util.LinkedList;

import burbujas.elementos.Burbuja;
import burbujas.elementos.BurbujaCreciente;
import burbujas.elementos.BurbujaDebil;
import burbujas.elementos.BurbujaLimitada;
import burbujas.elementos.BurbujaSensible;
import burbujas.geometria.Circulo;
import burbujas.geometria.Punto;
import burbujas.simulador.Simulador;

/**
 * Clase para probar el simulador gráfico de las burbujas
 */
public class PruebaSimuladorGrafico {

	/**
	 * Programa principal
	 * @param args argumentos del programa
	 */
	public static void main(String[] args) {
		
		Circulo circulo1 = new Circulo(new Punto(50, 50), 50);		
		Burbuja basica = new Burbuja(circulo1, 100);
		
		Circulo circulo2 = new Circulo(new Punto(200, 50), 50);		
		BurbujaLimitada limitada = new BurbujaLimitada(circulo2, 50, 400);
		
		Circulo circulo3 = new Circulo(new Punto(350, 50), 50);		
		BurbujaDebil debil = new BurbujaDebil(circulo3, 50, 3);
		
		Circulo circulo4 = new Circulo(new Punto(500, 50), 10);		
		BurbujaCreciente creciente = new BurbujaCreciente(circulo4, 20); 
		
		Circulo circulo5 = new Circulo(new Punto(650, 50), 50);		
		BurbujaSensible sensible = new BurbujaSensible(circulo5, 20);
		
		LinkedList<Burbuja> burbujas = new LinkedList<Burbuja>();
		Collections.addAll(burbujas, basica, limitada, debil, creciente, sensible);
		
		Simulador simulador = new Simulador(710, 710);
		
		for (Burbuja burbuja : burbujas) {
			
			simulador.simular(burbuja);
		}
		
	}
}
