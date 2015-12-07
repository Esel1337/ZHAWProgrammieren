package Observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Erzaehler implements Observable {
  
  private final List<Observer> observers;
  
  public Erzaehler() {
    this.observers = new ArrayList<>();
  }

  public void erzaehleWitz() {
    System.out.println("Ich erzähle ein Witz");
    notifyObservers();
  }
  
  @Override
  public void addObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update();
    }

  }

}
