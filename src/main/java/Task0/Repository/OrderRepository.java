package Task0.Repository;

import Task0.Models.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class OrderRepository implements IOrderRepository {

  public void create(Order entity) {
    String query = "INSERT INTO Orders VALUE ();";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)) {

      if (rs.next()) {
        System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public Order read(String id) {
    return null;
  }

  public Collection<Order> read() {
    return null;
  }

  public void update(String id) {

  }

  public void delete(String id) {

  }
}
