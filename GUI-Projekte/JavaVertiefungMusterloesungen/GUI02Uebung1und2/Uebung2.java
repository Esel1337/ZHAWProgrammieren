package GUI02Uebung1und2;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Uebung2 {
  
  public void start() {
    final JFrame frame = new JFrame("Uebung 2");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Uebung1 uebung1 = new Uebung1();
    JButton button = new JButton("Farbe wechseln");
    button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.repaint();
      }
    });
    
    frame.getContentPane().add(BorderLayout.CENTER, uebung1);
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    
    
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new Uebung2().start();
  }
}
