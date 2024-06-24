package bitcamp.myapp.study;

import org.checkerframework.checker.units.qual.C;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        Parent p = t.new Child();

        p.staticMethod();

    }

    class Parent {

        public void staticMethod() {
            System.out.println("부모 클래스");
        }
    }

    class Child extends Parent {

        @Override
        public void staticMethod() {
            System.out.println("자식 클래스");
        }
    }

}
