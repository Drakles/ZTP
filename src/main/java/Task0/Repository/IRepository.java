package Task0.Repository;

import Task0.Models.Entity;
import java.util.Collection;

public interface IRepository<T extends Entity> {

  String url = "jdbc:mysql://localhost:3306/Task0";
  String user = "root";
  String password = "E4qt9h21";

  void create(T entity);

  T read(String id);

  Collection<T> read();

  void update(String id);

  void delete(String id);

}
