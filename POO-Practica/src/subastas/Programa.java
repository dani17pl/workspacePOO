package subastas;

public class Programa {

	public static void main(String[] args) {
		Usuario usuario1=new Usuario("Juan",100);
		Usuario usuario2=new Usuario("Pedro",150);
		Usuario usuario3=new Usuario("Enrique",300);

		Subasta subasta1=new Subasta("Telefono movil",usuario1);
		
		subasta1.pujar(usuario2, 100);
		
		System.out.println(subasta1.getPuja_mayor());
		System.out.println(subasta1.pujar(usuario3, 50));
		System.out.println(subasta1.getPuja_mayor());
		
		subasta1.ejecutar();
		System.out.println(subasta1.pujar(usuario3, 250));
		
		System.out.println(usuario1);
		System.out.println(usuario2);
		System.out.println(usuario3);
	}

}
