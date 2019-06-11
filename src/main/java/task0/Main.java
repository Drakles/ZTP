package task0;

import task0.controllers.Controller;
import task0.views.View;

public class Main {

  public static void main(String[] args) {
    View view = new View();

    Controller controller = new Controller(view);
    controller.menu();
  }
}
