package subastas;

public class Usuario {
	
	/*Atributos*/
	private String nombre;
	private double credito;
	
	/*Constructor*/
	public Usuario(String nombre, double credito)
	{
		this.nombre=nombre;
		this.credito=credito;
	}
	public Usuario(String nombre)
	{
		this.nombre=nombre;
		this.credito=50;	
	}
	
	/*Metodos consulta*/
	
	public String getNombre()
	{
		return nombre;
	}
	
	public double getCredito()
	{
		return credito;
	}
	
	/*Metodos */
	
	public void incrementar(double suma)
	{
		this.credito=this.credito+suma;
	}
	
	public void decremento(double resta)
	{
		this.credito=this.credito-resta;
	}
	
	public String toString (){
	       
        return "Usuario: \n"
        		+ "nombre :" +this.nombre + "\n"
        		+ "Credito:" +this.credito + "\n"
        		;
    }
}
