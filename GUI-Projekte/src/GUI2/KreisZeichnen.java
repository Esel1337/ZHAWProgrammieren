package GUI2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class KreisZeichnen extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;

	public void paintComponent(Graphics g) {
	
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int rot = (int) (Math.random() * 255);
		int gruen = (int) (Math.random() * 255);
		int blau = (int) (Math.random() * 255);

		Color randomColor = new Color(rot, gruen, blau);
		g.setColor(randomColor);
		//Mit dem schauen wir, dass der kreis immer in der Mitte ist:
		g.fillOval((this.getWidth()/2)-(WIDTH/2),(this.getHeight()/2)-(HEIGHT/2),WIDTH,HEIGHT);

	}
}
