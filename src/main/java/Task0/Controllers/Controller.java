package Task0.Controllers;

import Task0.Models.Order;
import Task0.Models.Purchaser;
import Task0.Models.Service;
import Task0.Repository.OrderRepository;
import Task0.Repository.PurchaserRepository;
import Task0.Repository.ServiceRepository;
import Task0.Views.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Controller {

  private final View view;
  private static final Scanner sc = new Scanner(System.in);
  private static final int EXIT_SIGNAL = 0;
  private static final OrderRepository orderRepository = new OrderRepository();
  private static final PurchaserRepository purchaserRepository = new PurchaserRepository();
  private static final ServiceRepository serviceRepository = new ServiceRepository();

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
      if (command != EXIT_SIGNAL) {
        switch (command) {
          case 1:
            addOrder();
            break;
          case 2:
            addSingleService();
            break;
          case 3:
            showOrders();
            break;
          case 4:
            showServices();
            break;
          case 5:
            updateOrder();
            break;
          case 6:
            updateService();
            break;
          case 7:
            deleteOrder();
            break;
          case 8:
            deleteService();
            break;
          default:
            System.out.println("Unknown command");
        }
        view.showMenu();
      } else {
        isExit = true;
      }
    }
  }

  private void deleteService() {
    view.deleteService();
    Integer id = sc.nextInt();
    serviceRepository.delete(id);
  }

  private void deleteOrder() {
    view.deleteOrder();
    Integer id = sc.nextInt();
    orderRepository.delete(id);
  }

  private void updateService() {
    view.updateService();
    Integer id = sc.nextInt();
    Service serviceOld = serviceRepository.read(id);
    view.showService(serviceOld);
    Service serviceUpdated = getServiceFromUser();
    serviceRepository.update(serviceOld.getId(),serviceUpdated);
  }

  private void updateOrder() {
    view.updateOrder();
    Integer id = sc.nextInt();
    Order orderOld = orderRepository.read(id);
    view.showOrder(orderOld);
    Order orderUpdated = getOrderFromUser();

    orderRepository.update(orderOld.getId(),orderUpdated);
  }

  private void showServices() {
    view.showServices(serviceRepository.read());
  }

  private void showOrders() {
    view.showOrders(orderRepository.read());
  }

  private void addOrder() {
    view.orderAdded(getOrderFromUser());
  }

  private Order getOrderFromUser(){
    view.addNewOrder();
    view.addPurchaser();
    Order order = new Order(orderRepository.create());

    Purchaser purchaser = addPurchaser(order.getId());
    order.setPurchaser(purchaser);

    Collection<Service> serviceList = addServices(order.getId());
    order.setServices(serviceList);
    return order;
  }

  private Collection<Service> addServices(Integer orderId) {
    Collection<Service> resultServices = new ArrayList<>();
    view.addServices();
    view.howMuchServices();
    int servicesNumber = sc.nextInt();
    for (int i = 0; i < servicesNumber; i++) {
      resultServices.add(addSingleService(orderId));
    }
    return resultServices;
  }

  private Service addSingleService() {
    Service service = getServiceFromUser();
    serviceRepository.create(service);

    return service;
  }

  private Service addSingleService(Integer orderId) {
    Service service = getServiceFromUser();
    serviceRepository.create(service, orderId);

    return service;
  }

  private Service getServiceFromUser() {
    view.addServiceName();
    String name = sc.next();
    view.addServicePrice();
    Double price = sc.nextDouble();
    return new Service(name, price);
  }

  private Purchaser addPurchaser(Integer orderId) {
    Purchaser purchaser = getPurchaserFromUser();
    purchaserRepository.create(purchaser, orderId);
    return purchaser;
  }

  private Purchaser addPurchaser() {

    Purchaser purchaser = getPurchaserFromUser();
    purchaserRepository.create(purchaser);

    return purchaser;
  }

  private Purchaser getPurchaserFromUser() {
    view.addPurchaserName();
    String name = sc.next();
    view.addPurchaserSurname();
    String surname = sc.next();

    return new Purchaser(name, surname);

  }
}
