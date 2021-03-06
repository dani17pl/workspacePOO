package boletin2y3;

public class Rectangulo {
	//Atributos
	private int ladoX;
	private int ladoY;
	
	private Punto verticeII;
	private Punto verticeID;
	private Punto verticeSI;
	private Punto verticeSD;
	
	//Constructor
	
	public Rectangulo(Punto verticeII, int ladoX, int ladoY)
	{
		this.verticeII=new Punto(verticeII.getX(),verticeII.getY());
		this.verticeID=new Punto(verticeII.getX()+ladoX,verticeII.getY());
		this.verticeSI=new Punto(verticeII.getX(),verticeII.getY()+ladoY);
		this.verticeSD=new Punto(verticeII.getX()+ladoX,verticeII.getY()+ladoY);
		this.ladoX=ladoX;
		this.ladoY=ladoY;
		
	}
	
	public Rectangulo(Punto verticeII, Punto verticeSD)
	{
		this.ladoX=verticeSD.getX()-verticeII.getX();
		this.ladoY=verticeSD.getY()-verticeII.getY();

		this.verticeII=new Punto(verticeII.getX(),verticeII.getY());
		this.verticeID=new Punto(verticeII.getX()+ladoX,verticeII.getY());
		this.verticeSI=new Punto(verticeII.getX(),verticeII.getY()+ladoY);
		this.verticeSD=new Punto(verticeII.getX()+ladoX,verticeII.getY()+ladoY);
		
	}
	
	
	//Metodos
	public void desplazr(int ejeX, int ejeY)
	{
		this.verticeII.desplazar(ejeX, ejeY);
		this.verticeID.desplazar(ejeX, ejeY);
		this.verticeSI.desplazar(ejeX, ejeY);
		this.verticeSD.desplazar(ejeX, ejeY);
		
	}
	
	public void escalar(double porcentje)
	{
		int ladoAnteriorX=this.ladoX;
		int ladoAnteriorY=this.ladoY;
		
		double nuevoLadoX=this.ladoX*(porcentje/100);
		double nuevoLadoY=this.ladoY*(porcentje/100);
		
		this.ladoX=(int)nuevoLadoX;
		this.ladoY=(int)nuevoLadoY;
		
		int ladoX=(this.ladoX-ladoAnteriorX);
		int ladoY=(this.ladoY-ladoAnteriorY);
		
		this.verticeID.desplazar(ladoX, 0);
		this.verticeSI.desplazar(0, ladoY);
		this.verticeSD.desplazar(ladoX, ladoY);
		
		
	}
	
	public String toString (){
       
        return "Vertice II:" +this.verticeII + "\n"
        		+ "Vertice ID:" +this.verticeID + "\n"
        		+ "Vertice SI:" +this.verticeSI + "\n"
        		+ "Vertice SD:" +this.verticeSD + "\n"
        		+ "Lado X:" +this.ladoX + "\n"
        		+ "Lado Y:" +this.ladoY + "\n";
    }
	

}
