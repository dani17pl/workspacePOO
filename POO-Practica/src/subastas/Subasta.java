package subastas;

import java.util.LinkedList;

public class Subasta {

	private String producto;
	private Usuario propietario;
	private boolean abierta;
	private LinkedList<Puja> pujas=new LinkedList();
	private Puja puja_mayor;
	
	//Constructor
	public Subasta(String producto, Usuario propietario)
	{
		this.producto=producto;
		this.propietario=propietario;
		this.abierta=true;
		puja_mayor=null;
		
	}
	
	/*Metodos consultivos*/
	public String getProucto() {
		return producto;
	}
	public Usuario getPropietario() {
		return propietario;
	}
	public boolean isAbierta() {
		return abierta;
	}
	public LinkedList<Puja> getPujas() {
		LinkedList<Puja> pujas = new LinkedList<Puja>(this.pujas);
		return pujas;
	}
	public Puja getPuja_mayor() {
		return puja_mayor;
	}
	
	/*Metodos*/
	public boolean pujar(Usuario pujador, double cantidad)
	{
		if (!this.abierta || pujador.getCredito()<cantidad 
			||	pujador== this.propietario )
		{
			return false;
		}
		
		if (this.puja_mayor!=null && this.puja_mayor.getCantidad()>=cantidad)
		{
			return false;
		}
		
		Puja puja=new Puja(pujador,cantidad,this);
		pujas.add(puja);
	    puja_mayor=new Puja(pujador,cantidad,this);
		
		return true;
	}
	
	public boolean pujar(Usuario pujador)
	{

		if (!this.abierta ||	pujador== this.propietario )
		{
			return false;
		}
		
		if (this.puja_mayor!=null && this.puja_mayor.getCantidad()>=this.propietario.getCredito())
		{
			return false;
		}
		
		Puja puja;
		if (this.puja_mayor==null)
		{
			puja=new Puja(pujador,1,this);
			puja_mayor=new Puja(pujador,1,this);
		}
		else
		{
			puja=new Puja(pujador,this.puja_mayor.getCantidad() +1,this);
			puja_mayor=new Puja(pujador,this.puja_mayor.getCantidad() +1,this);
		}
		pujas.add(puja);
		return true;
	}
	
	public boolean ejecutar()
	{
		if (!this.abierta || pujas.isEmpty())
		{
			return false;
		}
		
		this.puja_mayor.getPujador().decremento(this.puja_mayor.getCantidad());
		this.propietario.incrementar(this.puja_mayor.getCantidad());
		this.abierta=false;
		return true;
	}
	
	public String toString (){
	       
        return "Subasta: \n"
        		+ "Creador :" +this.propietario + "\n"
        		+ "Producto:" +this.producto + "\n"
        		+ "Abierta:" +this.abierta + "\n"
        		;
    }
}
