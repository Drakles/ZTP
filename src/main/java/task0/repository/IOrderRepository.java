package task0.repository;

import task0.models.Order;

public interface IOrderRepository extends IRepository<Order> {
  Integer create();
}
