package com.netcracker.collections;

import com.netcracker.common.ListAbstract;
import com.netcracker.entities.Person;
import com.netcracker.injector.Injector;
import com.netcracker.sorter.Sorting;
import com.netcracker.sorter.generics.BubbleSortT;
import com.netcracker.sorter.generics.MySortableT;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Predicate;

public class RepPerson extends ListAbstract<Person>{

    public RepPerson(int quantity){
        this.items = new Person[quantity];
        this.quantity = quantity;
        this.sorter = new BubbleSortT();
    }

    @Override
    public void setSorter(MySortableT<Person> sorter) {
        this.sorter = sorter;
    }

    /**
     * Выбирает i-ый элемент из списка
     * @param i номер эелемента в списке
     * @return i-ый элемент
     */
    @Override
    public Person get(int i){
        return (Person)items[i];
    }

    /**
     * Поиск по фамилии
     * @param fio фамилия
     * @return
     */
    public Person[] findByFio(String fio){
        return find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getSurname().equals(fio);
            }
        });
    }

    /**
     * Поиск по возрасту
     * @param age возраст
     * @return массив элементов, удовлетворяющих поиску условию поиска
     */
    public Person[] findByAge(int age){
        return find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge()==age;
            }
        });
    }

    /**
     * Поиск по ID
     * @param id
     * @return массив элементов, удовлетворяющих поиску условию поиска
     */
    public Person[] findByID(int id){
        return find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getID()==id;
            }
        });
    }

    /**
     * Поиск по дате рождения
     * @param date дата рождения
     * @return массив элементов, удовлетворяющих поиску условию поиска
     */
    public Person[] findByBidthDate(LocalDate date){
        return find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getBirthDate().equals(date);
            }
        });
    }

    /**
     * Сортировка по фамилии
     */
    public void sortBySurname(){
       sortBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
    }

    /**
     * Сортировка по возрасту
     */
    public void sortByAge(){
        sortBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    public void printItems(){
        for(int i=0; i<counter; i++){
            if (items[i] == null) break;
            System.out.println(items[i].toString());
        }
    }
}
