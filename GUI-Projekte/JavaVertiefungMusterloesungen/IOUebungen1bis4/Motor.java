package IOUebungen1bis4;
import java.io.Serializable;

public class Motor implements Serializable {
  
  private int hubraum;
  
  public Motor(int hubraum) {
    this.hubraum = hubraum;
  }
  
  public int getHubraum() {
    return hubraum;
  }
}
