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
        Person person1 = new Person("String", new LocalDate(1996, 10, 26));
        Person person2 = new Person("fgeg", new LocalDate(2000, 5, 6));
        Person person3 = new Person("hjryhjxryj", new LocalDate(1992, 2, 7));
        Person person4 = new Person("hbgbfgbyj", new LocalDate(1962, 12, 30));
        Person person5 = new Person("New", new LocalDate(2000, 7, 1));
        System.out.println("Age of person1: "+person1.age());

        PersonList list = new PersonList(1);
        list.listAdd(person1);
        list.listAdd(person2);
        list.listAdd(person3);
        list.listAdd(person4);
        list.listAdd(person5);
        System.out.println("Before remove:");
        list.printPeople();

        list.listRemove(2);
        System.out.println("After remove:");
        list.printPeople();

        System.out.println("Search:");
        System.out.println(list.getPersonBy(1).toString());
        System.out.println(list.getPersonBy("New"));

        System.out.println("Sort:");
       /* list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getID()-o2.getID();
            }
        });
        list.printPeople();
        list.sortPersonBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.age()-o2.age();
            }
        });
        list.printPeople();*/

    }
}
