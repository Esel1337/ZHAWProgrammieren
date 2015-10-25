package GUI1U4;

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
    
    JButton button = new JButton("Drück mich");
    button.addActionListener(new ButtonListener());
    contentPane.add(button);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  private void createMenuBar() {
    
    // Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
    JMenuBar bar = new JMenuBar();
    frame.setJMenuBar(bar);
    
    // Menü (JMenu) erzeugen und in die Menüzeile (JMenuBar) einfügen
    JMenu dateiMenu = new JMenu("Datei");
    bar.add(dateiMenu);
   
    // Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei" hinzufügen
    JMenuItem oeffnenItem = new JMenuItem("Öffnen");
    oeffnenItem.addActionListener(new OpenActionListener());
    dateiMenu.add(oeffnenItem);
    
    JMenuItem beendenItem = new JMenuItem("Beenden");
    beendenItem.addActionListener(new ExitActionListener());
    dateiMenu.add(beendenItem);
    
  }
  
  private class OpenActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Öffnen wurde ausgewählt");
    }
  }
  
  private class ExitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Beenden wurde ausgewählt");
      System.exit(0);
    }
  }
  
  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Button gedrückt");
    }
  }
  public static void main(String[] args) {
	new MeinErstesGUI4();
}
}
