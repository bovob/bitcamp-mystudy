package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.util.Stack;

public abstract class AbstractCommand implements Command {

    protected String menuTitle;

    public AbstractCommand(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    protected abstract String[] getMenus();

    protected abstract void processMenu(String menuName);

    private String getMenuPath(Stack menuPath) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < menuPath.size(); i++) {
            if (strBuilder.length() > 0) {
                strBuilder.append("/");
            }
            strBuilder.append(menuPath.get(i));
        }
        return strBuilder.toString();

        // 기존
        //String title = "";
        //for (int i = 0; i < menuPath.size(); i++) {
        //    if (title.length() > 0) {
        //        title += "/";
        //    }
        //}
        //return title;
    }

    boolean isValidateMenu(int menuNo) {
        String[] menus = getMenus();
        return menuNo >= 1 && menuNo <= menus.length;
    }

    String getMenuTitle(int menuNo) {
        String[] menus = getMenus();
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    void printSubMenu() {
        String[] menus = getMenus();
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.println("9. 이전");
    }


    public void execute(Stack menuPath) {
        menuPath.push(menuTitle);
        printSubMenu();
        while (true) {
            String command = Prompt.input(String.format("%s>", getMenuPath(menuPath)));
            if (command.equals("menu")) {
                printSubMenu();
                continue;
            } else if (command.equals("9")) { // 이전 메뉴 선택
                menuPath.pop();
                return;
            }

            try {
                int menuNo = Integer.parseInt(command);
                String subMenuTitle = getMenuTitle(menuNo);
                if (subMenuTitle == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                }
                System.out.printf("[%s]\n", subMenuTitle);
                processMenu(subMenuTitle);
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }
}
