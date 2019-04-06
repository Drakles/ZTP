package Task5;

import Task3.Student;
import java.util.List;

public class DepartmentBuilder {
  private int number;
  private List<Student> students;

  public DepartmentBuilder setNumber(int number) {
    this.number = number;
    return this;
  }

  public DepartmentBuilder setStudents(List<Student> students) {
    this.students = students;
    return this;
  }

  public Department createDepartment() {
    return new Department(number, students);
  }
}
