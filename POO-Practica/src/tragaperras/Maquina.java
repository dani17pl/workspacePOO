package tragaperras;

import java.util.ArrayList;

public class Maquina {

	//Atributos
	private final int casillas;
	private double precio;
	private double credito;
	private final ArrayList<Premio> premios;
	
	//Constructor
	public Maquina(int casillas, double precio, Premio ...premios)
	{
		this.casillas=casillas;
		this.credito=0.0;
		this.precio=precio;
		this.premios=new ArrayList();
		for (Premio premio : premios) {
			this.premios.add(premio);
			
		}
		
	}
	
	//Metodos GET y SET
	public int getCasillas()
	{
		return casillas;
	}

	public double getPrecio() {
		return precio;
	}

	public double getCredito() {
		return credito;
	}

	public ArrayList<Premio> getPremios() {
		return premios;
	}
	
	
	
	
}
