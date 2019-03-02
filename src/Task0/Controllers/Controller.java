package Task0.Controllers;

import Task0.Models.Order;
import Task0.Models.Purchaser;
import Task0.Models.Service;
import Task0.Views.View;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
  private final View view;
  private static final Scanner sc = new Scanner(System.in);
  private static final int EXIT_SIGNAL = 0;

  public Controller(View view) {
    this.view = view;
  }

  public View getView() {
    return view;
  }

  public void menu() {
    view.showMenu();
    boolean isExit = false;
    while (!isExit) {
      int command = sc.nextInt();
      if(command != EXIT_SIGNAL) {
        switch (command) {
          case 1:
            addOrder();
            break;
          case 2:
            break;
          case 3:
            break;
          case 4:
            break;
          case 5:
            break;
          case 6:
            break;
          default:
            System.out.println("Unknown command");
        }
        view.showMenu();
      }else{
        isExit = true;
      }
    }
  }

  private void addOrder() {
    view.addNewOrder();
    view.addPurchaser();
    Purchaser purchaser = addPurchaser();
    List<Service> serviceList = addServices();
    Order order = new Order(purchaser,serviceList);
    view.orderAdded(order);
  }

  private List<Service> addServices() {
    List<Service> resultServices = new ArrayList<>();
    view.addServices();
    view.howMuchServices();
    int servicesNumber = sc.nextInt();
    String name;
    BigDecimal price;
    for (int i = 0; i < servicesNumber; i++) {
      view.addServiceName();
      name = sc.next();
      view.addServicePrice();
      price = sc.nextBigDecimal();
      resultServices.add(new Service(name,price));
    }
    return resultServices;
  }

  private Purchaser addPurchaser() {
    view.addPurchaserName();
    String name = sc.next();
    view.addPurchaserSurname();
    String surname = sc.next();

    return new Purchaser(name,surname);
  }
}
