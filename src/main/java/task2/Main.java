package task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

  public static void main(String[] args) {

    try {
      Constructor<Generic> genericConstructor = Generic.class.getConstructor(Object.class);

      Generic genString = genericConstructor.newInstance("MyString");
      System.out.println(genString);

      Generic genInt = genericConstructor.newInstance(2);
      System.out.println(genInt);

      Generic[] genArray =
          new Generic[] {
            genericConstructor.newInstance("Something"), genericConstructor.newInstance(4)
          };

      for (Generic gen : genArray) {
        System.out.println(gen);
      }

      Pair<String> stringPair = new Pair<>("First", "Second");
      System.out.println(stringPair);

      Pair<String> cloneStringPair = stringPair.clone();

      System.out.println(cloneStringPair);
      System.out.println(stringPair.equals(cloneStringPair));

      Pair<Integer> integerPair = new Pair<>(3, 4);
      System.out.println(integerPair);

      Pair<Integer> cloneIntegerPair = integerPair.clone();

      System.out.println(cloneIntegerPair);
      System.out.println(cloneIntegerPair.equals(integerPair));

      //      Pair<String> errorPair = integerPair.clone();
      //      Pair<Integer> errorPair2 = stringPair.clone();

    } catch (NoSuchMethodException
        | InstantiationException
        | IllegalAccessException
        | InvocationTargetException
        | CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
