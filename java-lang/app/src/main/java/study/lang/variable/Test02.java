package study.lang.variable;

public class Test02 {
  public static void main(String[] args) {
    // 코드를 완성하라.
    char c1 = 0; // 변수 '가' 문자의 코드를 0x0000 값으로 저장하라.
    char c2 = 0; // 변수 '가' 문자의 코드를 \u0000 형태의 유니코드 표현법으로 저장하라.
    char c3 = 0; // 변수 '가' 문자의 코드를 정수 값으로 저장하라.
    char c4 = 0; // 변수 '가' 문자를 가장 단순하게 저장하라.

    c1 = 0xAC00;
    c2 = '\uAC00';
    c3 = 44032;
    c4 = '가';

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
  }
}
