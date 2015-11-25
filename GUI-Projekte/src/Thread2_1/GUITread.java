package Thread2_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GUITread {

	private JFrame frame = new JFrame("Test");
	private JPanel panel = new JPanel();
	private JProgressBar bar = new JProgressBar(0, 100);
	private List<Thread> threadliste = new ArrayList();

	public GUITread() {
		createAndShowGUI();

	}

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					neuerThread();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}

	private void neuerThread() throws InterruptedException {
		Runnable threadJob = new Updater();
		Thread meinThread = new Thread(threadJob);
		System.out.println("meinfred" + meinThread.getName());
		threadliste.add(meinThread);
		if(meinThread.isAlive()){System.out.println("alive");} 
		else {System.out.println("dead");}
				
		meinThread.start();
			while(!meinThread.isAlive());
			{
				wait();
			} 
			threadliste.remove(0);
			}
		;
	}
	
	class Updater implements Runnable {

		private JProgressBar bar;

		@Override
		public void run() {

			doSomething();
		}



	private void doSomething() {

		for (int i = 0; i <= 100; i++) {
			bar.setValue(i);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
