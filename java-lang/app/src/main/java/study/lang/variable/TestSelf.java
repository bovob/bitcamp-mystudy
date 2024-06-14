package study.lang.variable;

public class TestSelf {

  public static void main(String[] args) {
    String[][] arr = new String[2][2];

    System.out.println(arr.length);

    System.out.println("------------------");

    System.out.println(arr[0].length);
    System.out.println(arr[1].length);

    System.out.println("------------------");

    // System.out.println(arr[0][0].length);
    // System.out.println(arr[1][0].length);

    int[][] arr2 = { // new int를 생략가능
        {1, 2, 3, 4}, {1, 2, 3}, {1, 2}};

    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        System.out.printf("(%d행 %d열):%s ", i, j, arr2[i][j]);
      }
      System.out.println();
    }

  }

}
