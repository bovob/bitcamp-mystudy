package bitcamp.myapp.study;

import java.util.Arrays;
import java.util.Objects;

public class Test {


    public static void main(String[] args) throws CloneNotSupportedException {

        // String 인스턴스
        String a;
        a = "Test String";
        System.out.printf("a는 : %s\n", a);

        String b;
        b = "Test String";
        System.out.print("a와 b 구분 : ");
        System.out.println(a == b);

        System.out.print("a instance of : ");
        System.out.println(a instanceof String);

        System.out.print("b instance of : ");
        System.out.println(a instanceof String);

        System.out.println("--------------------");

        // Heap 영역에 String 인스턴스 생성
        String s1 = "Hello";
        String s2 = s1.intern();

        System.out.printf("s1과 s2 : %s, %s\n", s1, s2);
        System.out.printf("s1==s2? : %s\n", s1 == s2);

        System.out.printf("s1.equals s2 : %s \n", s1.equals(s2));
        System.out.printf("s1 instance of : %s \n", s1 instanceof String);
        System.out.printf("s2 instance of : %s \n", s2 instanceof String);

        System.out.println("--------------------");
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);

        System.out.printf("m1 == m2 ? %s\n", m1 == m2);
        System.out.printf("m1 equals m2 ? %s\n", m1.equals(m2));

        System.out.println("--------------------");

        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        System.out.printf("b1 > %s\n", b1);
        System.out.printf("b1 == b2 ? %s\n", b1 == b2);
        System.out.printf("b1 equals b2 ? %s\n", b1.equals(b2));
        System.out.printf("b1 toString b2 ? %s\n", b1.toString().contentEquals(b2.toString()));

        b1.replace(1, 4, "!");
        System.out.printf("b1 1~4 !!!! 변환 > %s\n", b1);

        System.out.println("--------------------");

        String[] arr = new String[]{"123", "가나다", "abc"};
        String arr1 = String.format("%s,%s,%s", arr[0], arr[1], arr[2]);
        String arr2 = String.format("%s,%s,%s", arr);
        String arr3 = String.join("##", arr);

        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);

        String[] arrCopy = Arrays.copyOfRange(arr, 1, 2);
        for (String s : arrCopy) {
            System.out.println(s);
        }
        System.out.println("--------------------");


    }


    static class Member {

        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Member other = (Member) obj;
            return age == other.age && Objects.equals(name, other.name);
        }

    }


}
