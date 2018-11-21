/**
 * 
 */
package Ejercicio3GestionLicensias;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * @author Dani_
 *
 */
public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Fecha de caducidad para la primera licencia dentro de un mes 
		LocalDate fechaaux = LocalDate.now();
		int year = fechaaux.getYear();
		int month = fechaaux.getMonthValue();
		int day = fechaaux.getDayOfMonth();	
		LocalDate fecha = LocalDate.of(year, month, day).plusMonths(1);

		LicenciaTemporal licencia1 = new LicenciaTemporal("juan@um.es","http://api.um.es/disco/v1/",fecha);
		LicenciaTransaccionesLimitada licencia2 = new LicenciaTransaccionesLimitada("pepe@um.es","http://api.um.es/disco/v1/",3);
		LicenciaDiario licencia3 = new LicenciaDiario("pepe@um.es","http://api.um.es/disco/v1/",4,1);
		
		LinkedList<Licencia> licencias = new LinkedList<Licencia>();
		licencias.add(licencia1);
		licencias.add(licencia2);
		licencias.add(licencia3);
	    for (Licencia licencia : licencias) {
			System.out.println(licencia);
			System.out.println("----------------------------------------------------------------------------");
			
		}
	    
	    for (Licencia licencia : licencias) {
			if (licencia instanceof LicenciaDiario) {
				((LicenciaDiario) licencia).getLimiteDiario();
			}
			if (licencia instanceof LicenciaTemporal) {
				 licencia.revocar(); 
			}
			
		}
	    
	    for (Licencia licencia : licencias) {
			for (int i = 0; i < 4; i++) {
				Transaccion transaccion = licencia.getAutorizacion();
	    	if (transaccion == null) {
				System.out.println("No autorizada");
			}else {
				System.out.println(transaccion);
			}
			}
	    	
			System.out.println("----------------------------------------------------------------------------");
			
		}
	    
	    for (Licencia licencia : licencias) {
			System.out.println(licencia);
			System.out.println("----------------------------------------------------------------------------");
			
		}
	    
	    LinkedList<Licencia> licenciasCopia = new LinkedList<Licencia>();
	    
	    for (Licencia licencia : licencias) {

	    	licenciasCopia.add(licencia.clone());
			
		}
	    
		System.out.println("COPIA DE LICENCIAS");
	    for (Licencia licencia : licenciasCopia) {
			System.out.println(licencia);
			System.out.println("----------------------------------------------------------------------------");
			
		}
	}

}
