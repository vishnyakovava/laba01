package com.netcracker.collections;
// переделать на обобщенный список
// добавтиь еще сущность машина,репозиторий машин
// сделать интерфейс репозитория, какие методы общие для всех репозиториев, которые можно вытащить в абстрактный класс репозиториев.

import com.netcracker.entities.Person;
import com.netcracker.sorter.BubbleSort;
import com.netcracker.sorter.MySortable;
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
    public void add(Person person){
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
     * @param index - индекс в массиве
     */
    public  void remove(int index){
        Person[] new1 = new Person[quantity - 1];
        System.arraycopy(people, 0, new1, 0, people.length-index-1);
        System.arraycopy(people, index+1, new1, index, people.length-index-1);
        people = new1;
        counter--;
        quantity--;
    }

    /**
     * Метод вывода элементов списка людей
     */
    public void printItems(){
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
    public Person find(Predicate<Person> predicate){
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