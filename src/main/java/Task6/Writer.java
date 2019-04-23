package Task6;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Writer {

  private StringBuilder builder = new StringBuilder();
  private String className;
  private final List<String[]> fields = new LinkedList<>();

  public Writer createClass(String className) {
    if (className == null || className.isBlank()) {
      throw new IllegalArgumentException("Class name cannot be empty");
    }
    builder.append("public class ").append(className).append("{\n");
    this.className = className;
    return this;
  }

  public Writer addFieldsWithGettersAndSetters(String... fields) {
    for (String field : fields) {
      if (isValid(field)) {
        addField(field.stripTrailing());
      } else {
        throw new IllegalArgumentException(
            "field line:" + field + " does not fullfill the required semantic");
      }
    }
    builder.append("\n");
    for (String[] typeAndFieldName : this.fields) {
      String type = typeAndFieldName[0];
      String fieldName = typeAndFieldName[1];

      addGetter(fieldName, type);
      addSetter(fieldName, type);
    }
    return this;
  }

  private boolean isValid(String field) {
    return field != null && field.split(" ").length > 1;
  }

  public Writer addFields(String... fields) {
    for (String field : fields) {
      if (isValid(field)) {
        addField(field.stripTrailing());
      } else {
        throw new IllegalArgumentException(
            "field line:" + field + " does not fullfill the required semantic");
      }
    }
    return this;
  }

  private void addSetter(String fieldName, String type) {
    builder
        .append("public ")
        .append("void")
        .append(" ")
        .append("set")
        .append(fieldName)
        .append("(")
        .append(type)
        .append(" ")
        .append(fieldName)
        .append(")")
        .append(" {\n")
        .append(" this.")
        .append(fieldName)
        .append(" = ")
        .append(fieldName)
        .append(";\n")
        .append("}\n");
  }

  private void addGetter(String fieldName, String returnType) {
    builder
        .append("public ")
        .append(returnType)
        .append(" ")
        .append("get")
        .append(fieldName)
        .append("()")
        .append(" {\n")
        .append("   return ")
        .append("this.")
        .append(fieldName)
        .append(";\n")
        .append("}\n");
  }

  private void addField(String field) {

    String[] splitField = field.split(":");

    String fieldName = splitField[0].stripTrailing();

    String[] typeAndValue = splitField[1].split("=");

    String type = typeAndValue[0].stripTrailing();

    String value = null;
    if (typeAndValue.length > 1) {
      value = typeAndValue[1].stripTrailing();
    }

    fields.add(new String[] {type, fieldName});

    builder.append("private").append(type).append(" ").append(fieldName);
    if (value != null) {
      builder.append(" =").append(value);
    }
    builder.append(";\n");
  }

  public String getCode() {
    builder.append("}");
    return builder.toString();
  }

  public Writer withSingleton() {
    // instance field
    builder
        .append("private static final ")
        .append(className)
        .append(" instance ")
        .append("= ")
        .append("new ")
        .append(className)
        .append("();\n");

    // private constructor
    builder.append("private ").append(className).append("() {\n").append("}\n");

    // getter for instance field
    builder
        .append("public static ")
        .append(className)
        .append(" get")
        .append(className)
        .append("() {\n")
        .append(" return this.instance;")
        .append("\n}\n");

    return this;
  }

  public void saveToFile(String filePath) {
    try {

      Path path = Paths.get(filePath);
      Files.createDirectories(path.getParent());
      if (Files.exists(path)) {
        Files.delete(path);
      }

      Path file = Files.createFile(path);

      FileWriter fileWriter = new FileWriter(file.toFile());

      fileWriter.write(this.getCode());

      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
