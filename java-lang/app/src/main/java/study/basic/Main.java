package study.basic;

class Parent {
  int compute(int num) {
    if (num <= 1) {
      return num;
    }
    return compute(num - 1) + compute(num - 2);
  }
}


class Child extends Parent {
  @Override
  int compute(int num) {
    if (num <= 1) {
      return num;
    }
    return compute(num - 1) + compute(num - 3);
  }
}


public class Main {
  public static void main(String args[]) {
    Parent obj = new Child();
    System.out.print(obj.compute(7));
  }
}
