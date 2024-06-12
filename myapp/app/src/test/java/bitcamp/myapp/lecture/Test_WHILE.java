package bitcamp.myapp.lecture;

public class Test_WHILE {
    public static void main(String[] args) {

        String line = "--------------------------------";
        String inputName = "입력하시오 > ";

//        while 예시 ex06_310~
        int count = 0;
        while (count <5) System.out.println(count++);

        System.out.println(line);
        
        count = 0;
        int sum = 0;
        while (count < 10){
            count++;
            if((count & 1)==0){
                sum+=count;
            }
        }
        System.out.println("사용전 카운트: " + count + " SUM : " +sum);


        count = 0;
        sum = 0;
        while (count < 10){
            count++;
            if((count % 2)==0){
                continue;
//                sum+=count; 도달할 수 없는 구문오류
            }
        }
        System.out.println("사용후 카운트: " + count + " SUM : " +sum);

        System.out.println(line);

        int x=2, y=1;

        myloop:
        while(x<=9){
            while(y<=9){
                System.out.printf("%d * %d = %d \n", x, y, x*y);
                if(x==5 && y==5)
                    break myloop;
                y++;
            }

            System.out.println();
            x++;
            y=1;
        }
        System.out.println("종료!");
        System.out.println(line);
    }
}