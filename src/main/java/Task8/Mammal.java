package Task8;

public class Mammal extends Animal {
  int numberOfLimbs;

  Mammal(int numberOfEyes, int numberOfLimbs) {
    super(numberOfEyes);
    this.numberOfLimbs = numberOfLimbs;
  }

  @Override
  public String toString() {
    return "Mammal{" + "numberOfLimbs=" + numberOfLimbs + ", numberOfEyes=" + numberOfEyes + '}';
  }
}
