package boletin2y3;

public class PruebaRectangulo {

	public static void main(String[] args) {
	
		Punto puntoII= new Punto(3,1);
		Rectangulo rectangulo1=new Rectangulo(puntoII,2,5);
		System.out.println(rectangulo1);
		
		rectangulo1.desplazr(0, -7);
		System.out.println(rectangulo1);
		
		rectangulo1.escalar(50);
		System.out.println(rectangulo1);
		
	}

}
