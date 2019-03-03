package Task0.Models;

import java.util.Collection;

public class Order extends Entity {
  private Purchaser purchaser;
  private Collection<Service> services;

  public Order(Purchaser purchaser, Collection<Service> services) {
    super();
    this.purchaser = purchaser;
    this.services = services;
  }

  public Purchaser getPurchaser() {
    return purchaser;
  }

  public Collection<Service> getServices() {
    return services;
  }

  @Override
  public String toString() {
    return "Order{" +
        "purchaser=" + purchaser +
        ", services=" + services +
        '}';
  }
}
