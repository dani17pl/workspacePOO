package Boletin1;

public class C extends A {

	public int at;
	
	
	
	public void met(C p1, int p2)
	{
		p1= new C(); //Se crea un nuevo objeto con un indentificador diferente no se modificara p1 pasado
		p1.at=5;
		at= ++p2;  //no aumenta el valor de la variable pasada (paso por valor)
	}
	protected A yoMismo() {
		return this;
	}
}
