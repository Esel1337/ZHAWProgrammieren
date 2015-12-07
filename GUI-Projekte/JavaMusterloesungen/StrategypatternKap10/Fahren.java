package StrategypatternKap10;



public class Fahren implements IFortbewegungsart {

  @Override
  public void fortbewegen() {
    System.out.println("Ich fahre");
  }
}
