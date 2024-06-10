/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;
import java.util.InputMismatchException;
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
        String[] menus = new String[]{
                "회원",
                "팀",
                "프로젝트",
                "게시판",
                "도움말",
                "종료",
                "테스트"};

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Print
        System.out.println(line);
        System.out.println(appTitle + "\n");

        for (int i = 0; i < menus.length; i++){

            if (menus[i] == "종료"){
                System.out.printf("%s%d. %s%s \n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }


        System.out.println(line);

        int menuNo;
        while (true) {
            System.out.print("> ");  // Prompt for user input
//            String input = scanner.nextLine();
//              int input = scanner.nextInt();
            try {
//                menuNo = Integer.parseInt(input);
                menuNo = scanner.nextInt();
                if (menuNo >= 1 && menuNo <= menus.length) {
                    if (menus[menuNo - 1] == "종료") {
                        break;
                    }
                    System.out.println(menus[menuNo - 1]);
                } else {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                }
//            } catch (NumberFormatException e){
//                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
//            }

            } catch (InputMismatchException e){
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
                System.out.println("Exception Error : ");
                e.printStackTrace();
                scanner.next();
            }
        }
        System.out.println("종료합니다.");
        scanner.close();  // Close the scanner
    }
}