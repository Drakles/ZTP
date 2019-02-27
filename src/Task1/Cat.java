package Task1;

public class Cat extends Mammal {
  private int lengthOfTail;

  Cat(int numberOfEyes, int numberOfLimbs, int lengthOfTail) {
    super(numberOfEyes, numberOfLimbs);
    this.lengthOfTail = lengthOfTail;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "lengthOfTail=" + lengthOfTail +
        ", numberOfLimbs=" + numberOfLimbs +
        ", numberOfEyes=" + numberOfEyes +
        '}';
  }

  void adHoc(Integer i){
    System.out.println("Integer: "+i);
  }
}
