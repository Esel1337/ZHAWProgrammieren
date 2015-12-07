package VererbungBauernhofKap10;

import java.util.HashSet;
import java.util.Set;

public class Bauernhof {

  private Set<Tier> stall = new HashSet<Tier>();
  
  public void addTier(Tier tier) {
    stall.add(tier);
  }
  
  public void lautgeben() {
    for (Tier tier : stall) {
      tier.gibLaut();
    }
  }
}
