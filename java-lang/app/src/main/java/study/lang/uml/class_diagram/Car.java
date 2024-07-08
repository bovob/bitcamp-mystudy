package study.lang.uml.class_diagram;

public class Car {
  Insurance insurance;
  Navigation Navigation;
  Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public Navigation getNavigation() {
    return Navigation;
  }

  public void setNavigation(Navigation navigation) {
    Navigation = navigation;
  }

  public Engine getEngine() {
    return engine;
  }
}
