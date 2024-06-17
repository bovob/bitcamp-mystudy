package bitcamp.study.oop;

public class Test02 {

    public static void main(String[] args) {

        Score s1 = new Score("홍길동", 10, 20, 30);
        printScore(s1);

    }

    static void printScore(Score s1) {
        System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
            s1.aver);

    }

}
