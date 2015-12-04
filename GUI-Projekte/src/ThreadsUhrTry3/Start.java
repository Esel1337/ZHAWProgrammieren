package ThreadsUhrTry3;

public class Start {

	public static void main(String[] args) {
		
		Runnable threadJob = new Clock("hll");
		Thread meinThread = new Thread(threadJob);
		
		
		
	}

	
}
