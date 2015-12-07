package VererbungAbstrakteKlassenuMethodenMannFrauKap10;



public abstract class Person {

	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public void printInfo() {
		System.out.println("Diese Person ist " + getSex()); 
		System.out.println("und heisst " + name); 
	}
	
	public abstract String getSex();
}
