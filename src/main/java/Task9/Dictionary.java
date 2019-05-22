package Task9;

public class Dictionary {
  public static TwoArgsOperator getTwoArgs(String op) {
    switch (op) {
      case "+":
        return TwoArgsOperator.ADD;
      case "-":
        return TwoArgsOperator.SUB;
      case "/":
        return TwoArgsOperator.DIV;
      case "*":
        return TwoArgsOperator.MULT;
    }
    return null;
  }

  public static String getTwoArgs(TwoArgsOperator operator) {
    switch (operator) {
      case ADD:
        return "+";
      case SUB:
        return "-";
      case DIV:
        return "*";
      case MULT:
        return "/";
    }
    return null;
  }

  public static SingleOp getSingleArg(String op) {
    switch (op) {
      case "++":
        return SingleOp.INC;
      case "--":
        return SingleOp.DEC;
    }
    return null;
  }

  public static String getSingleArg(SingleOp operator) {
    switch (operator) {
      case INC:
        return "++";
      case DEC:
        return "--";
    }
    return null;
  }
}
