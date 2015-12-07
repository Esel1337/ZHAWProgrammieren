package Threads3UhrEinfach.swinguhr;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import Threads3UhrEinfach.controller.Uhrwerk;

public class Uhr {

  private final JFrame frame;
  private final SwingZifferblatt zifferblatt;
  private final JPanel buttonPanel = new JPanel();
  private final JToggleButton toggleButton;
  private final Uhrwerk uhrwerk;

  public Uhr() {
    this.frame = new JFrame("Uhr");
    this.zifferblatt = new SwingZifferblatt();
    this.uhrwerk = new Uhrwerk(zifferblatt);
    this.toggleButton = new JToggleButton("Start");
    createAndShowUI();
  }

  private void createAndShowUI() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(zifferblatt, BorderLayout.CENTER);
    
    toggleButton.addActionListener(new ActionListener() {
      
      
      @Override
      public void actionPerformed(ActionEvent e) {
        if (toggleButton.isSelected()) {
          toggleButton.setText("Stop");
          uhrwerk.start();
        } else {
          toggleButton.setText("Start");
          uhrwerk.stop();
        }
      }
    });
    
    
    buttonPanel.add(toggleButton);
    frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    
    frame.setSize(200, 250);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new Uhr();
  }
//    button.addActionListener(new ActionListener() {
//      
//      @Override
//      public void actionPerformed(ActionEvent e) {
////        JOptionPane.showInputDialog(panel, "test", "test", JOptionPane.INFORMATION_MESSAGE,
////            null, new Object[]{"Hallo"}, "Hallo");
//        
//        new AlarmDialog().openDialog(frame);
//      }
//    });
//    frame.getContentPane().add(button, BorderLayout.SOUTH);
}
