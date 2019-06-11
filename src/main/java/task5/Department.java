package task5;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import task3.Student;

public class Department implements Cloneable, Serializable {

  private int number;
  private List<Student> students;

  public Department(int number, List<Student> students) {
    this.number = number;
    this.students = students;
  }

  public Department(Department department) {
    this.number = department.getNumber();
    this.students = new LinkedList<>();
    department.getStudents().forEach(s -> students.add(new Student(s)));
  }

  public int getNumber() {
    return number;
  }

  public List<Student> getStudents() {
    return students;
  }

  public Department clone() throws CloneNotSupportedException {
    return (Department) super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Department that = (Department) o;
    return number == that.number && Objects.equals(students, that.students);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, students);
  }

  @Override
  public String toString() {
    return "Department{" + "number=" + number + ", students=" + students + '}';
  }
}
