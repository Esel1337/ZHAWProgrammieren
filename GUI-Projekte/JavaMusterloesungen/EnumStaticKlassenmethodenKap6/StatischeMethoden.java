package EnumStaticKlassenmethodenKap6;
public class StatischeMethoden {
    
   public void spuken() {

      Gespenst gespenst1 = Gespenst.gespenstErzeugen();
      Gespenst gespenst2 = Gespenst.gespenstErzeugen();
      Gespenst gespenst3 = Gespenst.gespenstErzeugen();
      Gespenst gespenst4 = Gespenst.gespenstErzeugen();
      Gespenst gespenst5 = Gespenst.gespenstErzeugen();

      System.out.println("Es spuken zur Zeit "
                          + Gespenst.getAnzahl() + " Gespenster.");

      if (gespenst1 != null) gespenst1.spuken();
      if (gespenst2 != null) gespenst2.spuken();
      if (gespenst3 != null) gespenst3.spuken();
      if (gespenst4 != null) gespenst4.spuken();
      if (gespenst5 != null) gespenst5.spuken();

      System.out.println();
   }
}

