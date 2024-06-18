package testcamp.myapp;

import java.util.InputMismatchException;
import testcamp.myapp.util.Prompt;

public class App {


    // bold 처리용 Ansi 값
    static String boldAnsi = "\033[1m";
    static String redAnsi = "\033[31m";
    static String resetAnsi = "\033[0m";

    // 메뉴를 나타내는 변수
    static String line = boldAnsi + "------------------------------------" + resetAnsi;
    static String appTitle = "[프로젝트 관리 시스템]";
    static String[] mainMenus = new String[]{"회원", "프로젝트", "게시판", "도움말", "종료"};

    // 서브 메뉴를 나타내는 변수
    static String[][] subMenus = {{"회원등록", "목록", "조회", "변경", "삭제"},
                                  {"프로젝트등록", "목록", "조회", "변경", "삭제"},
                                  {"게시판등록", "목록", "조회", "변경", "삭제"}};

    public static void main(String[] args) {
        printMainMenus();

        // 입력 값 
        String command;

        while (true) {
            // 예외처리 숫자가 아닌 값입력시
            try {
                // 입력받은 값 String에 저장
                command = Prompt.input("메인");

                // 메인메뉴 다시 출력하기
                if (command.equals("menu")) {
                    printMainMenus();
                }

                // 입력값 Int 변환
                int menuNo = Integer.parseInt(command);

                // 설명하는 변수 (메뉴번호, 메뉴배열)
                String menuTitle = getMenuTitle(menuNo, mainMenus);

                // 메뉴타이틀이 아닐시
                if (menuTitle == null) {
                    System.out.println("유효한 번호를 입력하세요.");
                } else if (menuTitle.equals("종료")) { // 종료
                    break;
                } else {
                    if (menuNo < (mainMenus.length - 1)) {
                        // 서브메뉴 처리
                        processMenu(menuTitle, subMenus[menuNo - 1]);
                    } else {
                        // 도움말 같은 서브배열 없는애들
                        System.out.println(menuTitle + "\n" + line);
                    }
                }

                // 예외처리 숫자가 아닐시 InputMismatchException
            } catch (InputMismatchException | NumberFormatException exception_command) {
                System.out.println("숫자로 번호를 입력하세요.");
            }
        }
        System.out.println("종료합니다.");


    }


    static String getMenuTitle(int menuNo, String[] menus) {
        // 설명하는 변수 메뉴번호 받아서 타이틀 출력 메서드
        return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
    }

    static boolean isValidateMenu(int menuNo, String[] menus) {
        // 메뉴번호 1~배열크기 사이 확인 메서드
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static public void printMainMenus() {
        // 메뉴를 반복해서 출력하는 메서드
        System.out.println(line);
        System.out.println(appTitle);
        for (int i = 0; i < mainMenus.length; i++) {
            if (mainMenus[i].equals("종료")) {     // 종료만 Ansi bold+red 처리
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i],
                    resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
            }
        }
        System.out.println(line);

    }

    static public void printSubMenus(String menuTitle, String[] menus) {
        // 서브메뉴 출력
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        // 서브메뉴 나가기
        System.out.println("9. 이전\n" + line);
    }

    static public void processMenu(String menuTitle, String[] menus) {
        // 서브메뉴 출력
        printSubMenus(menuTitle, menus);
        while (true) {
            String command = Prompt.input("메인/" + menuTitle);
            // 서브메뉴 다시 출력하기
            if (command.equals("menu")) {
                printSubMenus(menuTitle, menus);
            } else if (command.equals("9")) {
                break;  // 이전
            }
            try {
                // 서브입력 받기
                int menuNo = Integer.parseInt(command);
                String subMenuTitle = getMenuTitle(menuNo, menus);
                if (subMenuTitle == null) {
                    System.out.println("유효한 번호를 입력하세요.");
                } else {
                    System.out.println(subMenuTitle);
                }

            } catch (InputMismatchException | NumberFormatException exception_command) {
                System.out.println("숫자로 번호를 입력하세요.");
            }
        }
    }
}
