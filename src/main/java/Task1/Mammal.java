package Task1;

public class Mammal extends Animal {
  int numberOfLimbs;

  Mammal(int numberOfEyes, int numberOfLimbs) {
    super(numberOfEyes);
    this.numberOfLimbs = numberOfLimbs;
  }

  @Override
  public String toString() {
    return "Mammal{" +
        "numberOfLimbs=" + numberOfLimbs +
        ", numberOfEyes=" + numberOfEyes +
        '}';
  }

  void adHoc(Float f){
    System.out.println("Float: " +f);
  }
}
