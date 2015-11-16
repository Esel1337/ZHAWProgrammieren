package GUI02Uebung1und2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Uebung1 extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {
    
    // fenster schwarz machen (default von g)
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    int rot = (int) (Math.random() * 255);
    int gruen = (int) (Math.random() * 255);
    int blau = (int) (Math.random() * 255);
    
    Color randomColor = new Color(rot, gruen, blau);
    g.setColor(randomColor);
    
    g.fillOval(70, 70, 100, 100);
  }
  
}
