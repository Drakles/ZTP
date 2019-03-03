package Task1;

import java.util.Collection;

class Display {

  static String showAnimalData(Collection<? extends Animal> animals){
    StringBuilder sb = new StringBuilder();
    for (Animal animal : animals){
      sb.append(animal.toString());
    }
    return sb.toString();
  }

  static String showMammalData(Collection<? extends Mammal> mammals){
    StringBuilder sb = new StringBuilder();
    for (Mammal mammal : mammals){
      sb.append(mammal.toString());
    }
    return sb.toString();
  }

  static String showCatData(Collection<? extends Cat> cats){
    StringBuilder sb = new StringBuilder();
    for (Cat cat : cats){
      sb.append(cat.toString());
    }
    return sb.toString();
  }
}

