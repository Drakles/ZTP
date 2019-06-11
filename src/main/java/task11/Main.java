package task11;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Car bmw = new Car("BMW");
    Car mercedes = new Car("Mercedes");
    Car fiat = new Car("Fiat");

    List<Car> carList = new ArrayList<>(3);
    carList.add(bmw);
    carList.add(mercedes);
    carList.add(fiat);

    carList.parallelStream().forEach(Car::run);
  }
}
