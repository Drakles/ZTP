package Task0.Repository;

import Task0.Models.Order;
import Task0.Models.Purchaser;
import Task0.Models.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

  private static final PurchaserRepository purchaserRepository = new PurchaserRepository();
  private static final ServiceRepository serviceRepository = new ServiceRepository();

  public Integer create(Order order) {
    String query = "INSERT INTO Orders (orderId) VALUE ();";

    Integer result = null;
    try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
      int rows = st.executeUpdate(query);
      if (rows == 1) {
        ResultSet res = st.getGeneratedKeys();
        if (res.next()) {
          result = res.getInt(1);
        }
      }

    } catch (SQLException e) {
      System.out.println(e);
    }

    order.getPurchaser().setId(purchaserRepository.create(order));
    Collection<Integer> servicesId = serviceRepository.create(order);
    if (servicesId.size() == order.getServices().size()) {
      Iterator<Integer> itServiceId = servicesId.iterator();
      Iterator<Service> serviceIterator = order.getServices().iterator();
      while (itServiceId.hasNext()) {
        serviceIterator.next().setId(itServiceId.next());
      }
    }
    return result;
  }

  @Override
  public Integer create() {
    String query = "INSERT INTO Orders () VALUE ();";
    return executeUpdateAndGetId(query);
  }

  public Order read(Integer id) {
    String query = "SELECT * FROM Orders WHERE orderId=" + id + ";";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {

      if (resultSet.next()) {
        Purchaser p = purchaserRepository.readByOrderId(id);
        List<Service> services = serviceRepository.readByOrderId(id);
        return new Order(id, p, services);
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  }

  public Collection<Order> read() {
    String query = "SELECT * FROM Orders";
    Collection<Order> orders = new LinkedList<>();

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt(1);
        orders.add(read(id));
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    return orders;
  }

  @Override
  public void update(Integer id, Order order) {
    Order oldOrder = read(id);

    Purchaser purchaser = oldOrder.getPurchaser();
    purchaserRepository.update(purchaser.getId(), order.getPurchaser());

    Iterator<Service> oldServiceIter = oldOrder.getServices().iterator();
    Iterator<Service> newServiceIter = order.getServices().iterator();

    while (oldServiceIter.hasNext()) {
      serviceRepository.update(oldServiceIter.next().getId(), newServiceIter.next());
    }
  }

  public void delete(Integer id) {
    Order order = read(id);
    purchaserRepository.delete(order.getPurchaser().getId());

    order.getServices().forEach(s -> serviceRepository.delete(s.getId()));

    String query = "DELETE FROM Orders WHERE orderId=" + id;
    executeUpdate(query);
  }
}
