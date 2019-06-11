package task9;

public interface Element {
  void accept(Visitor v);

  String getValue();

  void addChild(Element e);
}
