package Task0.Views;

import Task0.Models.Order;

public class View {

  public void showMenu() {
    String sb = "Menu\n"
        + "1. add new order\n"
        + "2. add new service\n"
        + "3. show order\n"
        + "4. show service\n"
        + "5. update order\n"
        + "6. update service\n"
        + "7. delete order\n"
        + "8. delete service\n"
        + "\n 0 to exit ";
    System.out.println(sb);
  }

  public void addNewOrder() {
    System.out.println("Add new order");
  }

  public void addPurchaser() {
    System.out.println("Add purchaser");
  }

  public void addPurchaserName() {
    System.out.print("Name: ");
  }

  public void addPurchaserSurname() {
    System.out.print("Surname: ");
  }

  public void addServices() {
    System.out.println("Add new services");
  }

  public void howMuchServices() {
    System.out.println("Type how much services would you like to add: ");
  }

  public void addServiceName() {
    System.out.println("Type service name: ");
  }

  public void addServicePrice() {
    System.out.println("Type service price: ");
  }

  public void orderAdded(Order order) {
    System.out.println("Succesfully added order: " + order);
  }
}
