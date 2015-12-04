package ThreadsUhrTry;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StartGui {

	private JFrame frame;
	private boolean guiUhr;
	private boolean consoleUhr;
	private JRadioButton guiButton;
	private JRadioButton consoleButton;

	public StartGui() {
		createGui();		
	}



	private void createGui() {

		frame = new JFrame("Entscheidungsknopf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar();

		Container contentPane = frame.getContentPane();

		JButton button = createButton();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.CENTER, button);

		frame.setSize(500, 300);
		frame.setVisible(true);
	}
	
	
	
	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu dateiMenu = new JMenu("Datei");

		
		guiButton = new JRadioButton("GUI Uhr");
		guiButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guiUhr = true;
			}

		});
		guiButton.setSelected(true);

		consoleButton = new JRadioButton("Console Uhr");
		consoleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				consoleUhr = true;
			}
		});



		dateiMenu.add(guiButton);
		dateiMenu.add(consoleButton);
		menuBar.add(dateiMenu);
	}

	private JButton createButton() {
		final JButton button = new JButton("Uhr starten");
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimerTaskTest uhr = new TimerTaskTest();
			}
		});
		return button;
	}
	
}
