package Task1;

import java.util.Collection;
import java.util.stream.Collectors;

class Display {

  static String showAnimalData(Collection<? super Animal> animals) {
    return animals.stream().map(Object::toString).collect(Collectors.joining());
  }

  static String showMammalData(Collection<? super Mammal> mammals) {
    return mammals.stream().map(Object::toString).collect(Collectors.joining());
  }

  static String showCatData(Collection<? super Cat> cats) {
    return cats.stream().map(Object::toString).collect(Collectors.joining());
  }
}
