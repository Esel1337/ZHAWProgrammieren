package Threads3Uebung3Entscheidungsknopf;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class DecisionButton {

  private JFrame frame;
  private List<String> decisions;
  private IOStrategy iOStrategy;
  private final Random random;

  public DecisionButton() {
    decisions = new ArrayList<String>();
    iOStrategy = new ObjectStreamStrategy();
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
    textField.setToolTipText("Hier eine Tätigkeit eingeben");
    inputPanel.add(textField);
    JButton saveButton = new JButton("save");
    saveButton.setMnemonic(KeyEvent.VK_ENTER); // alt+enter um den button zu
                                               // waehlen
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
      frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      new SaveTask(fileChooser.getSelectedFile()).execute();
    }
  }

  private void loadDecisions() {
    JFileChooser fileChooser = new JFileChooser();
    int choice = fileChooser.showOpenDialog(frame);
    if (choice == JFileChooser.APPROVE_OPTION) {
      frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      new LoadTask(fileChooser.getSelectedFile()).execute();
    }
  }

  private void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu dateiMenu = new JMenu("Datei");
    JMenuItem loadItem = new JMenuItem("laden");
    loadItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        loadDecisions();
      }
    });

    JMenuItem saveItem = new JMenuItem("speichern");
    saveItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        saveDecisions();
      }
    });

    dateiMenu.add(loadItem);
    dateiMenu.add(saveItem);
    menuBar.add(dateiMenu);

    // io-strategy
    JMenu strategyMenu = new JMenu("IO-Strategie");
    final JRadioButtonMenuItem objectStreamItem = new JRadioButtonMenuItem(
        "Object");
    objectStreamItem.setSelected(true);
    objectStreamItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        iOStrategy = new ObjectStreamStrategy();
      }
    });
    strategyMenu.add(objectStreamItem);

    final JRadioButtonMenuItem fileItem = new JRadioButtonMenuItem("File");
    fileItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        iOStrategy = new FileIOStrategy();
      }
    });
    strategyMenu.add(fileItem);

    ButtonGroup saveStrategyGroup = new ButtonGroup();
    saveStrategyGroup.add(objectStreamItem);
    saveStrategyGroup.add(fileItem);

    menuBar.add(strategyMenu);
  }

  private class SaveTask extends SwingWorker<Void, Void> {

    private File file;

    public SaveTask(File file) {
      this.file = file;
    }

    @Override
    protected Void doInBackground() throws IOException {
      iOStrategy.save(file, decisions);
      return null;
    }

    @Override
    protected void done() {
      frame.setCursor(null); 
      try {
        get();
        JOptionPane.showMessageDialog(frame, "Entscheidungen gespeichert!");
      } catch (InterruptedException | ExecutionException e) {
        JOptionPane.showMessageDialog(frame,
            "Fehler beim speichern: " + e.getCause().getMessage(), "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private class LoadTask extends SwingWorker<List<String>, Void> {

    private File file;

    public LoadTask(File file) {
      this.file = file;
    }

    @Override
    protected List<String> doInBackground() throws ClassNotFoundException,
        IOException {
      return iOStrategy.load(file);
    }

    @Override
    protected void done() {
      frame.setCursor(null);
      try {
        decisions = get();
        JOptionPane.showMessageDialog(frame, "Entscheidungen geladen!");
      } catch (InterruptedException | ExecutionException e) {
        JOptionPane.showMessageDialog(frame,
            "Fehler beim Laden: " + e.getCause().getMessage(), "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
