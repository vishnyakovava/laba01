package com.netcracker;
import com.netcracker.collections.CarList;
import com.netcracker.collections.MyListT;
import com.netcracker.collections.PersonList;
import com.netcracker.collections.RepPerson;
import com.netcracker.entities.Car;
import com.netcracker.entities.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
// разобаться с properties, создать пустой файл с расширением properties, в нем sorter=bubble
// в этом файле будет храниться конфигурация приложения
// напистаь класс Configurator, считывает файл properties и возвращает результаты
//public static Configurator(), getInstance(),
// sorter = Configurator.getInstance().getSorter()

import java.util.Comparator;
import java.util.function.Predicate;

/* рефлексия */
public class App 
{
    private static Logger log = LogManager.getLogger(App.class.getName());

    public static void main( String[] args )
    {

        Person person1 = new Person("Maslov", new LocalDate(1996, 8, 29));
        Person person2 = new Person("Zavodova", new LocalDate(2000, 7, 26));
        Person person3 = new Person("Nasonova", new LocalDate(1992, 2, 7));
        Person person4 = new Person("Sidorov", new LocalDate(1962, 12, 30));
        Person person5 = new Person("Simonov", new LocalDate(1996, 11, 29));
        Person person6 = new Person("Aaaaaa", new LocalDate(1997, 11, 6));
        log.info("Age of person: "+ person5.toString()+": "+person5.getAge());

//        PersonList list = new PersonList(1);
//
// MyListT<Person> list= new MyListT<Person>(1);
        RepPerson list = new RepPerson(1);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);

        log.info("sorting:");
        list.sortBySurname();
        list.printItems();

       log.info("Before remove:");
        list.printItems();

        list.remove(2);
        log.info("After remove:");
        list.printItems();

        log.info("Search:");
        //Person[] pers = list.findByAge(5);

        log.info("Cars");
        Car car1 = new Car("Nissan","gt-r", 123321);
        Car car2 = new Car("Opel","astra", 123456);
        Car car3 = new Car("Lada","vesta", 252526);
        Car car4 = new Car("Mazda","cx-5", 128794);
        Car car5 = new Car("Bmw","x6", 998877);

        //CarList cars = new CarList(1);
        MyListT<Car> cars = new MyListT<Car>(1);
        cars.add(car1); cars.add(car2); cars.add(car3); cars.add(car4); cars.add(car5);
        cars.printItems();

        ;

    }

}
