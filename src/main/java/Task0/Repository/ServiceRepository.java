package Task0.Repository;

import Task0.Models.Order;
import Task0.Models.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

  @Override
  public Integer create(Service entity) {
    String query =
        "INSERT INTO Services (name,price) VALUES ("
            + "'" + entity.getName() + "'"
            + ",'" + entity.getPrice() + "'"
            + ");";

    return executeUpdateAndGetId(query);
  }

  @Override
  public Collection<Integer> create(Order order) {
    Collection<Integer> result = new ArrayList<>();
    order.getServices().forEach(s -> result.add(create(s, order.getId())));
    return result;
  }

  @Override
  public Integer create(Service service, Integer orderId) {
    String query = "INSERT INTO Services (serviceId,name,price,orderId) VALUES ("
        + "'" + service.getId() + "'"
        + ",'" + service.getName() + "'"
        + ",'" + service.getPrice() + "'"
        + ",'" + orderId + "'"
        + ");";
    return executeUpdateAndGetId(query);
  }

  @Override
  public Service read(Integer id) {
    String query = "SELECT * FROM Services WHERE serviceId=" + id + ";";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {
      if (resultSet.next()) {
        return new Service(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2),
            Double.valueOf(resultSet.getString(3)));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public Collection<Service> read() {
    String query = "SELECT * FROM Services;";

    return new LinkedList<>(getServices(query));
  }

  @Override
  public List<Service> readByOrderId(Integer id) {
    String query = "SELECT * FROM Services WHERE orderId =" + id + ";";
    return new LinkedList<>(getServices(query));
  }

  private List<Service> getServices(String query) {
    List<Service> result = new LinkedList<>();
    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {
      while (resultSet.next()) {
        result.add(new Service(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2),
            Double.valueOf(resultSet.getString(3))));
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return result;
  }

  @Override
  public void update(Integer id, Service service) {
    String query =
        "UPDATE Services SET name ='" + service.getName() + "', price ='" + service.getPrice()
            + "' "
            + "WHERE " + "serviceId =" + id;
    executeUpdate(query);
  }

  @Override
  public void delete(Integer id) {
    String query = "DELETE FROM Services WHERE serviceId=" + id;
    executeUpdate(query);
  }
}
