package ch.basel.kinderbuch.Uebung349;

class MeineEx extends Exception {
}

public class ExTestlauf {
public static void main(String[] args) {
	String test="nein";

		
		try
		{
			System.out.print("au");
			tuRiskantes(test);
		} catch(MeineEx e)

	{ 
	System.out.print("loes");
	System.out.print("e");
	
	}
		
		finally
		{
			System.out.println("n");
		}
}

	static void tuRiskantes(String t) throws MeineEx{
		
		System.out.print("s");
		if("ja".equals(t)){
			throw new MeineEx();
			
		}
		
		else {
			System.out.print("spa");
			System.out.print("nn");
			System.out.print("e");
		}
		
		
	}
	}
