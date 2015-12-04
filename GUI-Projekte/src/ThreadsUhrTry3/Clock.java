package ThreadsUhrTry3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Clock implements Runnable{

	
	private String name;

	public Clock(String name) {
		    this.name = name;
		  }
	
	@Override
	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final Date date = new Date();
				final JLabel timeLabel = new JLabel(date.toString());
				javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        date.setTime(System.currentTimeMillis());
                        timeLabel.setText(date.toString());
                    }
                });
				timer.start();
				JOptionPane.showMessageDialog(null, timeLabel);
				
			
			}
		});
		
	}
}