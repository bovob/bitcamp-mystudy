package study.lang.operator;

// 실습
// - 산술 연술자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습내용
// - byte, short, char를 산술연산할 때 int로 변환한 후 수행한다.
// - 같은 타입끼리만 연산할 수 있다.
// - int와 int의 연산 결과는 int이다.
// - 다른 타입으로 변환하는 것을 '형변환(Type Casting)' 이라 한다.


public class Test02 {

  public static void main(String[] args) {

    byte b1 = 100;
    byte b2 = 20;
    byte b3;

    // 다음 코드를 완성하라.
    // - b3 변수에 b1 + b2 값을 넣고 출력
    System.out.println(b3 = (byte) (b1 + b2));

    // 자바에서 정수 기본 연산은 int 로 진행되어
    // byte가 int로 변경되어 그냥 b3 = b1 + b2 는 에러가 발생한다.
    // byte타입 b3에 int 결과인 b1 + b2 는 손실이 발생할 수 있기 때문이다.
    // 따라서 b1 + b2 결과를 byte로 명시적 형변환 뒤 b3에 대입이 가능하다.
    int r = b1 + b2;
    char c = 20;
    short s = 30;
    // short r2 = c + s;

    // int로 이미 결과가 오버플로우기 때문에 long도 오버플로우 값이 나온다.
    int i1 = 21_0000_0000;
    int i2 = 21_0000_0000;
    int i3 = i1 + i2;
    System.out.println(i3);

    long r3 = i1 + i2;
    System.out.println(r3);

    long l1 = 22_0000_0000L;
    long l2 = 21_0000_0000L;
    long l3 = l1 + l2;
    System.out.println(l3);

  }
}
