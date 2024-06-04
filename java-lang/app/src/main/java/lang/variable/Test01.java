package lang.variable;

public class Test01 {
  public static void main(String[] args)
  // 실습
  // - primitive type의 변수를 선언하라.
  // - 각 변수의 최소값, 최대값을 할당하라.
  // - 각 변수의 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
  // - 예)
  // byte b1 = -128;
  // byte b2 = 127;
  // byte, short, int, long, float, double, char, boolean
  /*
   * byte bMin = -128; byte bMax = 127;
   *
   * short sMin = -32768; short sMax = 32767;
   *
   * int iMin = -210000000; int iMax = 210000000;
   *
   * long lMin = -9200000000000000000l; long lMax = 9200000000000000000l;
   *
   * float fMin = -0.123456789f; float fMax = 0.123456789f;
   *
   * double dMin = -0.123456789123456789; double dMax = 0.123456789123456789;
   *
   * char cMin = 'a';
   *
   * boolean boolMin = false; boolean boolMax = true;
   */

  {
    // byte
    System.out.println("byte 최소값: " + Byte.MIN_VALUE);
    System.out.println("byte 최대값: " + Byte.MAX_VALUE);

    // short
    System.out.println("short 최소값: " + Short.MIN_VALUE);
    System.out.println("short 최대값: " + Short.MAX_VALUE);

    // int
    int ab = 123_123;
    System.out.println("int 최소값: " + Integer.MIN_VALUE);
    System.out.println("int 최대값: " + Integer.MAX_VALUE);

    // long
    System.out.println("long 최소값: " + Long.MIN_VALUE);
    System.out.println("long 최대값: " + Long.MAX_VALUE);

    // float
    float f1 = -9876.4327f;
    System.out.println("float 최소값: " + Float.MIN_VALUE);
    System.out.println("float 최소값: " + f1);
    System.out.println("float 최대값: " + Float.MAX_VALUE);

    // double
    double d1 = 987654321011.789;
    System.out.println("double 최소값: " + Double.MIN_VALUE);
    System.out.println("double 최소값: " + d1);
    System.out.println("double 최대값: " + Double.MAX_VALUE);

    // char
    char a;
    a = 55;
    System.out.println("char 최소값: " + (int) Character.MIN_VALUE);
    System.out.println("char 최소값: " + a);
    System.out.println("char 최대값: " + (int) Character.MAX_VALUE);

    // boolean
    System.out.println("boolean 값: " + true + ", " + false);
  }
}

