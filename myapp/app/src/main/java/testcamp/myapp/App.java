package testcamp.myapp;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Stack;
import testcamp.myapp.command.Command;
import testcamp.myapp.command.UserCommand;
import testcamp.myapp.util.Prompt;

public class App {


    String[] menus = new String[]{"회원", "프로젝트", "게시판", "공지사항", "도움말", "종료"};
    Stack menuPath = new Stack();

    Map<String, Command> commandMap = new HashMap<>();

    public App() {
        LinkedList userList = new LinkedList();
        commandMap.put("회원", new UserCommand("회원", userList));
    }


    public static void main(String[] args) {
        new App().execute();
    }

    void execute() {
        printMenu();

        String command;
        while (true) {
            try {
                command = Prompt.input("%s>", getMenuPathTitle(menuPath));

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo); // 설명하는 변수
                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else {
                        processMenu(menuTitle);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        Prompt.close();
    }

    private boolean isValidateMenu(int menuNo) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    private String getMenuTitle(int menuNo) {
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[프로젝트 관리 시스템]";
        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i],
                    resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    void processMenu(String menuTitle) {
        Command command = commandMap.get(menuTitle);
        if (command == null) {
            System.out.printf("%s 메뉴의 명령을 처리할 수 없습니다.\n", menuTitle);
            return;
        }
        command.execute();
    }

    private String getMenuPathTitle(Stack menuPath) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < menuPath.size(); i++) {
            if (str.length() > 0) {
                str.append("/");
            }
            str.append(menuPath.get(i));
        }
        return str.toString();
    }
}
