package task6;

import Task6.Writer;
import org.junit.Assert;
import org.junit.Test;

public class WriterTest {

  @Test
  public void createSimpleClass() {
    Assert.assertEquals(
        "public class Osoba{\n" + "private String imie = 'Jan';\n" + "}",
        new Writer().createClass("Osoba").addFields("imie: String = 'Jan'").getCode());
  }

  @Test
  public void createSimpleClassWithGettersAndSetters() {
    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "\n"
            + "public  String getimie() {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public void setimie( String imie) {\n"
            + " this.imie = imie;\n"
            + "}\n"
            + "}",
        new Writer()
            .createClass("Osoba")
            .addFieldsWithGettersAndSetters("imie: String = 'Jan'")
            .getCode());
  }

  @Test
  public void createClassWithMultipleFields() {
    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "private String nazwisko;\n"
            + "private int rok;\n"
            + "}",
        new Writer()
            .createClass("Osoba")
            .addFields("imie: String = 'Jan'", "nazwisko: String", "rok: int")
            .getCode());
  }

  @Test
  public void createClassWithMultipleFieldsAndGettersAndSetters() {
    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "private String nazwisko;\n"
            + "private int rok;\n"
            + "\n"
            + "public  String getimie() {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public void setimie( String imie) {\n"
            + " this.imie = imie;\n"
            + "}\n"
            + "public  String getnazwisko() {\n"
            + "   return this.nazwisko;\n"
            + "}\n"
            + "public void setnazwisko( String nazwisko) {\n"
            + " this.nazwisko = nazwisko;\n"
            + "}\n"
            + "public  int getrok() {\n"
            + "   return this.rok;\n"
            + "}\n"
            + "public void setrok( int rok) {\n"
            + " this.rok = rok;\n"
            + "}\n"
            + "}",
        new Writer()
            .createClass("Osoba")
            .addFieldsWithGettersAndSetters("imie: String = 'Jan'", "nazwisko: String", "rok: int")
            .getCode());
  }

  @Test
  public void createSimpleClassWithSingleton() {
    Assert.assertEquals(
        "public class Osoba{\n"
            + "private String imie = 'Jan';\n"
            + "private String nazwisko;\n"
            + "private int rok;\n"
            + "\n"
            + "public  String getimie() {\n"
            + "   return this.imie;\n"
            + "}\n"
            + "public void setimie( String imie) {\n"
            + " this.imie = imie;\n"
            + "}\n"
            + "public  String getnazwisko() {\n"
            + "   return this.nazwisko;\n"
            + "}\n"
            + "public void setnazwisko( String nazwisko) {\n"
            + " this.nazwisko = nazwisko;\n"
            + "}\n"
            + "public  int getrok() {\n"
            + "   return this.rok;\n"
            + "}\n"
            + "public void setrok( int rok) {\n"
            + " this.rok = rok;\n"
            + "}\n"
            + "private static final Osoba instance = new Osoba();\n"
            + "private Osoba() {\n"
            + "}\n"
            + "public static Osoba getOsoba() {\n"
            + " return this.instance;\n"
            + "}\n"
            + "}",
        new Writer()
            .createClass("Osoba")
            .addFieldsWithGettersAndSetters("imie: String = 'Jan'", "nazwisko: String", "rok: int")
            .withSingleton()
            .getCode());
  }
}
