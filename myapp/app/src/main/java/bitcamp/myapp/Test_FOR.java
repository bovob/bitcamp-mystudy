package bitcamp.myapp;

import java.util.Scanner;

public class Test_FOR {
    public static void main(String[] args) {

        String line = "--------------------------------";
        String inputName = "입력하시오 > ";
//        for 예시 ex06_410~
//      1)
      for (int i=1; i<5 ;i++) System.out.println(i);
      System.out.println(line);

      int j=1;
      while (j <= 5) {          // for( ; j <= 5 ; ) 에서 변환해버림 강제로
        System.out.println(j);
        }
        System.out.println(line);


//      2)
      int w1=1;
      for (; ;){
          if (w1>5)
              break;
          System.out.println(w1);
          w1++;
      }
//      3)
        System.out.println(line);
      for (int x1=1; x1<=5;x1++){
          for(int x2=1; x2<=5;x2++){
              System.out.print("*");
          }
          System.out.println();
      }

        System.out.println(line);

    }
}
