package bitcamp.myapp;
import java.util.Scanner;

public class App {
    static Scanner keyboardScanner = new Scanner(System.in);

    static String[] menus = new String[] {
        "회원",
        "팀",
        "프로젝트",
        "게시판",
        "도움말",
        "종료"
    };

    public static void main(String[] args) {
        menuList();
        String command;

        while (true) {
            try {


                command = prompt();
                int menuNo = Integer.parseInt(command);

                if (command.equals("menu")) {
                    menuList();
                } else {





                    if (isValidateMenu(menuNo)) {
                        if (getMenuTitle(menuNo).equals("종료")) {
                            break;
                        }
                        System.out.println(getMenuTitle(menuNo));


                    } else {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    }
                }



            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        keyboardScanner.close();
    }

    static void menuList(){
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }
        System.out.println(boldAnsi + line + resetAnsi);
    }

    static String prompt(){
        System.out.print("> ");
        String command = keyboardScanner.nextLine();
        return command;
    }

    static boolean isValidateMenu(int menuNo){
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static String getMenuTitle(int menuNo){
        if(isValidateMenu(menuNo)){
            return menus[menuNo - 1];
        }
        return null;
    }
}
