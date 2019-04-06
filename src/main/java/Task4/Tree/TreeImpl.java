package Task4.Tree;

public class TreeImpl implements Tree {
  private final int width;
  private final TreeType type;

  TreeImpl(int width, TreeType type) {
    this.width = width;
    this.type = type;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public TreeType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "TreeImpl{" + "width=" + width + ", type=" + type + '}';
  }
}
