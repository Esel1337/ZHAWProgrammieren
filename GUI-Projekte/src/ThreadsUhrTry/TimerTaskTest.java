package ThreadsUhrTry;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerTaskTest {
  
public TimerTaskTest(){

	
    Timer timer = new Timer();
    timer.schedule( new Task("Task 2"), 1000, 1000 );

}
}
