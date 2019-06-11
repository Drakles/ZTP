package task5;

import java.util.List;
import task3.Student;

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
