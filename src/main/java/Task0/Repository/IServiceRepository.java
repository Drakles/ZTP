package Task0.Repository;

import Task0.Models.Order;
import Task0.Models.Service;
import java.util.Collection;
import java.util.List;

public interface IServiceRepository extends IRepository<Service> {

  Collection<Integer> create(Order order);

  Integer create(Service service, Integer orderId);

  List<Service> readByOrderId(Integer id);
}
