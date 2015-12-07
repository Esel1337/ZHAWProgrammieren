package EnumStaticEnumV1Kap6;
public class EnumDemo_v1 {
   
   public String herkunft(Wochentag tag) {

      String s = "";

      switch (tag) {
         case MONTAG:     s = "Tag der roemischen Mondgoettin Luna";
                          break;
         case DIENSTAG:   s = "Tag des nordischen Kriegsgottes Tyr";
                          break;
         case MITTWOCH:   s = "Tag des nordischen Gottes Odin";
                          break;
         case DONNERSTAG: s = "Tag des nordischen Donnergottes Thor";
                          break;
         case FREITAG:    s = "Tag der nordischen Goettin Freya";
                          break;
         case SAMSTAG:    s = "Tag des roemischen Gottes Saturn";
                          break;
         case SONNTAG:    s = "Tag des roemischen Sonnengottes Sol";
                          break;
      }

      return s;
   }
}
