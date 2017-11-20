package com.netcracker;
import org.joda.time.LocalDate;
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
        System.out.println("Age of person1: "+person1.age());

        PersonList list = new PersonList(1);
        list.listAdd(person1);
        list.listAdd(person2);
        list.listAdd(person3);
        System.out.println("Before remove:");
        list.printPeople();

        list.listRemove(2);
        System.out.println("After remove:");
        list.printPeople();
    }
}
