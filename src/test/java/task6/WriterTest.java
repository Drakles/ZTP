package task6;

import Task6.Writer;
import org.junit.Assert;
import org.junit.Test;

public class WriterTest {

  @Test
  public void createSimpleClass() {
    Writer writer = new Writer();

    writer.createClass("Osoba");
    writer.addFields("imie: String = 'Jan'");

    Assert.assertEquals(
        "public class Osoba{\n" + "private String imie = 'Jan';\n" + "}", writer.getCode());
  }

  @Test
  public void createSimpleClassWithGettersAndSetters() {
    Writer writer = new Writer();

    writer.createClass("Osoba");
    writer.addFieldsWithGettersAndSetters("imie: String = 'Jan'");

    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "\n"
            + "public  String getimie() {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public  String setimie( String imie) {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "}",
        writer.getCode());
  }

  @Test
  public void createClassWithMultipleFields() {
    Writer writer = new Writer();

    writer.createClass("Osoba");
    writer.addFields("imie: String = 'Jan'", "nazwisko: String", "rok: int");

    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "private String nazwisko;\n"
            + "private int rok;\n"
            + "}",
        writer.getCode());
  }

  @Test
  public void createClassWithMultipleFieldsAndGettersAndSetters() {
    Writer writer = new Writer();

    writer.createClass("Osoba");
    writer.addFieldsWithGettersAndSetters("imie: String = 'Jan'", "nazwisko: String", "rok: int");

    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "private String nazwisko;\n"
            + "private int rok;\n"
            + "\n"
            + "public  String getimie() {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public  String setimie( String imie) {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public  String getnazwisko() {\n"
            + "   return this.nazwisko;\n"
            + "}\n"
            + "public  String setnazwisko( String nazwisko) {\n"
            + "   return this.nazwisko;\n"
            + "}\n"
            + "public  int getrok() {\n"
            + "   return this.rok;\n"
            + "}\n"
            + "public  int setrok( int rok) {\n"
            + "   return this.rok;\n"
            + "}\n"
            + "}",
        writer.getCode());
  }
}
