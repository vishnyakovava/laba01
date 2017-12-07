package com.netcracker;
import com.netcracker.collections.MyListT;
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

/**
 * Hello world!
 *
 */
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

        //PersonList list = new PersonList(1);
        MyListT<Person> list= new MyListT<Person>(1);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);

       log.info("Before remove:");
        list.printItems();

        list.remove(2);
        log.info("After remove:");
        list.printItems();

        log.info("Search:");
        Person p = list.find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getSurname().equals("Sidorov");
            }
        });
        if(p != null) System.out.println(p.toString());
        else log.info("Didn't find this person");

        Person p2 =list.find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getID()==5;
            }
        });
        if(p2!= null) log.info(p2.toString());
        else log.info("Didn't find this person");

        System.out.println("Bubble sort by ID");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) { return o1.getID()-o2.getID();}
        });

        list.printItems();
        log.info("Bubble sort by age");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        list.printItems();
        log.info("Bubble sort by surname");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        list.printItems();

        log.info("Shaker sort by surname");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        list.printItems();
        log.info("Shaker sort by ID");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getID() - o2.getID();
            }
        });
        list.printItems();
        log.info("Shaker sort by age");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        list.printItems();

    }
}
