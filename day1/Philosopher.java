package day1;

import java.util.Random;

public class Philosopher extends Thread {
  private Boolean left, right;
  private Random random;
  
  public Philosopher(Boolean left, Boolean right) {
    this.left = left;
    this.right = right;
    random = new Random();
  }
  
  public void run() {
    try {
      while (true) {
        Thread.sleep(random.nextInt(1000));
        synchronized (left) {
          System.out.println("Philosopher " + this.getId() + " picked left chopstick");
          synchronized (right) {
            System.out.println("Philosopher " + this.getId() + " picked right chopstick and eating");
            Thread.sleep(random.nextInt(1000));
          }
        }
      }
    } catch (InterruptedException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
    Boolean b1 = true;
    Boolean b2 = true;
    Boolean b3 = true;
    Boolean b4 = true;
    Boolean b5 = true;
    Philosopher p1 = new Philosopher(b1, b2);
    Philosopher p2 = new Philosopher(b2, b3);
    Philosopher p3 = new Philosopher(b3, b4);
    Philosopher p4 = new Philosopher(b4, b5);
    Philosopher p5 = new Philosopher(b5, b1);
    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
    p1.join();
    p2.join();
    p3.join();
    p4.join();
    p5.join();
  }
}
