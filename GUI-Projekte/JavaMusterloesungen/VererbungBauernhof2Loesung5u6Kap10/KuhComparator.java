package VererbungBauernhof2Loesung5u6Kap10;



import java.util.Comparator;

public class KuhComparator implements Comparator<Kuh> {

  private KuhSort sort;
  
  public KuhComparator(KuhSort sort) {
    this.sort = sort;
  }
  
  @Override
  public int compare(Kuh o1, Kuh o2) {
    
//    if (sort == KuhSort.NAME) {
//      return o1.getName().compareTo(o2.getName());
//    } else if (sort == KuhSort.GEWICHT) {
//      return o1.getGewicht() - o2.getGewicht();
//    }
//    return o1.getGewicht() - o2.getGewicht();

    switch(sort) {
      case GEWICHT: return o1.getGewicht() - o2.getGewicht();
      case NAME: return o1.getName().compareTo(o2.getName());
      default: return o1.getGewicht() - o2.getGewicht();
    }
  
  }
  
  public enum KuhSort {
    NAME, GEWICHT
  }

}
