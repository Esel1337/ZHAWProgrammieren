package ThreadsUhrTry;

import java.util.Date;
import java.util.TimerTask;

public class Task extends TimerTask {
  
  private String name;
  
  public Task(String name) {
    this.name = name;
  }

  @Override
  public Date run() {
	 
    System.out.println(name + ": Es ist " + new Date());
    Date newDate = new Date();
    return newDate;
//    Clock gloegli = new Clock();
  }

}
