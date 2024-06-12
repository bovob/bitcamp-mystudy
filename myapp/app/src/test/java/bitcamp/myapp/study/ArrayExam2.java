package bitcamp.myapp.study;

public class ArrayExam2 {
  public static void main(String[] args){
    int[][] array4 = new int [3][4];
    array4[0][1] = 10;

//    2차원 배열 크기 설정을 해주지 않으면 에러
//    int[][] array5 = new int [3][];
//    array5[0][0] = 10;
//    array5[3][10] = 20;

    int[][] array6 = {{1},{1,2},{1,2,3}};

//    주소가 정해지지 않으면 이상한 값이 나온다. ex) [[I@4517d9a3
//    System.out.println(array4);
    System.out.println(array4[0][1]);
    System.out.println("-----");
    for (int i = 0 ; i <array6.length ; i++)
    {
      System.out.print((i+1)+ "번쨰 줄을 출력합니다 >");
      for (int j = 0 ; j < array6[i].length ; j++){
        System.out.print(array6[i][j]+ " ");
      }
      System.out.println(" ");
    }
  }
}
