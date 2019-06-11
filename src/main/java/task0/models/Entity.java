package task0.models;

public abstract class Entity {
  private int id;

  Entity(int id) {
    this.id = id;
  }

  public Entity() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
