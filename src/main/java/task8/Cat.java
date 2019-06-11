package task8;

public class Cat extends Mammal implements Loudable {
  private int lengthOfTail;

  Cat(int numberOfEyes, int numberOfLimbs, int lengthOfTail) {
    super(numberOfEyes, numberOfLimbs);
    this.lengthOfTail = lengthOfTail;
  }

  @Override
  public String giveVoice() {
    return "miau";
  }

  @Override
  public String toString() {
    return "Cat{"
        + "lengthOfTail="
        + lengthOfTail
        + ", numberOfLimbs="
        + numberOfLimbs
        + ", numberOfEyes="
        + numberOfEyes
        + '}';
  }
}
