// 1) 스레드 사용 전
// 2) 스레드 사용 후 => 패키지 멤버 클래스로 스레드 구현하기
// 3) 인스턴스 생성 후 즉시 메서드 호출하기
// 4) 패키지 멤버를 스태틱 중첩 클래스로 만든다.
// 5) 스태틱 중첩 클래스를 로컬 클래스로 만든다.
// 6) 로컬 클래스가 바깥 메서드의 변수를 사용할 때 
//    로컬 클래스에서 그 변수의 값을 다룰 수 있도록
//    그와 관련된 인스턴스 필드와 생성자 파라미터를 
//    컴파일러가 자동으로 만드는 기법을 활용한다. 
// 7) 로컬 클래스를 익명 클래스로 만든다.
package concurrent;

public class Exam0170 {

  public static void main(String[] args) {

    int count = 1000;

    Thread t = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    };

    t.start(); 

    for (int i = 0; i < count; i++) {
      System.out.println(">>> " + i);
    }
  }



}