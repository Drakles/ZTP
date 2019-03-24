package Task3;

import Task0.Models.Service;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.SerializationUtils;

public class Main {

  public static void main(String[] args){
    List<University> universities = new ArrayList<>(Generator.generate(1, 50, 1000));

    University uni = universities.get(0);
    int repeat = 100;
    try {
//      University clone = uni.clone();
//
//      System.out.println("Clone:");
//      System.out.println(clone == uni);
//      System.out.println(uni.equals(clone));
//
//      University copyConstructor = new University(uni);
//
//      System.out.println("Copy constructor:");
//      System.out.println(copyConstructor == uni);
//      System.out.println(copyConstructor.equals(uni));
//
//      University serializedUni = (University) SerializationUtils.clone(uni);
//
//      System.out.println("Serialized object:");
//      System.out.println(serializedUni == uni);
//      System.out.println(serializedUni.equals(uni));

      long time = System.currentTimeMillis();
      for (int i = 0; i < repeat; i++) {
        testCloning(uni);
      }
      System.out.println("After cloning: " + (System.currentTimeMillis()-time));

      time = System.currentTimeMillis();

      for (int i = 0; i < repeat; i++) {
        testCopyConstructor(uni);
      }
      System.out.println("After copy constructor: " + (System.currentTimeMillis()-time));

      time = System.currentTimeMillis();
      for (int i = 0; i < repeat; i++) {
        testSerialization(uni);
      }
      System.out.println("After serialization: " + (System.currentTimeMillis()-time));

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

  private static void testCloning(University university) throws CloneNotSupportedException {
    university.clone();
  }

  private static void testCopyConstructor(University university){
    new University(university);
  }

  private static void testSerialization(University university){
    SerializationUtils.clone(university);
  }

}
