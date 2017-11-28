package com.netcracker;
import org.joda.time.LocalDate;

import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person1 = new Person("Maslov", new LocalDate(1996, 8, 29));
        Person person2 = new Person("Zavodova", new LocalDate(2000, 7, 26));
        Person person3 = new Person("Nasonova", new LocalDate(1992, 2, 7));
        Person person4 = new Person("Sidorov", new LocalDate(1962, 12, 30));
        Person person5 = new Person("Simonov", new LocalDate(1996, 11, 29));
        Person person6 = new Person("Aaaaaav", new LocalDate(1996, 11, 27));
        System.out.println("Age of person: "+ person1.toString()+": "+person5.getAge());

        PersonList list = new PersonList(1);
        list.listAdd(person1);
        list.listAdd(person2);
        list.listAdd(person3);
        list.listAdd(person4);
        list.listAdd(person5);
        list.listAdd(person6);


        System.out.println("Before remove:");
        list.printPeople();

        list.listRemove(2);
        System.out.println("After remove:");
        list.printPeople();

        System.out.println("Search:");
        System.out.println(list.getPersonBy(1).toString());
        System.out.println(list.getPersonBy("Nasonova"));


        System.out.println("Cases: 1 for bubble sort, 2 for shaker sort");

        System.out.println("Bubble sort by ID");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getID()-o2.getID();
            }
        }, 1);
        list.printPeople();
        System.out.println("Bubble sort by age");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        }, 1);
        list.printPeople();
        System.out.println("Bubble sort by surname");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        }, 1);
        list.printPeople();

        System.out.println("Shaker sort by surname");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        }, 2);
        list.printPeople();
        System.out.println("Shaker sort by ID");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getID() - o2.getID();
            }
        }, 2);
        list.printPeople();
        System.out.println("Shaker sort by age");
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        }, 2);
        list.printPeople();



    }
}
