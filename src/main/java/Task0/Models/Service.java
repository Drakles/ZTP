package Task0.Models;

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
    return "Service{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
