package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

    static Scanner keyboardScanner = new Scanner(System.in);

    static void close() {
        keyboardScanner.close();
    }

    static String input(String title) {
        System.out.printf("%s ", title);
        return keyboardScanner.nextLine();
    }
}
