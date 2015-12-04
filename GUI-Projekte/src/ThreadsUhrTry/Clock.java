package ThreadsUhrTry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock {
	
    private final JLabel time = new JLabel();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private Calendar calendar;

    public Clock(){
	JFrame frame = new JFrame();
	Clock clock = new Clock();
	frame.add(clock.time);
	frame.pack();
	frame.setVisible(true);
	clock.start();

	}

	public void start() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				time.setText(String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond));
				currentSecond++;
			}
		}, 0, 1000);
	}
}


