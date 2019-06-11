package task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Generator {

  public static Collection<University> generate(int univeristies, int departments, int students) {
    Collection<University> universities = new HashSet<>();
    for (int i = 0; i < univeristies; i++) {
      List<Department> departmentsList = new LinkedList<>();
      for (int j = 0; j < departments; j++) {
        List<Student> studentsList = new LinkedList<>();
        for (int k = 0; k < students; k++) {
          studentsList.add(new Student(k + j + i));
        }
        departmentsList.add(new Department(j, studentsList));
      }
      universities.add(new University(i, departmentsList));
    }
    return universities;
  }
}
