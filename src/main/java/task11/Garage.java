package task11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Garage {
  private static final BlockingQueue<Car> places = new ArrayBlockingQueue<>(1);

  public static BlockingQueue<Car> getPlaces() {
    return places;
  }
}
