package task11;

import java.util.Random;

public class Car extends Thread {

  private final String name;
  private boolean isInGarage;
  private static final Random random = new Random();

  public Car(String name) {
    this.name = name;
    isInGarage = false;
  }

  @Override
  public void run() {
    while (true) {
      if (!isInGarage) {
        if (Garage.getPlaces().offer(this)) {
          isInGarage = true;
          System.out.println(this + " parked in garage");
        } else {
          try {
            System.out.println(this + " driving around");
            sleep(random.nextInt(11) * 1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      } else {
        try {
          sleep(random.nextInt(11) * 1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Garage.getPlaces().remove(this);
        System.out.println(this + " left garage");
        isInGarage = false;
        try {
          sleep(random.nextInt(11) * 1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  public String toString() {
    return "Car{" + "name='" + name + '}';
  }
}
