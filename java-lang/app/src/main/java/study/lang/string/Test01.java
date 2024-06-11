package study.lang.string;

public class Test01 {

  public static void main(String[] args) {
    String s;
    s = new String("aaa");
    // s = null;

    // primitive data type (byte, short, int, long, boolean, float, double, char)
    // null이 들어가면 reference 변수 (주소가 들어감)

    String s2 = new String("aaa");

    System.out.println(s == s2); // 레퍼런스에 저장된 인스턴스의 주소
    System.out.println("-------------");
    System.out.println(s.equals(s2));


  }
}
