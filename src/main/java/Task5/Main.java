package Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    StudentBuilder sb = new StudentBuilder();
    DepartmentBuilder db = new DepartmentBuilder();

    List<Course> courseList = new LinkedList<>();
    List<Student> students = new LinkedList<>();

    courseList.add(new Course("Analiza 1.1"));
    courseList.add(new Course("Analiza 2.1"));
    courseList.add(new Course("Analiza 3.1"));

    Department department = db.setNumber(1).createDepartment();
    Department department2 = db.setNumber(2).createDepartment();

    sb.setAge(21)
        .setGender(Gender.MALE)
        .setId(0)
        .setName("Jan")
        .setSurname("Kowalski")
        .setCourses(new ArrayList<>(courseList))
        .setDepartment(department);

    students.add(sb.createStudent());

    courseList.remove(courseList.size() - 1);

    sb.setName("Janko")
        .setSurname("Muzykant")
        .setId(1)
        .setCourses(new ArrayList<>(courseList))
        .setAge(23);
    courseList.add(new Course("Podstawy programownania"));

    students.add(sb.createStudent());

    sb.setName("Klaudia")
        .setSurname("Marciniak")
        .setId(2)
        .setGender(Gender.FEMALE)
        .setAge(20)
        .setCourses(new ArrayList<>(courseList));
    students.add(sb.setDepartment(department2).createStudent());

    System.out.println("\n" + students);

    // only female
    List<Student> femaleStudents =
        students.stream()
            .filter(s -> s.getGender().equals(Gender.FEMALE))
            .collect(Collectors.toList());
    System.out.println("\n" + femaleStudents);

    // only those who has Podstawy programownania
    List<Student> programmingStudents =
        students.stream()
            .filter(
                s ->
                    s.getCourses().stream().anyMatch(c -> c.name.equals("Podstawy programownania")))
            .collect(Collectors.toList());

    System.out.println("\n" + programmingStudents);

    System.out.println(
        "\n" + students.stream().map(Student::getDepartment).collect(Collectors.toList()));

    // the least number of courses
    System.out.println(
        "\n" + students.stream().min(Comparator.comparing(s -> s.getCourses().size())).get());

    // the biggest number of courses
    System.out.println(
        "\n" + students.stream().max(Comparator.comparing(s -> s.getCourses().size())).get());

    students.stream()
        .collect(Collectors.groupingBy(Student::getGender))
        .forEach(
            (key, value) ->
                System.out.println(
                    "\nStudents "
                        + key
                        + " average age: "
                        + (value.stream().mapToInt(Student::getAge).sum() / value.size())));
  }
}
