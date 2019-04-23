package Task6;

public class Main {

  public static void main(String[] args) {
    new Writer()
        .createClass("Osoba")
        .addFieldsWithGettersAndSetters("imie: String = 'Jan'")
        .saveToFile("task6/out/osoba.java");
  }
}
