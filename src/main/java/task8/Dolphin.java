package task8;

public class Dolphin extends Mammal implements Loudable {
  Dolphin(int numberOfEyes, int numberOfLimbs) {
    super(numberOfEyes, numberOfLimbs);
  }

  @Override
  public String toString() {
    return "Dolphin{" + "numberOfLimbs=" + numberOfLimbs + ", numberOfEyes=" + numberOfEyes + '}';
  }
}
