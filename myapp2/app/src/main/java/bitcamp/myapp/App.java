/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String line = boldAnsi+ "----------------------------------------------" +resetAnsi;
        String title = boldAnsi+ "[팀 프로젝트 관리 시스템]" +resetAnsi;
        String[] menus = { "회원", "팀", "프로젝트", "게시판", "도움말", redAnsi+boldAnsi+"종료"+resetAnsi };

        Scanner scanner = new Scanner(System.in);

        System.out.println(line);
        System.out.println(title+"\n");
        for (int i = 0; i < menus.length ; i++) {
            System.out.println((i+1) + ". " + menus[i]);
        }
        System.out.println(line);


        while (true){
            System.out.print("> ");
            int menuNum = scanner.nextInt();
            switch (menuNum) {
                case 1:
                    System.out.println(menus[0] + "입니다.");
                    break;
                case 2:
                    System.out.println(menus[1] + "입니다.");
                    break;
                case 3:
                    System.out.println(menus[2] + "입니다.");
                    break;
                case 4:
                    System.out.println(menus[3] + "입니다.");
                    break;
                case 5:
                    System.out.println(menus[4] + "입니다.");
                    break;
                case 6:
                    System.out.println(menus[5] + "합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("유효하지 않은 번호입니다.");
            }
        }
    }
}
