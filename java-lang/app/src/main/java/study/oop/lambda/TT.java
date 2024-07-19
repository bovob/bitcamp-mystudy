package study.oop.lambda;

interface Player {
  void play();
}


public class TT {

  class Myplayer implements Player {
    @Override
    public void play() {
      System.out.println("1번");
    }
  }

  test(new Myplayer());


  static void test(Player player) {
    player.play();
  }
}
