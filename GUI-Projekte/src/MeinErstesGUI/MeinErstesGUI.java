package MeinErstesGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeinErstesGUI {

	//Instanzvariablen
	private JFrame frame;

	//Konstruktor
	public MeinErstesGUI() {
		createFrame();

	}

	//GUI erstellen (Rahmen und button dazu)
	private void createFrame() {
		// Rahmen erzeugen
		frame = new JFrame("Mein erstes GUI");
		//Das definiert dass ich das Program zu machen wenn ich es schliesse:
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Button erzeugen und hinzufügen
		JButton button = new JButton("Ich bin ein Button");
		frame.getContentPane().add(button);
	
		
		createMenuBar();
		
		//Grösse definieren
		frame.setSize(300,200);
		//Sichtbar machen
		frame.setVisible(true);

	}

	

	private void createMenuBar() {
		// Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		// Menü (JMenu) erzeugen und in die Men�zeile (JMenuBar) einf�gen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);
		// Menüeintr�ge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufügen
		JMenuItem oeffnenItem = new JMenuItem("�ffnen");
		dateiMenu.add(oeffnenItem);
		oeffnenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ich bin Müde.");
				
			}
		});
		JMenuItem beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//SystemBeenden
				System.exit(0);
				
			}
		});
		
		// Hilfe Menü erstellen
		JMenu hilfe = new JMenu("Hilfe");
		bar.add(hilfe);
		
		JMenuItem ueberItem = new JMenuItem("über");
		hilfe.add(ueberItem);

	}
	
	public static void main(String[] args) {
		new MeinErstesGUI();

	}
}
	
	
	
	
