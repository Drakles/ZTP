package task2;

public class Pair<T> implements Cloneable {
  private T first;
  private T second;

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return "Pair{" + "first=" + first + ", second=" + second + '}';
  }

  @Override
  protected Pair<T> clone() throws CloneNotSupportedException {
    return (Pair<T>) super.clone();
  }
}
