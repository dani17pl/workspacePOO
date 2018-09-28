package boletin2;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Punto(Punto punto)
	{
		this.x=punto.x;
		this.y=punto.y;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public void desplazar(int desplazarX, int desplazarY)
	{
		this.x=this.x+desplazarX;
		this.y=this.y+desplazarY;
	}
	
	
	public String toString (){
        String mensaje="La coordenada X: "+x+"; la coordenda Y:"+y;
        return mensaje;
    }
}
