/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // ANSI 이스케이프 문자
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        // Title & Line
        String appTitle = boldAnsi + "[팀 프로젝트 관리 시스템]" + resetAnsi;
        String line = boldAnsi + "----------------------------------------------" + resetAnsi;

        // Menu
        String menu1 = "회원";
        String menu2 = "팀";
        String menu3 = "프로젝트";
        String menu4 = "게시판";
        String menu5 = "도움말";
        String menu6 = boldAnsi + redAnsi + "종료" + resetAnsi;

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Print
        System.out.println(line);
        System.out.println(appTitle + "\n");
        System.out.println("1. " + menu1);
        System.out.println("2. " + menu2);
        System.out.println("3. " + menu3);
        System.out.println("4. " + menu4);
        System.out.println("5. " + menu5);
        System.out.println("6. " + menu6);
        System.out.println(line);

        while (true) {
            System.out.print("> ");  // Prompt for user input

            // Int scan
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println(menu1 + "입니다.");
            } else if (choice == 2) {
                System.out.println(menu2 + "입니다.");
            } else if (choice == 3) {
                System.out.println(menu3 + "입니다.");
            } else if (choice == 4) {
                System.out.println(menu4 + "입니다.");
            } else if (choice == 5) {
                System.out.println(menu5 + "입니다.");
            } else if (choice == 6) {
                System.out.println("종료합니다.");
                break;
            } else {
                System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
        scanner.close();  // Close the scanner
    }
}