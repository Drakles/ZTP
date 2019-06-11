package task0.repository;

import task0.models.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

public interface IRepository<T extends Entity> {

  String url = "jdbc:mysql://localhost:3306/Task0";
  String user = "root";
  String password = "password";

  Integer create(T entity);

  T read(Integer id);

  Collection<T> read();

  void update(Integer id, T entity);

  void delete(Integer id);

  default void executeUpdate(String query) {
    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement()) {
      st.executeUpdate(query);

    } catch (SQLException e) {
      System.out.println(e + " " + Arrays.toString(e.getStackTrace()));
    }
  }

  default ResultSet execute(String query) {
    try (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement()) {
      return st.executeQuery(query);
    } catch (SQLException e) {
      System.out.println(e + " " + Arrays.toString(e.getStackTrace()));
    }
    return null;
  }

  default Integer executeUpdateAndGetId(String query) {
    Integer result = null;
    try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
      int rows = st.executeUpdate();
      if (rows == 1) {
        ResultSet res = st.getGeneratedKeys();
        if (res.next()) {
          result = res.getInt(1);
        }
      }

    } catch (SQLException e) {
      System.out.println(e + " " + Arrays.toString(e.getStackTrace()));
    }
    return result;
  }
}
