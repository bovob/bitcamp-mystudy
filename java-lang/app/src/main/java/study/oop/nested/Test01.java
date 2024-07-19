package study.oop.nested;

public class Test01 {

  interface Printer {
    void print();
  }

  public static void main(String[] args) {

    // 1
    // class PrinterImpl implements Printer {
    // @Override
    // public void print() {
    // System.out.println(" H e l l o !");
    // }
    // }
    //
    // Printer obj = new PrinterImpl();
    // obj.print();


    // 2
    // Printer obj = new Printer(){
    // @Override
    // public void print() {
    // System.out.println(" H e l l o !");
    // }
    // };
    // obj.print();


    // 3
    // new Printer(){
    // @Override
    // public void print() {
    // System.out.println(" H e l l o !");
    // }
    // }.print();

    Printer obj = new Printer() {
      @Override
      public void print() {
        System.out.println("Hello!");
      }
    };


  }
}
