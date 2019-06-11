package task1;

public class Animal {
  int numberOfEyes;

  Animal(int numberOfEyes) {
    this.numberOfEyes = numberOfEyes;
  }

  @Override
  public String toString() {
    return "Animal{" + "numberOfEyes=" + numberOfEyes + '}';
  }

  void adHoc(Number n) {
    System.out.println("Number: " + n);
  }
}
