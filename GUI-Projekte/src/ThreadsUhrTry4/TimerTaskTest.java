
import java.util.Date;
import java.util.Timer;

public class TimerTaskTest {
  
  public static void main( String[] args )
  {
    Timer timer = new Timer();

    // Start in 2 Sekunden
    System.out.println("Start: " + new Date());
    timer.schedule( new Task("Task 1"), 2000 );

    // Start in einer Sekunde dann Ablauf alle 5 Sekunden
    timer.schedule( new Task("Task 2"), 1000, 5000 );
    

}
