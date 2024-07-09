package testcamp.myapp.util;

import java.util.Scanner;

public class Prompt {

    static Queue inputQueue = new Queue();

    static Scanner keyboardScanner = new Scanner(System.in);

    public static String input(String format, Object... args) {
        String promptTitle = String.format(format + " ", args);

        System.out.printf(promptTitle);

        String input = keyboardScanner.nextLine();
        if (format.endsWith(">")) {
            inputQueue.offer(promptTitle + input);
        }
        return input;
    }

    public static int inputInt(String format, Object... args) {
        return Integer.parseInt(input(format, args));
    }

    public static void close() {
        keyboardScanner.close();
    }
}
