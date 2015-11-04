package ch.zhaw.gui2Muster;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DecisionButton {

  private JFrame frame;
  private final List<String> decisions;
  private final Random random;

  public DecisionButton() {
    decisions = new ArrayList<String>();
    random = new Random();
    createGui();
  }

  private void createGui() {

    frame = new JFrame("Entscheidungsknopf");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    saveButton.setMnemonic(KeyEvent.VK_ENTER);  // alt+enter um den button zu waehlen
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
      return "keine Einträge";
    }
    int randomIndex = random.nextInt(decisions.size());
    return decisions.get(randomIndex);
  }
}
