package Boletin1;

import java.util.LinkedList;

public class A {

	public B ob = null;
	public int at;
	public LinkedList<Integer> lista = new LinkedList<Integer> ();
	
	public A()
	{
		at = 0;
		//Error no existe constructor vacio en B 
		ob= new B(3);  //solucion. poner atributo o crear constructor vacion en B
		
	}
	
	public A(A otro)
	{
		ob = otro.ob; //hacen referencia al mismo objeto si cambia uno cambia el otro 
	}
	
	public void met (A otro, int a)
	{
		otro.at=5;
		a=19;
		otro.lista.add(100);
	}
}
