package subastas;


public class Puja {

	private Usuario pujador;
	private double cantidad;	
	private Subasta subasta;

	
	//Constructor
	public Puja(Usuario pujador, double cantidad, Subasta subasta)
	{
		this.pujador=pujador;
		this.cantidad=cantidad;
		this.subasta=subasta;
	}
	
	//metodos consultas
	public Usuario getPujador() {
		return pujador;
	}
	public double getCantidad() {
		return cantidad;
	}
	public Subasta getSubasta()
	{
		return subasta;
	}

	public String toString (){
	       
        return "Puja: \n"
        		+ "Usuario :" +this.pujador.getNombre()+ "\n"
        		+ "cantidad:" +this.cantidad + "\n"
        		+ "Producto a pujar:" +this.subasta.getProucto() + "\n"
        		;
    }
}
