package bitcamp.study.oop;

import bitcamp.study.oop.domain.Score;

public class Test02 {

    static Score[] scores = new Score[]{
        new Score("홍길동", 100, 90, 85),
        new Score("임꺽정", 90, 80, 75),
        new Score("유관순", 80, 70, 65)
    };

    public static void main(String[] args) {
        printScore();
    }

    static void printScore() {
        for (Score scores : scores) {
            System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
                scores.getName(), scores.getKor(), scores.getEng(),
                scores.getMath(), scores.getSum(), scores.getAver());
        }
    }
}
