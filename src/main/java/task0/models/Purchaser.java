package task0.models;

public class Purchaser extends Entity {
  private String name;
  private String surname;

  public Purchaser(Integer id, String name, String surname) {
    super(id);
    this.name = name;
    this.surname = surname;
  }

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
    return "Purchaser{"
        + "id= "
        + getId()
        + '\''
        + "name= '"
        + name
        + '\''
        + ", surname= '"
        + surname
        + '\''
        + "}\n";
  }
}
