package Netzwerkprogram1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Writer {

	public static void main(String[] args) {
	

		
	Socket chatSocket = null;
	try {
		chatSocket = new Socket("192.168.43.219", 9999);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Ich muss noch etwas machen
		e.printStackTrace();
	}


	PrintWriter writer = null;
	try {
		writer = new PrintWriter(chatSocket.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	writer.println("test");
	writer.close();
	}
	

}
