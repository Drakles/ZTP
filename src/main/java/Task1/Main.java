package Task1;

import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal(2);
        Mammal mammal = new Mammal(2,4);
        Cat cat = new Cat(2,4,20);

        Collection<Animal> animals = new HashSet<>();
        animals.add(animal);

        Collection<Mammal> mammals = new HashSet<>();
        mammals.add(mammal);

        Collection<Cat> cats = new HashSet<>();
        cats.add(cat);

        System.out.println(Display.showAnimalData(animals));
        System.out.println(Display.showMammalData(animals));
        System.out.println(Display.showCatData(animals));

        //won't compile
//        System.out.println(Display.showAnimalData(mammals));

        System.out.println(Display.showMammalData(mammals));
        System.out.println(Display.showCatData(mammals));

        //won't compile
//        System.out.println(Display.showAnimalData(cats));
//        System.out.println(Display.showMammalData(cats));

        System.out.println(Display.showCatData(cats));


//        ad-hoc
        Number n = 1;
        Float f = 2.0f;
        Integer i = 3;

//Animal has just adHoc method with Number argument

        System.out.println("Animal");
        animal.adHoc(n);
//        Number
        animal.adHoc(f);
//        Number
        animal.adHoc(i);
//        Number


//Mammal has adHoc method with Float argument, but method with Number argument from it's
// super class as well

        System.out.println("\nMammal");
        mammal.adHoc(n);
//      Number
        mammal.adHoc(f);
//      Float
        mammal.adHoc(i);
//      Number

//Cat has adHoc method with Integer argument, but methods from it's super class as well

        System.out.println("\nCat");
        cat.adHoc(n);
//      Number
        cat.adHoc(f);
//      Float
        cat.adHoc(i);
//      Integer

    }
}

