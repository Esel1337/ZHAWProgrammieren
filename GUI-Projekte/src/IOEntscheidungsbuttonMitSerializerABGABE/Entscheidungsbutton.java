package IOEntscheidungsbuttonMitSerializerABGABE;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Entscheidungsbutton implements Serializable {


	private static final long	serialVersionUID	= 1L;
	private JFrame		frame;
	private Decisions	decisions;
	private JTextField	eingabeFeld;
	private JLabel		labelCounter;
	private Serializer	serializer;

	public Entscheidungsbutton() {
		decisions = new Decisions();
		createGui();
		serializer = new Serializer();
	}

	//GUI erstellen
	private void createGui() {
		// frame erstellen und MenÃ¼bar
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
		labelCounter = new JLabel(decisions.getSize());
		topPanel.add(labelCounter);
		frame.add(BorderLayout.NORTH, topPanel);

		// Decisionsbutton zum Frame hinzu
		JButton decisionButton = createButton();
		decisionButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		frame.getContentPane().add(BorderLayout.CENTER, decisionButton);

		frame.setSize(800, 300);
		frame.setVisible(true);
	}

	//JButton zum Speichern erstellen
	private JButton createSaveButton() {
		final JButton saveButton = new JButton("Save");
		return saveButton;
	}

	//JButton zum Anklicken erstellen
	private JButton createButton() {
		final JButton button = new JButton("Klick mich");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText(decisions.getRandomDecision());
			}
		});
		return button;
	}

	//Counter updaten
	private void counterUpdate() {
		labelCounter.setText(decisions.getSize());
	}

	//Savelistener ist der Actionlistener um Einträge zu speichern
	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!eingabeFeld.getText().isEmpty()) {
				decisions.enterDecisions(eingabeFeld.getText());
				eingabeFeld.setText(null);
				counterUpdate();
			}
			else {
				System.out.println("Du musst etwas eingeben.");
			}

		}

	}

	//Menubar erstellen
	private void createMenuBar() {

		// MenÃ¼zeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfÃ¼gen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// MenÃ¼ (JMenu) erzeugen und in die MenÃ¼zeile (JMenuBar) einfÃ¼gen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		JMenuItem loeschenItem = new JMenuItem("Alle Entscheidungen löschen");
		loeschenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decisions.listeLoeschen();
				counterUpdate();
			}
		});

		// MenÃ¼eintrÃ¤ge (JMenuItem) erzeugen und dem MenÃ¼ (JMenu) "Datei"
		// hinzufÃ¼gen
		JMenuItem ladenItem = new JMenuItem("Entscheidungen laden");
		ladenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showOpenDialog(frame);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					serializer.setFilename(chooser.getSelectedFile().getAbsolutePath());
					decisions.listeErsetzen(serializer.laden());
					counterUpdate();
				}

				else {
					JOptionPane.showMessageDialog(frame, "Es wurde keine Datei geladen.");

				}
			}

		});

		// Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufÃ¼gen
		JMenuItem speichernItem = new JMenuItem("Entscheidungen speichern");
		speichernItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showSaveDialog(frame);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					serializer.setFilename(chooser.getSelectedFile().getAbsolutePath());
					serializer.abspeichern(decisions);
					counterUpdate();
					System.out.println("Erfolgreich gespeicheret");
				}

				else {
					JOptionPane.showMessageDialog(frame, "Du musst einen Speicherort auswÃ¤hlen.");

				}

			}
		});

		// Menu zum Beenden des Programs
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

		dateiMenu.add(ladenItem);
		dateiMenu.add(loeschenItem);
		dateiMenu.add(speichernItem);
		dateiMenu.add(beendenItem);

	}

	public static void main(String[] args) {
		new Entscheidungsbutton();

	}

}
