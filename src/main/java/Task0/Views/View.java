package Task0.Views;

import Task0.Models.Order;
import Task0.Models.Service;
import java.util.Collection;

public class View {

  public void showMenu() {
    String sb = "Menu\n"
        + "1. add new order\n"
        + "2. add new service\n"
        + "3. show orders\n"
        + "4. show services\n"
        + "5. update order\n"
        + "6. update service\n"
        + "7. delete order\n"
        + "8. delete service\n"
        + "\n 0 to exit ";
    System.out.println(sb);
  }

  public void addNewOrder() {
    System.out.println("New order");
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

  public void showOrders(Collection<Order> orders) {
    System.out.println("Orders: " + orders.toString());
  }

  public void showServices(Collection<Service> services) {
    System.out.println("Orders: " + services.toString());
  }

  public void updateOrder() {
    System.out.println("Update order");
    System.out.println("Type order id to update: ");
  }

  public void showOrder(Order order) {
    System.out.println(order.toString());
  }

  public void updateService() {
    System.out.println("Update service");
    System.out.println("Type service id to update: ");
  }

  public void showService(Service service) {
    System.out.println(service.toString());
  }

  public void deleteOrder() {
    System.out.println("Delete order");
    System.out.println("Type order id to delete: ");
  }

  public void deleteService() {
    System.out.println("Delete service");
    System.out.println("Type service id to delete: ");
  }
}
