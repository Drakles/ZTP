package Task8;

public class Animal implements Visible{
  int numberOfEyes;

  Animal(int numberOfEyes) {
    this.numberOfEyes = numberOfEyes;
  }

  @Override
  public String toString() {
    return "Animal{" + "numberOfEyes=" + numberOfEyes + '}';
  }

}
