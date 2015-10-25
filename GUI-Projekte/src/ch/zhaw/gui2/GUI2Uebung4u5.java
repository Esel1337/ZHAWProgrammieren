
package ch.zhaw.gui2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2Uebung4u5 {

	private JFrame frame;

	private JTextField eingabeFeld;
	private Decisions entscheidungen;
	private JLabel labelCounter;

	public GUI2Uebung4u5() {

		entscheidungen = new Decisions();
		createGui();
	}

	private void createGui() {
		// frame erstellen und Menübar
		frame = new JFrame("Entscheidungsknopf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar();

		SaveListener saveListener = new SaveListener();

		// Toppanel mit EingabeFeld und Buttons
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel labelEintrag = new JLabel("Eintrag");
		topPanel.add(labelEintrag);
		eingabeFeld = new JTextField(20);
		eingabeFeld.addActionListener(saveListener);
		topPanel.add(eingabeFeld);
		JButton save = createSaveButton();
		save.addActionListener(saveListener);
		topPanel.add(save);
		labelCounter = new JLabel(entscheidungen.getSize());
		topPanel.add(labelCounter);
		frame.add(BorderLayout.NORTH, topPanel);

		// Decisionsbutton zum Frame hinzu
		JButton decisionButton = createButton();
		decisionButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		frame.getContentPane().add(BorderLayout.CENTER, decisionButton);

		frame.setSize(800, 300);
		frame.setVisible(true);
	}

	private JButton createSaveButton() {
		final JButton saveButton = new JButton("Save");
		return saveButton;
	}

	private JButton createButton() {
		final JButton button = new JButton("Klick mich");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText(entscheidungen.getRandomDecision());
			}
		});
		return button;
	}

	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!eingabeFeld.getText().isEmpty()) {
				entscheidungen.enterDecisions(eingabeFeld.getText());
				eingabeFeld.setText(null);
				labelCounter.setText(entscheidungen.getSize());
				
			} else {
				System.out.println("Du musst etwas eingeben.");
			}

		}

	}

	private void createMenuBar() {

		// Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// Menü (JMenu) erzeugen und in die Menüzeile (JMenuBar) einfügen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		// Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufügen
		JMenuItem oeffnenItem = new JMenuItem("Öffnen");
		oeffnenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Öffnen geklickt");

			}
		});

		// Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufügen
		JMenuItem beendenItem = new JMenuItem("Beenden");
		beendenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int wertInt = JOptionPane.showConfirmDialog(frame, "Wirklich beenden?", "Nachfrage",
						JOptionPane.WARNING_MESSAGE);

				if (wertInt == JOptionPane.OK_OPTION) {

					System.out.println("Beenden geklickt");
					System.exit(0);

				}
			}
		});

		dateiMenu.add(oeffnenItem);
		dateiMenu.add(beendenItem);

	}

	public static void main(String[] args) {
		new GUI2Uebung4u5();

	}

}
