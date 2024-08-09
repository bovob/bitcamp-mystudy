package study.concurrent;

class MyThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.printf("Thread==> %d\n", i);
    }
  }
}


public class test02 {
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.printf("==> %d\n", i);
    }

    Thread t = new MyThread();
    t.start();

    System.out.println("---------------------------");
    for (int i = 0; i < 100; i++) {
      System.out.printf("~~~~> %d\n", i);
    }
  }
}
