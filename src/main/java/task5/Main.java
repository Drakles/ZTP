package task5;

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

    System.out.println("All students:");
    System.out.println(students);

    // only female
    List<Student> femaleStudents =
        students.stream()
            .filter(s -> s.getGender().equals(Gender.FEMALE))
            .collect(Collectors.toList());
    System.out.println("\nfemale students:");
    System.out.println(femaleStudents);

    // only those who has Podstawy programownania
    List<Student> programmingStudents =
        students.stream()
            .filter(
                s ->
                    s.getCourses().stream().anyMatch(c -> c.name.equals("Podstawy programownania")))
            .collect(Collectors.toList());

    System.out.println("\nStudents who are enrolled on Podstawy programowania:");
    System.out.println(programmingStudents);

    System.out.println("\nStudents mapped to Departments");
    System.out.println(students.stream().map(Student::getDepartment).collect(Collectors.toList()));

    System.out.println("\nStudent with the least number of courses");
    System.out.println(
        students.stream().min(Comparator.comparing(s -> s.getCourses().size())).get());

    System.out.println("\nStudent with the biggest number of courses");
    System.out.println(
        students.stream().max(Comparator.comparing(s -> s.getCourses().size())).get());

    System.out.println("\nStudents per gender: ");
    students.stream()
        .collect(Collectors.groupingBy(Student::getGender))
        .forEach(
            (key, value) ->
                System.out.println(
                    "Students "
                        + key
                        + " average age: "
                        + (value.stream().mapToInt(Student::getAge).sum() / value.size())));
  }
}
