package Threads2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class GUITread {

	private JFrame frame = new JFrame("Test");
	private JPanel panel = new JPanel();
	private JProgressBar bar = new JProgressBar(0, 100);
	private int count;

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

				System.out.println("ganz am anfang" + count);
				if (count == 0) {

					neuerThread();

				}
				count++;
				System.out.println("von oben" + count);

			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}

	private void neuerThread() {
		Runnable threadJob = new Updater();
		Thread meinThread = new Thread(threadJob);
		System.out.println("meinfred: " + meinThread.getName());
		meinThread.start();

	}

	private class Updater implements Runnable {

		@Override
		public void run() {

			doSomething();

		}

	}

	private void doSomething() {

		for (int i = 0; i <= 100; i++) {
			bar.setValue(i);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 100) {
				count--;
				System.out.println(count);
				if (count > 0)

					neuerThread();

			}
		}

	}
}
