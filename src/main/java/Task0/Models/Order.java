package Task0.Models;

import java.util.Collection;

public class Order extends Entity {
  private Purchaser purchaser;
  private Collection<Service> services;

  public Order(Integer id, Purchaser purchaser, Collection<Service> services) {
    super(id);
    this.purchaser = purchaser;
    this.services = services;
  }

  public Order(Purchaser purchaser, Collection<Service> services) {
    this.purchaser = purchaser;
    this.services = services;
  }

  public Order(Integer id) {
    super(id);
  }

  public void setPurchaser(Purchaser purchaser) {
    this.purchaser = purchaser;
  }

  public void setServices(Collection<Service> services) {
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
    return "Order{"
        + "id= "
        + getId()
        + '\''
        + ", purchaser = "
        + purchaser
        + ", services = "
        + services
        + "}\n";
  }
}
