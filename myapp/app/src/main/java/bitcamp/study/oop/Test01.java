package bitcamp.study.oop;

import bitcamp.study.oop.util.Calculator;

public class Test01 {

    public static void main(String[] args) {
        // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        // 2 + 3 - 1 * 7 / 3 = ?

        Calculator c1 = new Calculator();

        c1.plus(2);
        c1.plus(3);
        c1.minus(1);
        c1.multiple(7);
        c1.divide(3);

        System.out.printf("result = %d\n", c1.getResult());

        c1.clear();

        // 계산식2 : 3 * 7 - 2
        c1.plus(3);
        c1.multiple(7);
        c1.minus(2);

        System.out.printf("result = %d\n", c1.getResult());
    }

}
