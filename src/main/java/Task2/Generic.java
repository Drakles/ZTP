package Task2;

public class Generic<T> {
  private final T field;

  public Generic(T field) {
    this.field = field;
  }

  public T getField() {
    return field;
  }

  @Override
  public String toString() {
    return "Generic{" +
        "field=" + field +
        '}';
  }
}