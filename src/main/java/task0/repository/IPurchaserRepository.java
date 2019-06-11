package task0.repository;

import task0.models.Order;
import task0.models.Purchaser;

public interface IPurchaserRepository extends IRepository<Purchaser> {

  Integer create(Order order);

  Integer create(Purchaser purchaser, Integer orderId);

  Purchaser readByOrderId(Integer orderId);
}
