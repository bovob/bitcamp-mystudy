package study.patterns.ex01.step6;

public class Sedan extends Car {
  boolean sunroof;
  boolean auto;



  @Override
  public String toString() {
    return "Sedan [sunroof=" + sunroof + ", auto=" + auto + ", maker=" + maker + ", model=" + model
        + ", cc=" + cc + "]";
  }

  protected Sedan() {}

  @Override
  protected void start() {
    System.out.printf("%s 시동건다!\n", this.model);
  }

  @Override
  protected void run() {
    System.out.printf("%s %s 하고 달린다!\n", this.model, this.sunroof ? "선루프 열고" : "선루프 닫고");
  }

  @Override
  protected void stop() {
    System.out.printf("%s 시동끈다!", this.model);
  }

  public static Sedan create(String model) {
    Sedan s = new Sedan();

    switch (model) {
      case "소나타":
        s.maker = "현대자동차";
        s.model = "소나타";
        s.cc = 1998;
        s.auto = true;
        s.sunroof = false;
        break;
      case "K7":
        s.maker = "기아자동차";
        s.model = "K7";
        s.cc = 2500;
        s.auto = true;
        s.sunroof = true;
        break;
    }
    return s;

  }
}
