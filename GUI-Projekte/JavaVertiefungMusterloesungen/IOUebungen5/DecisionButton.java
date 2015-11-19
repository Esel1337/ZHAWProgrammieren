package IOUebungen5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class DecisionButton {

  private JFrame frame;
  private List<String> decisions;
  private DecisionFileManager fileManager;
  private final Random random;

  public DecisionButton() {
    decisions = new ArrayList<String>();
    fileManager = new DecisionFileManager();
    random = new Random();
    createGui();
  }

  private void createGui() {

    frame = new JFrame("Entscheidungsknopf");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createMenuBar();

    Container contentPane = frame.getContentPane();

    contentPane.add(BorderLayout.NORTH, getInputPanel());
    
    contentPane.add(BorderLayout.CENTER, createButton());

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

  private JPanel getInputPanel() {
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    inputPanel.add(new JLabel("Tat:"));
    final JTextField textField = new JTextField(20);
    textField.setToolTipText("Hier eine TÃ¤tigkeit eingeben");
    inputPanel.add(textField);
    JButton saveButton = new JButton("save");
    saveButton.setMnemonic(KeyEvent.VK_ENTER);  // alt+enter um den button zu waehlen
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addDecision(textField.getText());
        textField.requestFocus();
        textField.setText("");
      }
    });
    inputPanel.add(saveButton);
    return inputPanel;
  }
  
  private void addDecision(String input) {
    String text = input.trim();
    if (text.isEmpty()) {
      JOptionPane.showMessageDialog(frame, "Nichts eigegeben");
    } else if (decisions.contains(text)) {
      JOptionPane.showMessageDialog(frame, "Eintrag schon vorhanden");
    } else {
      decisions.add(text);
    }
  }

  private String getRandomDecision() {
    if (decisions.isEmpty()) {
      return "Bitte Entscheidungen eintragen";
    }

    int randomIndex = random.nextInt(decisions.size());
    return decisions.get(randomIndex);
  }
  
  private void saveDecisions() {
    JFileChooser fileChooser = new JFileChooser();
    int choice = fileChooser.showSaveDialog(frame);
    if (choice == JFileChooser.APPROVE_OPTION) {
      try {
        fileManager.save(fileChooser.getSelectedFile(), decisions);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Fehler beim speichern: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  private void loadDecisions() {
    JFileChooser fileChooser = new JFileChooser();
    int choice = fileChooser.showOpenDialog(frame);
    if (choice == JFileChooser.APPROVE_OPTION) {
      try {
        decisions = fileManager.load(fileChooser.getSelectedFile());
      } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Fehler beim Laden: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
      } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(frame, "Fehler beim Laden: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  private void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu dateiMenu = new JMenu("Datei");
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
    
    dateiMenu.add(loadItem);
    dateiMenu.add(saveItem);
    menuBar.add(dateiMenu);
  }
}
