package task8;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {

    Loudable someCreate = new Cat(2, 1, 50);
    System.out.println(someCreate.giveVoice());

    Loudable someOtherCreate = new Dolphin(2, 0);
    System.out.println(someOtherCreate.giveVoice());

    var something = new Dolphin(2, 0);
    System.out.println(something);

    List<Loudable> loudables = new ArrayList<>();

    loudables.add(someCreate);
    loudables.add(someOtherCreate);
    loudables.add(something);

    Optional<Loudable> optionalLoudable =
        loudables.stream().filter(l -> l instanceof Cat).findFirst();
    System.out.println(optionalLoudable.orElseThrow().giveVoice());

    try {
      loudables.stream().filter(l -> l.giveVoice() == null).findFirst().orElseThrow();
    } catch (NoSuchElementException e) {
      System.out.println("brak elememntu");
    }
  }
}
