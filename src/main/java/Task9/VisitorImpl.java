package Task9;

public class VisitorImpl implements Visitor {
  @Override
  public void visit(Element e) {
    System.out.print("\"" + e.getValue() + "\"");
  }
}
