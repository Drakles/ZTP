package Task0.Models;

import java.math.BigDecimal;

public class Service {
private String name;
private BigDecimal price;

  public Service(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
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
