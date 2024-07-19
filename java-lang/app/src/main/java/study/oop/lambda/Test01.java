package study.oop.lambda;

public class Test01 {

  interface Player {
    void play();
  }

  public static void main(String[] args) {
    // 1) 일반 클래스
    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("일반클래스");
      }
    }
    // Myplayer를 말고도 Player 규칙을 따른 메서드의
    // 주소값도 불러올 수 있다.
    Player p1 = new MyPlayer();
    p1.play();


    // 2) 익명 클래스
    Player p2 = new Player() {
      @Override
      public void play() {
        System.out.println("익명클래스");
      }
    };
    p2.play();

    // 3) 익명 클래스2
    new Player() {
      @Override
      public void play() {
        System.out.println("익명클래스2");
      }
    }.play();

    // 4) 람다
    Player p3 = () -> {
      System.out.println("람다1");
    };
    p3.play();

    // 5) 람다
    Player p4 = () -> System.out.println("람다2");
    p4.play();
  }
}
