package EnumStaticEnumV2Kap6;
public class EnumDemo_v2 {
   
   public String herkunft(Wochentag tag) {

      String s = "";

      switch (tag) {
         case MONTAG:     s = Wochentag.MONTAG.herkunft();
                          break;
         case DIENSTAG:   s = Wochentag.DIENSTAG.herkunft();
                          break;
         case MITTWOCH:   s = Wochentag.MITTWOCH.herkunft();
                          break;
         case DONNERSTAG: s = Wochentag.DONNERSTAG.herkunft();
                          break;
         case FREITAG:    s = Wochentag.FREITAG.herkunft();
                          break;
         case SAMSTAG:    s = Wochentag.SAMSTAG.herkunft();
                          break;
         case SONNTAG:    s = Wochentag.SONNTAG.herkunft();
                          break;
      }

      return s;
   }
   
   
   // for-each-loop ueber enums
   public void printAlleTage() {
       for( Wochentag tag : Wochentag.values() ) {
         System.out.println(tag.toString() + ": " + tag.herkunft());
        }
    }
}