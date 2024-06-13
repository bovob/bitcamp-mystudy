package study.lang.variable;

public class TestSelf {

  public static void main(String[] args) {
    String[][] arr = new String[2][2];

    System.out.println(arr.length);

    System.out.println("------------------");

    System.out.println(arr[0].length);
    System.out.println(arr[1].length);

    System.out.println("------------------");

    System.out.println(arr[0][0].length);
    System.out.println(arr[1][0].length);

  }

}
