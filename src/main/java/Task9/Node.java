package Task9;

import java.util.ArrayList;
import java.util.List;

public class Node implements Element {

  private String value;
  private List<Node> children = new ArrayList<>();

  public Node(String value) {
    this.value = value;
  }

  public void addChild(Node child) {
    children.add(child);
  }

  @Override
  public void accept(Visitor v) {
    System.out.print("[");
    v.visit(this);
    if (!children.isEmpty()) {
      System.out.print(",[");
      for (int i = 0; i < children.size(); i++) {
        Node child = children.get(i);
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
    return this.value;
  }
}
