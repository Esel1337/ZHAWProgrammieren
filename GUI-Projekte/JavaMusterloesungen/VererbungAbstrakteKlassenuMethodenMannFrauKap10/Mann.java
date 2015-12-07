package VererbungAbstrakteKlassenuMethodenMannFrauKap10;



public class Mann extends Person {
	
	public Mann(String name) {
		super(name);
	}
	
	@Override
	public String getSex() {
		return "ein Mann";
	}
}
