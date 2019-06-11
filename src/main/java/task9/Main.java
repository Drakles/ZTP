package task9;

public class Main {

  public static void main(String[] args) {
    Element parent = new NodeOperatorTwoArgs("*");
    Element child1 = new NodeOperatorTwoArgs("+");
    Element child2 = new NodeNumber(5);

    parent.addChild(child1);
    parent.addChild(child2);

    child1.addChild(new NodeNumber(3));
    child1.addChild(new NodeNumber(4));

    Visitor v = new VisitorImpl();
    parent.accept(v);
  }
}
