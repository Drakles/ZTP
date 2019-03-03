package Task0.Models;

public class Purchaser extends Entity {
private String name;
private String surname;


  public Purchaser(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  @Override
  public String toString() {
    return "Purchaser{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
  }
}
