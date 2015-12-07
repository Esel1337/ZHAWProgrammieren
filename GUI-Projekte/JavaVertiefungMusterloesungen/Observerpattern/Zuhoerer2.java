package Observerpattern;

public class Zuhoerer2 implements Observer {

  @Override
  public void update() {
    System.out.println(getClass().getSimpleName() + " Huhuhuhu");

  }

}
