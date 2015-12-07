package Generics1Uebung2;

public class Tea implements drinkable {

	private String flavour;

	public Tea(String flavour) {
		this.flavour = flavour;
	}

	public String getFlavour() {
 return flavour + " Tea";
 }
}