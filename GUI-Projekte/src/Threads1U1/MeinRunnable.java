package Threads1U1;
public class MeinRunnable implements Runnable {
 @Override
 public void run() {
 los();
 }
 private void los() {
 tuNochMehr();
 }
 private void tuNochMehr() {
 System.out.println("Oben auf den Stack");
 }
}