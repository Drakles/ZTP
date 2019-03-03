package Task0.Repository;

import Task0.Models.Order;
import Task0.Models.Purchaser;

public interface IPurchaserRepository extends IRepository<Purchaser> {

  void create(Order order);
  void create(Purchaser purchaser, Integer orderId);

  Purchaser readByOrderId(Integer orderId);
}
