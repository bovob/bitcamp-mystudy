package bitcamp.myapp;

import java.util.Scanner;

public class Test_SWITCH {
    public static void main(String[] args) {

        String line = "--------------------------------";
        String inputName = "입력하시오 > ";
        Scanner scan = new Scanner(System.in);

//        switch 예시 ex06_210~
        int company;

        System.out.print(inputName + "(1~3) 부서 : \n");
        company = scan.nextInt();

        String[] arrCompany = {"[지원부서]", "1. s/w 개발", "2. 일반관리", "3. 시설관리"};

        System.out.println(arrCompany[0]);
        switch (company) {
            case 1:
                System.out.println(arrCompany[1]);
                break;
            case 2:
                System.out.println(arrCompany[2]);
                break;
            case 3:
                System.out.println(arrCompany[3]);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
        System.out.println(line);

        int score;

        System.out.print(inputName + "점수 : \n");
        score = scan.nextInt();

        switch (score){                     // ( )<< 여기에 조건을 줘야함
            case 100:
            case 90:
                System.out.println("A");
            case 80:
            case 70:
            case 60:
                System.out.println("B");
            case 50:
            case 40:
            case 30:
                System.out.println("C");
            case 20:
            case 10:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
        }
        System.out.println(line);

        enum Level {GUEST, MEMBER, ADMIN}
        System.out.println(inputName+"Level : GUEST, MEMBER, ADMIN");

        Level level = Level.MEMBER;
        
        switch (level){
            case GUEST :
                System.out.println("게스트입니다.");
                break;
            case MEMBER:
                System.out.println("멤버입니다.");
                break;
            case ADMIN:
                System.out.println("어드민 입니다.");
                break;
        }
        System.out.println(line);
        scan.close();
    }
}