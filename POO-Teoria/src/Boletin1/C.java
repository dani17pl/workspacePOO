package Boletin1;

public class C {

	public int at;
	
	public C()
	{
		at=0;
	}
	
	public void met(C p1, int p2)
	{
		//p1= new C();
		p1.at=5;
		at= ++p2;
	}
}
