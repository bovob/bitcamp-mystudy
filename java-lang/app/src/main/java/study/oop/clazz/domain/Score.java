package study.oop.clazz.domain;

public class Score {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;


  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public int getEng() {
    return eng;
  }

  public int getMath() {
    return math;
  }

  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }

  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }

  public void setMath(int math) {
    this.math = math;
    this.compute();
  }

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
}
