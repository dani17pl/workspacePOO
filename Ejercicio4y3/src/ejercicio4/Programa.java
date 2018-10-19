/**
 * 
 */
package ejercicio4;

/**
 * @author Dani_
 *
 */
public class Programa {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Examen examen = new Examen("Introduccion a la informatica");
		Pregunta pregunta1 = new Pregunta("Cuál es el valor decimal del número binario 0010?\\n a. 1, b. 2, "
				+ "c. 3", "b");
		Pregunta pregunta2 = new Pregunta("¿Cual es un protocolo de URL?\\n a. http, b. flip, c. coco", "a");
		Pregunta pregunta3 = new Pregunta("¿A cuántos bits equivale un byte equivale?\\n a.2, b.16, c.8", "c");
		
		examen.addPregunta(pregunta1);
		examen.addPregunta(pregunta2);
		examen.addPregunta(pregunta3);
		
		double nota;

		nota = examen.corregir("b", "a", "b");
		System.out.println("La nota del examen es: " + nota);
	}

}
