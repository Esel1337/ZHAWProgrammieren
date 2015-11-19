package SpeicherstrategieBasteln;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
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

public class DecisionButton {

	private JFrame frame;
	private DecisionData decisionData;
	private boolean text;
	private boolean XML;
	private JRadioButton typDateien;
	private JRadioButton typText;
	private JRadioButton typXML;
	private boolean datei;
	private List<String> strategieliste;

	public DecisionButton() {
		decisionData = new DecisionData();
		createGui();
		groupButton();
	}

	private void createGui() {

		speicherstrategie = new Speicherstrategien();
		frame = new JFrame("Entscheidungsknopf");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar();

		Container contentPane = frame.getContentPane();

		JButton button = createButton();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, createInputPanel());
		contentPane.add(BorderLayout.CENTER, button);

		frame.setSize(500, 300);
		frame.setVisible(true);
	}

	private JButton createButton() {
		final JButton button = new JButton("Klick mich");
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText(getRandomDecision());
			}
		});
		return button;
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputPanel.add(new JLabel("Tat:"));
		final JTextField textField = new JTextField(20);
		textField.setToolTipText("Hier eine Tätigkeit eingeben");
		inputPanel.add(textField);
		JButton saveButton = new JButton("save");
		saveButton.setMnemonic(KeyEvent.VK_ENTER); // alt+enter um den button zu
													// waehlen
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveDecision(textField.getText());
				textField.requestFocus();
				textField.setText("");
			}
		});
		inputPanel.add(saveButton);
		return inputPanel;
	}

	private void saveDecision(String input) {
		AddOperationResult addOperationResult = decisionData.addDecision(input);
		if (addOperationResult.hasError()) {
			JOptionPane.showMessageDialog(frame, addOperationResult.getMessage());
		}
	}

	private String getRandomDecision() {
		return decisionData.getRandomDecision();
	}

	private void saveDecisions() {
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showSaveDialog(frame);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {

				if (text) {
					decisionData.saveTextFile(fileChooser.getSelectedFile());
				} else if (XML) {
					decisionData.saveXMLFile(fileChooser.getSelectedFile());
				} else if (datei) {
					decisionData.saveDecisions(fileChooser.getSelectedFile());
				}

				else {
					nichtsAusgewählt();
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Fehler beim speichern: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void nichtsAusgewählt(){
		
		JOptionPane.showMessageDialog(frame, "Du hast keine Speicherstrategie ausgewählt", null, JOptionPane.ERROR_MESSAGE);
	}
	
	private void loadDecisions() {
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showOpenDialog(frame);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {

				if (text) {
					decisionData.loadTextFile(fileChooser.getSelectedFile());
				} else if (XML) {
					decisionData.loadXMLFile(fileChooser.getSelectedFile());
				}

				else if (datei) {
					decisionData.loadDecisions(fileChooser.getSelectedFile());
				}

				else {
					nichtsAusgewählt();
				}
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "Fehler beim Laden: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void groupButton() {
	
		
	
		ButtonGroup bg1 = new ButtonGroup();

		bg1.add(typDateien);
		bg1.add(typText);
		bg1.add(typXML);

	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu dateiMenu = new JMenu("Datei");
		JMenu textdateiMenu = new JMenu("Speicher-Strategie");
		JMenuItem speicherStrategie = new JMenuItem("Neue Speicher-Strategie");
		JMenuItem loadItem = new JMenuItem("Entscheidungen laden");
		loadItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadDecisions();
			}
		});

		JMenuItem saveItem = new JMenuItem("Entscheidungen speichern");
		saveItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveDecisions();
			}
		});

		speicherStrategie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> strategieliste = new ArrayList<>();
											
				strategieliste.add(JOptionPane.showInputDialog("Enter Strategiename"));	
				
		

			
		});
		
	
		
		strategieliste.add("")
		typDateien = new JRadioButton("Dateien bearbeiten");
		typDateien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				text = false;
				XML = false;
				datei = true;
			}

		});

		typText = new JRadioButton("Textdateien bearbeiten");
		typText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				text = true;
				XML = false;
				datei = false;
			}
		});

		typXML = new JRadioButton("XML Dateien bearbeiten");
		typXML.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				text = false;
				XML = true;
				datei = false;
			}

		});

		dateiMenu.add(loadItem);
		dateiMenu.add(saveItem);

		textdateiMenu.add(typDateien);
		textdateiMenu.add(typText);
		textdateiMenu.add(typXML);
		menuBar.add(dateiMenu);
		menuBar.add(textdateiMenu);
		menuBar.add(speicherStrategie);
	}

}
