package task5;

import java.util.List;

public class StudentBuilder {
  private int id;
  private String name;
  private String surname;
  private List<Course> courses;
  private Gender gender;
  private int age;
  private Department department;

  public StudentBuilder setId(int id) {
    this.id = id;
    return this;
  }

  public StudentBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public StudentBuilder setSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public StudentBuilder setCourses(List<Course> courses) {
    this.courses = courses;
    return this;
  }

  public StudentBuilder setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public StudentBuilder setAge(int age) {
    this.age = age;
    return this;
  }

  public StudentBuilder setDepartment(Department department) {
    this.department = department;
    return this;
  }

  public Student createStudent() {
    return new Student(id, name, surname, courses, gender, age, department);
  }
}
