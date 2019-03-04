package Task0.Repository;

import Task0.Models.Order;
import Task0.Models.Purchaser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PurchaserRepository implements IPurchaserRepository {

  @Override
  public Integer create(Purchaser purchaser) {
    String query =
        "INSERT INTO Purchasers (name,surname) VALUES ("
            + "'" + purchaser.getName() + "'"
            + ",'" + purchaser.getSurname() + "'"
            + ");";
    return executeUpdateAndGetId(query);
  }

  @Override
  public Integer create(Order order) {
    Purchaser purchaser = order.getPurchaser();
    String query = "INSERT INTO Purchasers (orderId,name,surname) VALUES ("
        + "'" + order.getId() + "'"
        + ",'" + purchaser.getName() + "'"
        + ",'" + purchaser.getSurname() + "'"
        + ");";
    return executeUpdateAndGetId(query);
  }

  @Override
  public Integer create(Purchaser purchaser, Integer orderId) {
    String query = "INSERT INTO Purchasers (orderId,name,surname) VALUES ("
        + "'" + orderId + "'"
        + ",'" + purchaser.getName() + "'"
        + ",'" + purchaser.getSurname() + "'"
        + ");";
    return executeUpdateAndGetId(query);
  }

  @Override
  public Purchaser read(Integer id) {
    String query = "SELECT * FROM Purchasers WHERE purchaserId=" + id + ";";

    return getPurchaser(query);
  }

  @Override
  public Collection<Purchaser> read() {
    List<Purchaser> result = new LinkedList<>();
    String query = "SELECT * FROM Purchasers";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {

      while (resultSet.next()) {
        result.add(new Purchaser(Integer.valueOf(resultSet.getString(1)), resultSet.getString(3),
            resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return result;
  }

  @Override
  public Purchaser readByOrderId(Integer orderId) {
    String query = "SELECT * FROM Purchasers WHERE orderId = " + orderId + ";";

    return getPurchaser(query);
  }

  @Override
  public void update(Integer id, Purchaser purchaser) {
    String query =
        "UPDATE Purchasers SET name ='" + purchaser.getName() + "', surname ='" + purchaser
            .getSurname() + "' WHERE purchaserId =" + purchaser.getId();
    executeUpdate(query);
  }

  @Override
  public void delete(Integer id) {
    String query = "DELETE FROM Purchasers WHERE purchaserId=" + id;
    executeUpdate(query);
  }


  private Purchaser getPurchaser(String query) {
    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {

      if (resultSet.next()) {
        return new Purchaser(Integer.valueOf(resultSet.getString(1)), resultSet.getString(3),
            resultSet.getString(4));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  }
}
