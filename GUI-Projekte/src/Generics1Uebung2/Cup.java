package Generics1Uebung2;

public class Cup<T extends drinkable> {

	private T liquid;

	public Cup(T liquid) {
		this.liquid = liquid;
	}

	public T getContent() {
		return liquid;
	}

	@Override
	public String toString() {
//		return "Cup contains: ";
	return "Cup contains: " + liquid.getFlavour();
	}
}
