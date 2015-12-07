package EnumStaticKlassenmethodenKap6;
public class Gespenst {

   private static int anzahl = 0;
   private String name;

   private Gespenst() {
      ++anzahl;
      name = "Gespenst" + anzahl;
   }

   public static Gespenst gespenstErzeugen() {
      if (anzahl < 3)
         return new Gespenst();
      else
         return null;
   }

   public void spuken()  {
      System.out.println("\t" + name + ": Huuhuu!");
   }
   
   public static int getAnzahl() {
       return anzahl;
   }

}

