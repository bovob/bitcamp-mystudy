package bitcamp.myapp;

import java.util.Scanner;

public class App {

    //문자열 입력
    static Scanner keyboardScanner = new Scanner(System.in);

    //문자값
    static String boldAnsi = "\033[1m";
    static String redAnsi = "\033[31m";
    static String resetAnsi = "\033[0m";
    static String line = "----------------------------------";

    //Menu 배열
    static String[] mainMenus = new String[]{"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
    static String[][] subMenus = {
        {"회원등록", "목록", "조회", "변경", "삭제"},
        {"팀등록", "목록", "조회", "변경", "삭제"},
        {"프로젝트등록", "목록", "조회", "변경", "삭제"},
        {"게시판등록", "목록", "조회", "변경", "삭제"},
    };

    public static void main(String[] args) {

        printMenu(); // 메서드에 묶인 코드를 실행하는 것을 "메서드를 호출(call)한다"라고 부른다.

        String command;
        while (true) {
            try {
                command = prompt("메인");

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo, mainMenus); // 설명하는 변수
                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else {
                        if (menuNo >= 1 && menuNo <= 4) {
                            processMenu(menuTitle, subMenus[menuNo - 1]);
                        } else {
                            System.out.println(menuTitle);
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        keyboardScanner.close();
    }

    //입력받기
    static String prompt(String title) {
        System.out.printf("%s> ", title);
        return keyboardScanner.nextLine();
    }

    //메뉴정합성
    static boolean isValidateMenu(int menuNo, String[] menus) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    //메뉴타이틀 반환
    static String getMenuTitle(int menuNo, String[] menus) {
        return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
    }

    //메인메뉴
    static void printMenu() {
        String appTitle = "[팀 프로젝트 관리 시스템]";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < mainMenus.length; i++) {
            if (mainMenus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i],
                    resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    //서브메뉴
    static void printSubMenu(String menuTitle, String[] menus) {
        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + "[" + menuTitle + "]" + resetAnsi);

        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.print(boldAnsi + redAnsi + "9. 이전\n" + resetAnsi);
        System.out.println(boldAnsi + line + resetAnsi);
    }

    //서브메뉴 프로세스
    static void processMenu(String menuTitle, String[] menus) {
        printSubMenu(menuTitle, menus);

        while (true) {
            String command = prompt("메인/" + menuTitle);
            if (command.equals("menu")) {
                printSubMenu(menuTitle, menus);
//                continue;
            } else if (command.equals("9")) {   // 이전
                break;
            }
            try {
                int menuNo = Integer.parseInt(command);
                String subMenuTitle = getMenuTitle(menuNo, menus);
                if (subMenuTitle == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                } else {
                    System.out.println(subMenuTitle);
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }
}




