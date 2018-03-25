package com.netcracker.collections;

import com.netcracker.common.ListAbstract;
import com.netcracker.entities.Person;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import  java.util.function.Predicate;
import java.util.Comparator;

public class PersonList extends ListAbstract<Person> {
    /** Поле массив людей*/
    private Person[] people;
    /** Поле размера массива при создании списка людей*/
    private int quantity; // передаем в конструктор для обозначения изначального размера массива
    /** Поле количества людей в массиве*/
    private int counter=0;

    private static final Logger log = LogManager.getLogger(PersonList.class.getName());


    /**
     * Конструктор
     * @param quantity - начальная емкость
     */
    public PersonList(int quantity){
        this.people = new Person[quantity];
        this.quantity = quantity;
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
            System.out.println(people[i].toString() +" Age: "+people[i].getAge());
        }
    }

    /**
     * Универсальный поиск по коллекции
     * @param predicate - предикат
     * @return объект, найденный по параметру поиска
     */
    public Person[] find(Predicate<Person> predicate){
        PersonList listP = new PersonList(5);
        for(int i=0; i<counter; i++){
            if(predicate.test(people[i]))
                listP.add(people[i]);
        }
        return listP.toArray();
    }


    /**
     * Установка параметра сортировки
     */
    public void setSorter(PropertiesConfiguration config){
       /* try {
            config = new PropertiesConfiguration("app.properties");
            String sortType = config.getString("sorter");
            switch(sortType) {
                case "bubble": this.sorter = new BubbleSort();
                case "shaker": this.sorter = new ShakerSort();
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }*/
    }


    /**
     * Сортировка
     * @param comp компаратор
     */
    public void sortBy(Comparator<Person> comp){
//        Sorting sorter = (Sorting) (new Injector()).inject(new Sorting());
//        log.debug("sort type"+sorter.toString());
        sorter.sort(people, comp, counter);

    }
}
