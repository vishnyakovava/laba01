package com.netcracker.lab1.collections;
// сделать возможнотсь сортировки людей по фамилии, по возрасту, по id.сделать универсально.
// использовать разные виды сортировок. поиск (по тем же параметрам)
//
// добавить поддержку unitest (подсчет возраста, сортировка)


import com.netcracker.lab1.entities.Person;
import com.netcracker.lab1.sorter.BubbleSort;
import com.netcracker.lab1.sorter.MySortable;

import  java.util.function.Predicate;
import java.util.Comparator;

/**
 * Класс списка людей
 * @author Valeria Vishnyakova
 */
public class PersonList {
    /** Поле массив людей*/
    private Person[] people;
    /** Поле размера массива при создании списка людей*/
    private int quantity; // передаем в конструктор для обозначения изначального размера массива
    /** Поле количества людей в массиве*/
    private int counter=0;
    /** Параметр сортировки*/
    private MySortable sorter;

    /**
     * Конструктор
     * @param quantity - начальная емкость
     */
    public PersonList(int quantity){
        this.people = new Person[quantity];
        this.quantity = quantity;
        this.sorter = new BubbleSort();
    }

    /**
     * Размер списка
     * @return размер
     */
    public int size(){
        return counter;
    }

    /**
     * Выбирает i-ый элемент из списка
     * @param i номер эелемента в списке
     * @return i-ый элемент
     */
    public Person get(int i){
        return people[i];
    }

    /**
     * Метод добавления элемента в список
     * @param person
     */
    public void listAdd(Person person){
        if(counter == quantity){
            Person[] newPeople  = new Person[quantity+1];
            System.arraycopy(people, 0, newPeople, 0, people.length);
            people = newPeople;
            quantity++;
        }
        people[counter] = person;
        counter++;
    }

    /**
     * Метод удаления элемента из списка
     * @param id - идентификатор человека
     */
    public  void listRemove(int id){
        Person[] new1 = new Person[quantity - 1];
        for(int i=0; i<people.length; i++){
            if(people[i].getID()==id){
                System.arraycopy(people, 0, new1, 0, i);
                System.arraycopy(people, i+1, new1, i, people.length-i-1);
                people = new1;
            }
        }
        counter--;
        quantity--;
    }

    /**
     * Метод вывода элементов списка людей
     */
    public void printPeople(){
        for(int i=0; i<counter; i++){
            if (people[i] == null) break;
            System.out.println("ID: " +people[i].getID() + ", Surname: " + people[i].getSurname() + ", Date of birth: " + people[i].getBirthDate() +" Age: "+people[i].getAge());
        }
    }

    /**
     * Универсальный поиск по коллекции
     * @param predicate - предикат
     * @return объект, найденный по параметру поиска
     */
    public Person findPerson(Predicate<Person> predicate){
        for(int i=0; i<counter; i++){
            if(predicate.test(people[i]))
                return people[i];
        }
        return null;
    }

    /**
     * Установка параметра сортировки
     */
    public void setSorter(MySortable sorter){
        this.sorter = sorter;
    }

    /**
     * Сортировка
     * @param comp компаратор
     */
    public void sortPersonBy(Comparator<Person> comp){
        sorter.sort(people, comp, counter);
    }
}
