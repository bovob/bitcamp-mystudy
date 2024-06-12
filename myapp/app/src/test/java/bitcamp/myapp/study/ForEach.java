package bitcamp.myapp.study;

public class ForEach {
  public static void main(String[] args) {
      int [] iarr = {10,20,30,40,50};
//      Java 1.5이상부터 사용가능
//      for (int i = 0; i < iarr[i]; i++){
//        int value = iarr[i];
//        System.out.println(value); }
    

//    for(타입 값을받을 변수 : 출력하고 싶은 자료구조)
      for (int value: iarr){
        System.out.println(value);
      }
  }
}
