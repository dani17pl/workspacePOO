package tragaperras;

import java.util.List; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		this.premios=new ArrayList(premios.length);
		Collections.addAll(this.premios,premios);
		
	}
	
	//Metodos consultivos GET y SET
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

	public List<Premio> getPremios() {
		List<Premio> premios=new 	ArrayList<Premio>(this.premios);
		return premios;
	}
	
	//Metodos funcionalidad
	
	public void incrementarCredito(double incremento)
	{
		this.credito=+incremento;
	}
	
	private List<Fruta> generarCombinacion() {
		List<Fruta> combinacion = new ArrayList<Fruta>(this.casillas);
		Random random = new Random(); 
		Fruta[] todasLasFrutas = Fruta.values();
		for (int i = 0; i < this.casillas; i++) 
		{ 
			Fruta fruta = todasLasFrutas[random.nextInt(todasLasFrutas.length)]; 
			combinacion.add(fruta);
		} 
		return combinacion;
	}
	public List<Fruta> jugar()
	{
		if(this.credito<this.precio)
		{
			return null;
		}
		this.credito-=this.precio;
		List<Fruta> combinacion =  this.generarCombinacion();
		for (Premio premio : premios) {
			if(combinacion.equals(premio.getCombinacion()))
					{
					this.credito=this.credito+premio.getCantidad();
					}
		}
		return combinacion;
	}
	
	
	
}