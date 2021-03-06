package task0.models;

public class Service extends Entity {
  private String name;
  private Double price;

  public Service(Integer id, String name, Double price) {
    super(id);
    this.name = name;
    this.price = price;
  }

  public Service(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Service{"
        + "id= "
        + getId()
        + '\''
        + ", name='"
        + name
        + '\''
        + ", price="
        + price
        + "}\n";
  }
}
