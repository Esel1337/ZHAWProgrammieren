package GUI01Aufgabe6Decisionbutton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DecisionButton {

  private JFrame frame;
  private final List<String> decisions;
  private final Random random;

  public DecisionButton() {
    decisions = new ArrayList<String>();
    random = new Random();
    initDecisions();
    createGui();
  }

  private void createGui() {

    frame = new JFrame("Entscheidungsknopf");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();

    JButton button = createButton();
    contentPane.add(button);

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
  
  private void initDecisions() {
    decisions.add("Kino");
    decisions.add("Konzert");
    decisions.add("Grossmutter");
    decisions.add("Party");
    decisions.add("Essen gehen");
  }

  private String getRandomDecision() {
    int randomIndex = random.nextInt(decisions.size());
    return decisions.get(randomIndex);
  }
}
