package task0.repository;

import task0.models.Order;
import task0.models.Service;
import java.util.Collection;
import java.util.List;

public interface IServiceRepository extends IRepository<Service> {

  Collection<Integer> create(Order order);

  Integer create(Service service, Integer orderId);

  List<Service> readByOrderId(Integer id);
}
