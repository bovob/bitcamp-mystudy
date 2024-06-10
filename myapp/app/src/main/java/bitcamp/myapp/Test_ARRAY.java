package bitcamp.myapp;

public class Test_ARRAY {
    public static void main(String[] args) {

        String line = "--------------------------------";
        String inputName = "입력하시오 > ";

//        배열 예시 ex04_510~
        int[] arr1 = new int[5];
        arr1[0] = 100;
        arr1[1] = 100;
        arr1[2] = 100;
        arr1[3] = 100;
        arr1[4] = 100;
        System.out.println(arr1[0]);

        String[] arr2 = new String[5]; // String arr2[]로도 가능

        float[] arr3;
//        arr3 = {1,2,3}; 바로 초기화 불가능

        char[] arr4;
        arr4 = new char[]{1,2,'3','4',+5}; // 바로 초기화 가능

//        boolean[] arr5; 참고예시
//        Object[] arr6;
        System.out.println(line);
        for (int i=0; i<arr4.length;i++){
            System.out.println(arr4[i]);
        }
        System.out.println(line);
    }
}
