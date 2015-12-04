package ThreadsUhrTry4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;



public class Clock {

	final Date date = new Date();
	final JLabel timeLabel = new JLabel(date.toString());
	

	public Clock() {
		
		guiDraw();}
		


private void guiDraw() {
	JFrame frame = new JFrame("Entscheidungsknopf");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	Container contentPane = frame.getContentPane();

	contentPane.setLayout(new BorderLayout());
	contentPane.add(BorderLayout.CENTER, timeLabel);

	frame.setSize(500, 300);
	frame.setVisible(true);

		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() throws Exception {
				
				
			    Timer timer = new Timer();

			   
			    timer.schedule(new Task(), 1000, 1000 );
			    timer.schedule(updateTimer(), 1000, 1000 );
				return null;
			}
		};

		worker.execute();

	}

public void updateTimer(){
	timeLabel.setText(date.toString());
}

}