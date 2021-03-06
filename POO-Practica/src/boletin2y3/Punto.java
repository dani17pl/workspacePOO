package boletin2y3;
import java.lang.Math;

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
	
	public void desplazar(Direccion direccion)
	{
		if (direccion==Direccion.ABAJO)
		{
			this.y=this.y-1;
		}
		else if (direccion==Direccion.ARRIBA)
		{
			this.y=this.y+1;
		}
		else if (direccion==Direccion.IZQUIERDA)
		{
			this.x=this.x-1;
		}	
		else  
		{
			this.x=this.x+1;
		}
	}
	
	public String toString (){
        String mensaje="La coordenada X: "+x+"; la coordenda Y:"+y;
        return mensaje;
    }
	
	public double distancia(Punto punto)
	{
		double distancia=Math.sqrt(Math.pow(this.x -punto.getX(), 2)+ Math.pow(this.y- punto.getY(),2));
		return distancia;
	}
	
	public Punto mayorDistancia(Punto...puntos )
	{
		Punto puntoaux=null;
		double distancia=0;
		for (Punto punto : puntos) {
			if(this.distancia(punto)>distancia) 
			{
				distancia=this.distancia(punto);
				puntoaux=new Punto(punto.getX(),punto.getY());
				
			}
			
		}
		return puntoaux;
	}
	

	
}
