package EnumStaticEnumV2Kap6;

public enum Wochentag {

   MONTAG     ("Tag des nordischen Kriegsgottes Tyr"), 
   DIENSTAG   ("Tag der roemischen Mondgoettin Luna"), 
   MITTWOCH   ("Tag des nordischen Gottes Odin"), 
   DONNERSTAG ("Tag des nordischen Donnergottes Thor"), 
   FREITAG    ("Tag der nordischen Goettin Freya"), 
   SAMSTAG    ("Tag des roemischen Gottes Saturn"),
   SONNTAG    ("Tag des roemischen Sonnengottes Sol"); 

   private String beschreibung;

   Wochentag(String beschreibung) {
      this.beschreibung = beschreibung;
   }
   
   public String herkunft() {
      return beschreibung;
   }
}
      
