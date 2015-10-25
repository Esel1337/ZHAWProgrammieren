package GUI2U4;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI2U4 {

	private JFrame frame;

	public GUI2U4() {
		createFrame();
	}

	private void createFrame() {
		frame = new JFrame("Mein erstes GUI");
		createMenuBar();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();

		final JButton button = new JButton("DrÃ¼ck mich");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText("Danke");

			}

		});
		contentPane.add(button);

		frame.pack();
		frame.setVisible(true);
	}

	private void createMenuBar() {

		// MenÃ¼zeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfÃ¼gen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// MenÃ¼ (JMenu) erzeugen und in die MenÃ¼zeile (JMenuBar) einfÃ¼gen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		// MenÃ¼eintrÃ¤ge (JMenuItem) erzeugen und dem MenÃ¼ (JMenu) "Datei"
		// hinzufÃ¼gen
		JMenuItem oeffnenItem = new JMenuItem("Ã–ffnen");
		oeffnenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ã–ffnen geklickt");

			}
		});
		dateiMenu.add(oeffnenItem);

		JMenuItem beendenItem = new JMenuItem("Beenden");
		beendenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Beenden geklickt");
				int option = JOptionPane.showConfirmDialog(frame, "Wirklich?", "Beenden", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}

		});
		dateiMenu.add(beendenItem);

	}

	public static void main(String[] args) {
		new GUI2U4();
	}
}
