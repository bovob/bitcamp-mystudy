package study.oop.lambda;

public class Test03 {
  interface Calculator {
    int plus(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.plus(100, 200));
  }

  public static void main(String[] args) {
    // 1)일반
    class MyCalc implements Calculator {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    }

    Calculator c1 = new MyCalc();
    test(c1);

    // 2)익명
    Calculator c2 = new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    };
    test(c2);

    // 3)익명 직접
    test(new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    });

    // 4)람다
    Calculator c4 = (int a, int b) -> {
      return a + b;
    };
    test(c4);

    // 5)람다 생략
    Calculator c5 = (a, b) -> a + b;
    test(c4);

    // 6)람다 직접
    test((a, b) -> a + b);

  }
}
