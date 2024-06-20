package testcamp.myapp.command;

import testcamp.myapp.vo.User;

public class UserCommand {

    // 유저를 담을 배열 선언
    public static int MAX_SIZE = 100;
    public static User[] users = new User[MAX_SIZE];
    // 유저 index index용
    public static int userLength = 0;


    // 실질적으로 실행
    public static void executeUserCommand(String command) {
        // 메뉴 출력
        System.out.printf("[%s]\n", command);

        switch (command) {
            case "등록":
                addUser();
                break;
            case "조회":
                viewUser();
                break;
            case "목록":
                listUser();
                break;
            case "변경":
                updateUser();
                break;
            case "삭제":
                deleteUser();
                break;

        }

    }

    private static void addUser() {
        System.out.println("유저추가");
    }

    private static void viewUser() {
        System.out.println("유저조회");
    }

    private static void listUser() {
        System.out.println("유저목록");
    }

    private static void updateUser() {
        System.out.println("유저변경");
    }

    private static void deleteUser() {
        System.out.println("유저삭제");
    }

}
