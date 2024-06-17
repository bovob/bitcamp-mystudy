package bitcamp.study.oop;

public class Score {

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        this.compute();
    }

    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = (float) this.sum / 3;
    }

    public void setName 
}
