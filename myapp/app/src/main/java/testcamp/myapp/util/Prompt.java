package testcamp.myapp.util;

import java.util.Scanner;

public class Prompt {

    // 스캐너
    static Scanner keyboardScanner = new Scanner(System.in);

    public static String input(String title) {
        // 값을 입력받는 메서드
        System.out.printf("%s> ", title);
        return keyboardScanner.nextLine();
    }

    public static void close() {
        keyboardScanner.close();
    }
}
