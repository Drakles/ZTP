package Task0;

import Task0.Models.Purchaser;
import Task0.Repository.PurchaserRepository;

public class Main {

  public static void main(String[] args) {

//    View view = new View();
//
//    Controller controller = new Controller(view);
//
//    controller.menu();

    PurchaserRepository pr = new PurchaserRepository();
//    Purchaser p = new Purchaser("Jann","Kowalski");
//    pr.create(p);
    System.out.println(pr.read("1"));

  }
}
