package GUI2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {

	JFrame frame = new JFrame("Viewer");
	

	public GUI()
	{

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		
		frame.getContentPane().add(BorderLayout.CENTER, new KreisZeichnen());
		JButton button = new JButton("Farbe waechlse");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			frame.repaint();
			}
		});
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
	    frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		new GUI();
	}
	
}
