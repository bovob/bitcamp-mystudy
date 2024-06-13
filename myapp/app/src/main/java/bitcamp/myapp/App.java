package bitcamp.myapp;

import java.util.Scanner;

public class App {

    //  Scanner
    static Scanner keyboardScanner = new Scanner(System.in);

    //  메인메뉴 목록
    static String[] menusMain = new String[]{
        "회원",
        "팀",
        "프로젝트",
        "게시판",
        "도움말",
        "종료"
    };

    //  내부메뉴 목록
    static String[] menusSub = new String[]{
        "등록",
        "목록",
        "조회",
        "변경",
        "삭제",
        "이전"
    };

    public static void main(String[] args) {

        printMenu(); // 메서드에 묶인 코드를 실행하는 것을 "메서드를 호출(call)한다"라고 부른다.

        String command;

        while (true) {
            try {
                command = prompt();

                if (command.equals("menu")) {
                    printMenu();
                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo); // 설명하는 변수
                    if (menuTitle == null) {
                        System.out.println("M유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else if (menuNo == 5) {
                        System.out.printf("%s\n", menuTitle);
                    } else {
                        // sub
                        printMenuSub(menuTitle);
                        while (true) {
                            try {
                                String commandSub = promptSub(menuTitle);
                                if (commandSub.equals("menu")) {
                                    printMenuSub(menuTitle);
                                } else {
                                    int menuNoSub = Integer.parseInt(commandSub);
                                    if (isValidateMenuSub(menuNoSub)) {
                                        System.out.println(getMenuTitleSub(menuNoSub));
                                    } else if (menuNoSub == 9) {
                                        break;
                                    } else {
                                        System.out.println("S유효한 메뉴 번호가 아닙니다.");
                                    }
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("S숫자로 메뉴 번호를 입력하세요.");
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("M숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        keyboardScanner.close();
    }


    // Main menu
    static void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < menusMain.length; i++) {
            if (menusMain[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menusMain[i],
                    resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menusMain[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    // Sub menu
    static void printMenuSub(String menuTitle) {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.printf(boldAnsi + "[%s]" + resetAnsi + "\n", menuTitle);

        for (int i = 0; i < menusSub.length; i++) {
            if (menusSub[i].equals("이전")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), 9, menusSub[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menusSub[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    static String prompt() {
        System.out.print("메인 > ");
        return keyboardScanner.nextLine();
    }

    static String promptSub(String menuTitle) {
        System.out.printf("메인/%s > ", menuTitle);
        return keyboardScanner.nextLine();
    }

    static boolean isValidateMenu(int menuNo) {
        return menuNo >= 1 && menuNo <= menusMain.length;
    }

    static boolean isValidateMenuSub(int menuNoSub) {
        return menuNoSub >= 1 && menuNoSub <= (menusSub.length - 1);
    }

    static String getMenuTitle(int menuNo) {
        return isValidateMenu(menuNo) ? menusMain[menuNo - 1] : null;
    }

    
    static String getMenuTitleSub(int menuNo) {
        return isValidateMenu(menuNo) ? menusSub[menuNo - 1] : null;
    }


}

