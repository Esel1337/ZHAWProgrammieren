package SammlungenMultiplukationstabNotizbuchKap4;


public class Multiplikationstabelle {

  private int x;

  private int y;

  public Multiplikationstabelle(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void printTabelle() {
    for (int j = 1; j <= y; j++) {
      for (int i = 1; i <= x; i++) {
        System.out.print(i * j + " ");
      }
      System.out.println();
    }
  }

  public void printWhile() {
    int i = 1;
    while (i <= y) {
      int j = 1;
      while (j <= x) {
        System.out.print(j * i + " ");
        j++;
      }
      System.out.println();
      i++;
    }
  }

  public static void main(String[] args) {
    new Multiplikationstabelle(7, 3).printTabelle();
    new Multiplikationstabelle(7, 3).printWhile();
  }

}
