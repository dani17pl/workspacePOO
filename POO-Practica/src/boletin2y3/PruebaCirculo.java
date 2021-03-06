package boletin2y3;

public class PruebaCirculo {

	public static void main(String[] args) {
		
		Punto punto1=new Punto(2,3);
		
		Circulo circulo1= new Circulo(punto1,3);
		Circulo circulo2= new Circulo(punto1,5);
		
		System.out.println("circulo1 centro:"+circulo1.getPunto());
		circulo1.desplazar(3, 2);
		System.out.println("circulo1 centro:"+circulo1.getPunto());
		
		System.out.println("circulo2 centro:"+circulo2.getPunto());
		
		Punto punto2=circulo2.getPunto();
		
		punto2.setX(4);
		
		System.out.println("Punto2:"+punto2);
		System.out.println("circulo2 centro:"+circulo2.getPunto());
		
		circulo2.escalar(150);
		
		System.out.println(circulo2);
	}
}
