package Observerpattern;

public class Zuhoerer1 implements Observer {

  @Override
  public void update() {
    System.out.println(getClass().getSimpleName() + " Hahahaha");
    
  }

}
