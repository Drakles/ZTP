package Task0.Repository;

import Task0.Models.Order;

public interface IOrderRepository extends IRepository<Order> {
  Integer create();
}
