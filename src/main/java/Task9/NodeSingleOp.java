package Task9;

import java.util.ArrayList;
import java.util.List;

public class NodeSingleOp implements Element {

  private SingleOp value;
  private List<Element> children = new ArrayList<>();

  public NodeSingleOp(String value) {
    this.value = Dictionary.getSingleArg(value);
  }

  @Override
  public void addChild(Element child) {
    children.add(child);
  }

  @Override
  public void accept(Visitor v) {
    System.out.print("[");
    v.visit(this);
    if (!children.isEmpty()) {
      System.out.print(",[");
      for (int i = 0; i < children.size(); i++) {
        Element child = children.get(i);
        child.accept(v);
        if (i + 1 < children.size()) {
          System.out.print(",");
        }
      }
      System.out.print("]");
    }
    System.out.print("]");
  }

  @Override
  public String getValue() {
    return Dictionary.getSingleArg(this.value);
  }
}
