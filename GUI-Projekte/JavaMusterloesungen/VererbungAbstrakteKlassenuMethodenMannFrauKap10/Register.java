package VererbungAbstrakteKlassenuMethodenMannFrauKap10;


import java.util.List;
import java.util.ArrayList;

public class Register {
	
	private List<Person> persons = new ArrayList<Person>();

	public void addPerson(Person person) {
		persons.add(person);
	}
	
	public void ausgeben() {
		for (Person person : persons) {
			person.printInfo();
		}
	}
	
	public static void main(String[] args) {
		Register reg = new Register();
		reg.addPerson(new Mann("donald duck"));
		reg.addPerson(new Mann("mickey mouse"));
		reg.addPerson(new Frau("daisy duck"));
		
		reg.ausgeben();
	}
}
