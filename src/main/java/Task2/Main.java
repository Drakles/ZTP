package Task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    Constructor c =
        null;
    try {
      c = Date.class.getConstructor(String.class);
      Object o = c.newInstance("Jan 1, 2000");
      Date d = (Date)o;
      System.out.println(d);
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      e.printStackTrace();
    }

  }
}
