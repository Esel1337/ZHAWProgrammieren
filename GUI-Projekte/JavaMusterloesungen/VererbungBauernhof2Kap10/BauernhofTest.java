package VererbungBauernhof2Kap10;


public class BauernhofTest {

  
  public static void main(String[] args) {
    Tier katze = new Katze();
    Tier hund = new Hund();
    Tier kuh = new Kuh("Elsa", 750);
    Tier katze2 = new Katze();
    
    Bauernhof b = new Bauernhof();
    
    b.addKuh(new Kuh("Elsa", 700));
    b.addKuh(new Kuh("Lisa", 650));
    b.addKuh(new Kuh("Anneliese", 800));
    
    b.kuhAusgeben();
    
    b.addTier(katze);
    b.addTier(hund);
    b.addTier(kuh);
    b.addTier(katze2);
    
    b.lautgeben();
    
  }
}
