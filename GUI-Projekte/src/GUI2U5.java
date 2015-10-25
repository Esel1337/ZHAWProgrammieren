
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2U5 {

	private JFrame frame;
	private final List<String> decisions;
	private final Random random;
	private JTextField eingabeFeld;

	public GUI2U5() {
		decisions = new ArrayList<String>();
		random = new Random();
		createGui();

		initDecisions();
	}

	private void createGui() {

		frame = new JFrame("Entscheidungsknopf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SaveListener saveListener = new SaveListener();

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

		frame.add(BorderLayout.NORTH, topPanel);

		JButton button = createButton();
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		frame.getContentPane().add(BorderLayout.CENTER, button);
		createMenuBar();
		frame.setSize(500, 500);
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
				button.setText(getRandomDecision());
			}
		});
		return button;
	}

	private void initDecisions() {
		decisions.add("Kino");
		decisions.add("Konzert");
		decisions.add("Grossmutter");
		decisions.add("Party");
		decisions.add("Essen gehen");
	}

	private void enterDecisions(String text) {
		if (!decisions.contains(text)) {
			decisions.add(text);
		} else {
			System.out.println("Eintrag schon vorhanden");
		}

	}

	private String getRandomDecision() {
		int randomIndex = random.nextInt(decisions.size());
		return decisions.get(randomIndex);
	}

	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!eingabeFeld.getText().isEmpty()) {
				enterDecisions(eingabeFeld.getText());
				eingabeFeld.setText(null);
				System.out.println("Eintrag hinzugefügt");
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
				int wertInt = JOptionPane.showConfirmDialog(frame, "Wirklich beenden?", "Nachfrage",JOptionPane.WARNING_MESSAGE);
				
				if (wertInt == JOptionPane.OK_OPTION){	
										
					System.out.println("Beenden geklickt");
					System.exit(0);
				
				}
			}
		});
		
		dateiMenu.add(oeffnenItem);
		dateiMenu.add(beendenItem);
		
	}

	public static void main(String[] args) {
		new GUI2U5();

	}

}
