package boletin2y3;

public class PruebaBoletin3 {
 public static void main(String[] args) {
	
	 /*
	 Creamos punto1 
	 */
	 Punto punto1=new Punto(1,1);
	 System.out.println(punto1);
	 /*
	 desplzamos arriba punto1 
	 */
	 punto1.desplazar(Direccion.ARRIBA);
	 System.out.println(punto1);
	 
	 
	 /*
	 Creamos punto2 
	 */
	 Punto punto2=new Punto(4,2);
	 System.out.println(punto2);
	 /*
	 Creamos array y Almacenamos las referencia de punto1 y punto2 e imprimimos resultao array
	 */
	 Punto [] puntos=new Punto[2];
	 puntos[0]=punto1;
	 puntos[1]=punto2;
	 
	 for (Punto punto : puntos) {
		 System.out.println(punto);
	}
	 /*
	 Imprimimos distanci entre punto1 y punto2 
	 */
	 System.out.println(punto1.distancia(punto2));
	 
	 
	 Punto puntoOrigen=new Punto(0,0);
	 
	 System.out.println(puntoOrigen.mayorDistancia(puntos));
	 
	 
	 /*
	 Comprobacion del constructor del circulo
	 */
	 System.out.println("Circulos------>");
	 Circulo circulo=new Circulo();
	 System.out.println(circulo);
	 circulo.desplazar(4, 5);
	 Circulo circulo2=new Circulo();
	 System.out.println(circulo);
	 System.out.println(circulo2);
	 
	 
}
}
