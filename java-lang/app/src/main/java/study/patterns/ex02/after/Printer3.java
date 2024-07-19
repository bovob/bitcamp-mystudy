package study.patterns.ex02.after;

public class Printer3 {
  Printer2 origin;
  String footer;

  public Printer3(String header, String footer) {
    // Header를 알아야 함으로 바로 만들 수 없다.
    origin = new Printer2(header);
    this.footer = footer;
  }

  void print(String content) {
    origin.print(content);

    System.out.printf("=========[%s]\n", footer);
  }

}
