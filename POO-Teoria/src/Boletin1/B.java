package Boletin1; //las dos clases  estan en el mismo paquete 

public class B {

	int x=0;
	
	public B(int x)
	{
		this.x=x;
	}
	
	public void setX(int x)
	{
		this.x=x;
	}
	protected B yoMismo() {
		return this;
	}
}
