package bitcamp.myapp.lecture;

import java.util.Scanner;

public class Test_IF {
    public static void main(String[] args) {
//        if 예시 ex06_110~
        int age;
        String line = "--------------------------------";
        String inputName = "입력하시오 > ";

        Scanner scan = new Scanner(System.in);

        System.out.print(inputName + "(1번) \n");
        age = scan.nextInt();
        System.out.println(line);
        if (age >= 19) System.out.println("1. 성인이다.") ;
        System.out.println(line);

        if (age >= 19) {
            System.out.println("2. 성인이다.");
        } else {
            System.out.println("2. 미성년이다.");
        }
        System.out.println(line);

        int age2;

        System.out.print(inputName + "(2번) \n");
        age2 = scan.nextInt();

        if (age >= 19) {
            if(age >= 70) {
                System.out.println("3. 무료승차");
            }
        else {
                System.out.println("3. 미성년이다.");
            }
        }

        int age3;

        System.out.print(inputName + "(3번) \n");
        age3 = scan.nextInt();

        System.out.println(line);

        if (age3 >= 90){
            System.out.println("4. IF");
        } else if (age3 <= 18){
            System.out.println("4. Else IF");
        } else {
            System.out.println("4. Else");
        }
        scan.close();
    }
}