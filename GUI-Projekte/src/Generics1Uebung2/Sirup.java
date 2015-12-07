package Generics1Uebung2;
public class Sirup implements drinkable {

 private String flavour;

 public Sirup(String flavour) {
 this.flavour = flavour;
 }
 @Override
 public String getFlavour() {
 return flavour + " Sirup";
 }
}
