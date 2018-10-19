package tragaperras;

import java.util.ArrayList;
import java.util.Iterator;

public class Premio {
	//Atributos
	private final int cantidad; 
	private final ArrayList<Fruta >combinacion;
	
	//Constructor
	public Premio(int cantidad, Fruta ...frutas)
	{
		this.cantidad=cantidad;
		//this.combinacion = new ArrayList<Fruta>();
		this.combinacion = new ArrayList<Fruta>(frutas.length-1);
		for (Fruta fruta : frutas) {
			combinacion.add(fruta);
			
		}
		
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public ArrayList<Fruta> getCombinacion()
	{
	ArrayList<Fruta >combinacion= new ArrayList<Fruta>(this.combinacion);
	return combinacion;
	}
	
	
	public String toString (){
	       
        String mensaje = "";
        for (Fruta fruta : combinacion) {
			mensaje+=fruta.toString();
			
		}
        return mensaje;
    }
}
