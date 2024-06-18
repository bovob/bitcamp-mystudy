package testcamp.myapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // 스캐너
    static Scanner keyboardScanner = new Scanner(System.in);

    // bold 처리용 Ansi 값
    static String boldAnsi = "\033[1m";
    static String redAnsi = "\033[31m";
    static String resetAnsi = "\033[0m";

    // 메뉴를 나타내는 변수
    static String line = boldAnsi + "------------------------------------" + resetAnsi;
    static String appTitle = "[프로젝트 관리 시스템]";
    static String[] menus = new String[]{"회원", "프로젝트", "게시판", "도움말", "종료"};

    public static void main(String[] args) {
        printMainMenus();

        // 입력 값 
        String command;

        while (true) {
            // 예외처리 숫자가 아닌 값입력시
            try {
                // 입력받은 값 String에 저장
                command = prompt();

                // 메인메뉴 출력하기
                if (command.equals("menu")) {
                    printMainMenus();
                }

                // 입력값 Int 변화
                int menuNo = Integer.parseInt(command);

                // 메뉴타이틀이 아닐시
                if (getMenuTitle(menuNo) == null) {
                    System.out.println("유효한 번호를 입력하세요.");
                } else if (menus[menuNo - 1].equals("종료")) { // 종료
                    break;
                } else { // 메뉴출력
                    System.out.println(menus[menuNo - 1]);
                }

                // 예외처리 숫자가 아닐시 InputMismatchException
            } catch (InputMismatchException | NumberFormatException exception_command) {
                System.out.println("숫자로 번호를 입력하세요.");
            }
        }
        System.out.println("종료합니다.");

        keyboardScanner.close();
    }

    static String getMenuTitle(int menuNo) {
        // 설명하는 변수 메뉴번호 받아서 타이틀 출력 메서드
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    static boolean isValidateMenu(int menuNo) {
        // 메뉴번호 1~배열크기 사이 확인 메서드
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static String prompt() {
        // 값을 입력받는 메서드
        System.out.print("> ");
        return keyboardScanner.nextLine();
    }

    static public void printMainMenus() {
        // 메뉴를 반복해서 출력하는 메서드
        System.out.println(line);
        System.out.println(appTitle);
        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals("종료")) {     // 종료만 Ansi bold+red 처리
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i],
                    resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }
        System.out.println(line);

    }
}
