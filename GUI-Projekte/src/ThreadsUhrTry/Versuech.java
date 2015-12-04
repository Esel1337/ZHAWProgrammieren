package ThreadsUhrTry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JLabel;

public class Versuech {

	JLabel timeLabel = new JLabel("ew");

	Timer timer = new Timer();
//	timer.schedule(new Task("Task 2"),1000,1000);

	timer.start();
	int timeDelay = 1000;
	ActionListener time;
	time=new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent evt) {
		timeLabel.setText(DateTimeUtil.getTime());
		/*
		 * timeLabel is a JLabel to display time, getTime() is samll static
		 * methos to return formatted String of current time
		 */
	}
};

}
