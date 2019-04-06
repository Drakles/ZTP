package Task3;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Cloneable, Serializable {
  private int id;

  public Student(int id) {
    this.id = id;
  }

  public Student(Student student) {
    this.id = student.getId();
  }

  public int getId() {
    return id;
  }

  public Student clone() throws CloneNotSupportedException {
    return (Student) super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return id == student.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + '}';
  }
}
