package Observerpattern;

public class Zuhoererin implements Observer {

  @Override
  public void update() {
    System.out.println(getClass().getSimpleName() + " Hihihi");

  }

}
