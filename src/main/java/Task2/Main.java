package Task2;

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

      Generic[] genArray = new Generic[]{genericConstructor.newInstance("Something"),
          genericConstructor.newInstance(4)};

      for (Generic gen : genArray){
        System.out.println(gen);
      }

    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

  }
}
