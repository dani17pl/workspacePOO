package Boletin1;
//Ejercicio 1


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*Ejercicio 1*/
		System.out.println("EJERCICIO 1:");
		//this no puede ser usado en static contex
		A oa=new A();
		A oa2=new A(oa);
		oa.met();
		System.out.println(oa.met());
		System.out.println(oa.met());
		oa.ob.setX(12);
		System.out.println(oa.ob.x);
		System.out.println(oa.ob.x);
		System.out.println();
		
		/*Ejercicio 3*/
		
		C oc1 =new C();
		C oc2 =new C();
		int v=5;
		System.out.println("EJERCICIO 3:");
		oc1.met(oc2, v);
		System.out.println(oc1.at);
		System.out.println(oc2.at);
		System.out.println(v);
		System.out.println();
	}
}
