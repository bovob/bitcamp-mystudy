// 실습
// - 애플리케이션 arg를 다음과 같이 결과가 나오도록 모두 출력하라.
/*  $ java -cp ... Test6 aaa bbb ccc ddd
    'aaa'
    'bbb'
    'ccc'
    'ddd'
*/

class Test6 {
    public static void main(int[] args) {
        System.out.println(args);
    }
}

/*
 * 1)
 * for (String arg : args) {
 * System.out.println("'" + arg + "'");
 * }
 * 
 * 2)
 * System.out.println(args[0]);
 * System.out.println(args[1]);
 * System.out.println(args[2]);
 * System.out.println(args[3]);
 */