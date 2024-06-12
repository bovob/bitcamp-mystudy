package study.lang.method;

public class Test10 {

  public static void main(String[] args) {
    System.out.println(create().length);
    System.out.println(create()[0]);
    System.out.println(create()[1]);
    System.out.println(create()[2]);
  }

  static int[] create() {
    int[] arr = new int[] {100, 200, 300};
    return arr;
  }
}
