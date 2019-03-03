package Task0;

import Task0.Controllers.Controller;
import Task0.Views.View;

public class Main {

  public static void main(String[] args) {

    View view = new View();

    Controller controller = new Controller(view);
    controller.menu();

  }
}
