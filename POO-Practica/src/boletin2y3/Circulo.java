package boletin2y3;

public class Circulo {
	//atributos
	private Punto punto;
	private int radio;
	private int perimetro;
	
	//Constantes
	public static final Punto ORIGEN_COORDENADAS=new Punto(0,0);
	public static final int RADIO_POR_DEFECTO=5;
	
	//Constructor
	
	public Circulo(Punto punto, int radio)
	{
		this.punto=new Punto(punto.getX(),punto.getY());
		this.radio=radio;
	}
	
	public Circulo()
	{
		this.punto=new Punto(ORIGEN_COORDENADAS.getX(),ORIGEN_COORDENADAS.getY());
		this.radio=RADIO_POR_DEFECTO;	
	}
	
	public Circulo(Circulo circulo)
	{
		this.punto=new Punto(circulo.punto);
		this.radio=circulo.radio;
	}
	
	//Metodos get/Set
	public Punto getPunto()
	{
		Punto punto=new Punto(this.punto.getX(),this.punto.getY());
		return punto ;
	}
	public  int  getRadio()
	{
		return radio;
	}
	
	public int perimetro()
	{
		return perimetro;
	}
	
	//Metodos
	
	public void desplazar(int desplazamientoX,int desplazamientoY)
	{
		this.punto.setX(this.punto.getX() +desplazamientoX);
		this.punto.setY(this.punto.getY() +desplazamientoY);
	}
	
	public void escalar(double porcentaje)
	{
		double nuevoRadio= this.radio*(porcentaje/100);
		this.radio=(int)nuevoRadio;
	}
	
	public String toString (){
        String mensaje="Radio:"+this.radio+"; Centro:"+this.punto;
        return mensaje;
    }

}
