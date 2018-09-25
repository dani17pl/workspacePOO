package Boletin1;

public class A {

	public B ob = null;
	
	public A()
	{
		//Error no existe constructor vacio en B 
		ob= new B(3);  //solucion. poner atributo o crear constructor vacion en B
	}
	
	public A(A otro)
	{
		ob = otro.ob; //hacen referencia al mismo objeto si cambia uno cambia el otro 
	}
	
	public int met ()
	{
		return ob.x;
	}
}
