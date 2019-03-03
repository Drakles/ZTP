package Task0.Repository;

import Task0.Models.Purchaser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class PurchaserRepository implements IPurchaserRepository {

  @Override
  public void create(Purchaser entity) {
    String query =
        "INSERT INTO Purchasers (name,surname) VALUES ("
            +"'"+entity.getName()+"'"
            + ",'"+ entity.getSurname() +"'"
            + ");";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement()) {
      st.executeUpdate(query);

    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  @Override
  public Purchaser read(String id) {
    String query = "SELECT * FROM Purchasers WHERE purchaserId=" + id+";";

    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query)) {
      String name;
      String surname;
      if(resultSet.next()){
        name = resultSet.getString(3);
        surname = resultSet.getString(4);
        return new Purchaser(name,surname);
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public Collection<Purchaser> read() {
    return null;
  }

  @Override
  public void update(String id) {

  }

  @Override
  public void delete(String id) {

  }
}
