package boletinJava8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

interface Tester {
	boolean test(int [] array, int index);
}
public class Boletin8 {

	public static <T> void metodo(List<T> lista, Function<T,T> funcion) {
		for (int  i = 0; i< lista.size(); i++) {
			T actual = lista.get(i);
			T nuevo = funcion.apply(actual);
			lista.set(i,nuevo);
			
		}
		
	}
	/*
	 * 
Febrero 2015. Utilizando el modelo de procesamiento basado en streams, 
y supuesta una variable List<Double> datos; muestra por la consola el número de elementos de 
la colección que estén comprendidos entre 0 y 10, ambos inclusive.

	 */
	public static void main (String[] args) {
		List<Integer>datos = new LinkedList<Integer>();
		Collections.addAll(datos, 2,5,6,12,15,6);
		
		long contados = datos.stream().filter(u ->  u>=0 && u<=10).count();
		System.out.println(contados);
		
		
		/*
		 * 
		 * Julio 2015.  En relación a las nuevas characteristics de Java 8:
			a) 	Explica el concepto de expresión lambda e ilústralo definiendo una variable de 
			tipo predicado que evalúe si un entero es par.
			b) 	Utilizando el modelo de procesamiento basado en streams, y el predicado anterior,
			obtén una lista que contenga sólo los números pares, ordenados de menor a mayor, de una lista de enteros.

		 */
		
		Predicate<Integer> espar = n-> n % 2 ==0;
		
		LinkedList<Integer> enteros = new LinkedList<Integer>();
		LinkedList<Integer> pares = new LinkedList<Integer>();
		
		Collections.addAll(enteros, 1,54,37,4,8,7,14);
		
		enteros.stream().filter(espar).sorted().forEach(n ->pares.add(n));
		
		System.out.println("Numeros pares:" +pares);
		
		/*
		 * 
		 * Febrero 2016:
		a)Implementa el tipo de datos Tester para que la instrucción compile correctamente.
      	Tester tester = (s, i) -> s[i] == 0;
		b) Utilizando el modelo de procesamiento basado en streams, y supuesta la variable LinkedList<Integer> numeros, 
		ordena los números de mayor a menor, y crea una lista que contenga los cuadrados de los números que sean impares.

		 */
		Tester tester = (s, i) -> s[i] == 0;
		System.out.println(tester);
		
		LinkedList<Integer> numeros = new LinkedList<Integer>();
		LinkedList<Integer> cuadrados = new LinkedList<Integer>();
		Collections.addAll(numeros, 15,2,4,8,7,14);
		
		numeros.stream().filter(n -> n %2 !=0).sorted((n1,n2)->n1.compareTo(n2)).map(n-> n*n).forEach(n ->pares.add(n));
		System.out.println("Numeros" +pares);
		/*
		 * 
	Julio 2016: Implementa un método genérico que tenga como parámetro una lista y una función. 
	El propósito del método es cambiar todos los valores de la lista de acuerdo a la función.
	Ejemplos de uso del método serían:
  		metodo(listaCadenas, s -> "pre-" + s); // Añade prefijo ‘pre-‘
		metodo(listaEnteros, s -> s + 1); // incrementa en una unidad
      

		 */
		LinkedList<String> lista = new LinkedList<String>();
		Collections.addAll(lista, "Hola", "Adios");
		metodo(lista, s -> s.toUpperCase());
		System.out.println(lista);
		metodo(lista, s -> "pre"+ s);
		System.out.println(lista);
		
	}
}
