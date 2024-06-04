public class Test6 {
    public static void main(String[] args) {
        System.out.println("ABC\nabc\n012\n가각간\n똘똠똥\n"); // 41 42 43 0A 61 62 63 0A 30 31 32 0A EA B0 80 EA B0 81 ....
        System.out.println('Y'); // 59
        System.out.println('간'); // AC 04
        System.out.println('8'); // 38
        System.out.println(1234); // 2의 보수로 인코딩된 것을 확인한다. => 04 D2
        System.out.println(-1234); // 2의 보수로 인코딩된 것을 확인한다. => FB 2E
        System.out.println(12.375f); // 부동소수점이 메모리에 저장될 때 2진수로 바뀌는 것을 확인한다. => 41 46 00 00
        System.out.println(true);
        System.out.println(false);
    }
}
