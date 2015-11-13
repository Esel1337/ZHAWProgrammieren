package LE01ErstesGUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeinErstesGUI4 {

  private JFrame frame;
  
  public MeinErstesGUI4() {
    createFrame();
  }

  private void createFrame() {
    frame = new JFrame("Mein erstes GUI");
    createMenuBar();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container contentPane = frame.getContentPane();
    
    JButton button = new JButton("DrÃ¼ck mich");
    button.addActionListener(new ButtonListener());
    contentPane.add(button);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  private void createMenuBar() {
    
    // MenÃ¼zeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfÃ¼gen
    JMenuBar bar = new JMenuBar();
    frame.setJMenuBar(bar);
    
    // MenÃ¼ (JMenu) erzeugen und in die MenÃ¼zeile (JMenuBar) einfÃ¼gen
    JMenu dateiMenu = new JMenu("Datei");
    bar.add(dateiMenu);
   
    // MenÃ¼eintrÃ¤ge (JMenuItem) erzeugen und dem MenÃ¼ (JMenu) "Datei" hinzufÃ¼gen
    JMenuItem oeffnenItem = new JMenuItem("Ã–ffnen");
    oeffnenItem.addActionListener(new OpenActionListener());
    dateiMenu.add(oeffnenItem);
    
    JMenuItem beendenItem = new JMenuItem("Beenden");
    beendenItem.addActionListener(new ExitActionListener());
    dateiMenu.add(beendenItem);
    
  }
  
  private class OpenActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Ã–ffnen wurde ausgewÃ¤hlt");
    }
  }
  
  private class ExitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Beenden wurde ausgewÃ¤hlt");
      System.exit(0);
    }
  }
  
  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Button gedrÃ¼ckt");
    }
  }
}
