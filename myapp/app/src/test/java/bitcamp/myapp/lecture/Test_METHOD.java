package bitcamp.myapp.lecture;

public class Test_METHOD {
  public static void main (String[] args){

    // 기본 타입(Primitive)값 Call by Value - Stack
    int A = 100;
    calValue(A);
    System.out.print("Primitive Int Value : ");
    System.out.println(A);

    System.out.println("---");

    // 객체의 참조(주소)값 Call by Value of reference - Heap
    int[] Array = new int[]{100,200,300};
    calRefer(Array);
    System.out.print("Reference Array Value : ");
    for (int i = 0 ; i < Array.length ; i++) {
      System.out.println(Array[i]);
    }
  }

  // 현재 메서드에서 만 값 변경
  static void calValue(int a){
    a = 100;
  }

  // 객체 주소를 참조하여 값 변경
  static void calRefer(int[] arr){
    for (int i = 0 ; i < arr.length ; i++) {
      arr[i] = i + 1;
    }
  }
}
