package Task5;

import java.util.List;
import java.util.Objects;

public class Student {
  private int id;
  private String name;
  private String surname;
  private List<Course> courses;
  private Gender gender;
  private int age;
  private Department department;

  public Student(
      int id,
      String name,
      String surname,
      List<Course> courses,
      Gender gender,
      int age,
      Department department) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.courses = courses;
    this.gender = gender;
    this.age = age;
    this.department = department;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public Gender getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  public Department getDepartment() {
    return department;
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
    return "Student{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", surname='"
        + surname
        + '\''
        + ", courses="
        + courses
        + ", gender="
        + gender
        + ", age="
        + age
        + '}';
  }
}
