package ch.zhaw.java16.uebung;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DateiSchreiben {

	public static void main(String[] args) {
		
		File file = new File("C:/Users/Micael/Desktop/datei.txt");

				try (FileWriter fw = new FileWriter(file))
				{
				
					fw.write("blah");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	
		File dir = new File ("C:/Users/Micael/Desktop/Spassdirectory");
				
				try {
					dir.mkdir();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
	}

}
