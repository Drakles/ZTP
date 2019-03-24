package Task3;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class University implements Cloneable, Serializable {

  private int id;
  private List<Department> departments;

  public University(int id, List<Department> departments) {
    this.id = id;
    this.departments = departments;
  }

  public University(University university) {
    this.id = university.getId();
    this.departments = new LinkedList<>();
    university.getDepartments().forEach(d -> departments.add(new Department(d)));
  }

  public int getId() {
    return id;
  }

  public List<Department> getDepartments() {
    return departments;
  }

  public University clone() throws CloneNotSupportedException {
    return (University) super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    University that = (University) o;
    return id == that.id &&
        Objects.equals(departments, that.departments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, departments);
  }

  @Override
  public String toString() {
    return "University{" +
        "id=" + id +
        ", departments=" + departments +
        '}';
  }
}
