package Task6;

import java.util.LinkedList;
import java.util.List;

public class Writer {

  private StringBuilder builder = new StringBuilder();
  private String className;
  private final List<String[]> fields = new LinkedList<>();

  public Writer createClass(String className) {
    builder.append("public class ").append(className).append("{\n");
    this.className = className;
    return this;
  }

  public Writer addFieldsWithGettersAndSetters(String... fields) {
    for (String field : fields) {
      addField(field.stripTrailing());
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

  public Writer addFields(String... fields) {
    for (String field : fields) {
      addField(field.stripTrailing());
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
}
