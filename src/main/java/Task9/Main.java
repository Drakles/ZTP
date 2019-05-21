package Task9;

public class Main {

  public static void main(String[] args) {
    Node parent = new Node("*");
    Node child1 = new Node("+");
    Node child2 = new Node("5");

    parent.addChild(child1);
    parent.addChild(child2);

    child1.addChild(new Node("3"));
    child1.addChild(new Node("4"));

    Visitor v = new VisitorImpl();
    parent.accept(v);
  }
}
