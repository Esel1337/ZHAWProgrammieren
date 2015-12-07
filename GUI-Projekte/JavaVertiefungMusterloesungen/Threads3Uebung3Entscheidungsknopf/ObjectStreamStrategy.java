package Threads3Uebung3Entscheidungsknopf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectStreamStrategy implements IOStrategy {
  
  @Override
  public void save(File file, List<String> decisions) throws IOException {
    ObjectOutputStream oos = null;
    try {
      oos = new ObjectOutputStream(new FileOutputStream(file));
      oos.writeObject(decisions);
    } finally {
      if (oos != null) {
        oos.close();
      }
    }
  }
  
  @Override
  public List<String> load(File file) throws IOException, ClassNotFoundException {
    ObjectInputStream ois = null;
    try {
      ois = new ObjectInputStream(new FileInputStream(file));
      List<String> decisions = (List<String>) ois.readObject();
      return decisions;
    } finally {
      if (ois != null) {
        ois.close();
      }
    }
  }

}
