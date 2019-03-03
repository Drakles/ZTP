package Task0.Models;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
  private int id;

  Entity(int id) {
    this.id = id;
  }

  public Entity() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
