package VererbungBauernhofKap10;
public class BauernhofTest {

  public static void main(String[] args) {
    
    Bauernhof b = new Bauernhof();
    b.addTier(new Kuh());
    b.addTier(new Katze());
    b.addTier(new Hund());
    b.addTier(new Katze());
    b.addTier(new Kuh());
    b.lautgeben();

  }
}
