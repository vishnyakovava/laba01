package com.netcracker.collections;

import com.netcracker.common.ListAbstract;
import com.netcracker.entities.Car;
import com.netcracker.entities.Person;
import com.netcracker.sorter.generics.BubbleSortT;

import java.util.Comparator;
import java.util.function.Predicate;

public class RepCar extends ListAbstract<Car> {

    /**
     * Конструктор класса
     * @param quantity изначальный размер списка
     */
    public RepCar(int quantity){
        this.items = new Person[quantity];
        this.quantity = quantity;
        this.sorter = new BubbleSortT();
    }

    /**
     * Выбирает i-ый элемент из списка
     * @param i номер эелемента в списке
     * @return i-ый элемент
     */
    @Override
    public Car get(int i) {
        return (Car)items[i];
    }


    /**
     * Поиск по бренду
     * @param brand бренд
     * @return
     */
    public Car[] findByBrand(String brand){
        return find(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getBrand().equals(brand);
            }
        });
    }

    /**
     * Поиск по ID
     * @param id
     * @return
     */
    public Car[] findByID(int id){
        return find(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getID()==id;
            }
        });
    }

    /**
     * поиск по модели машины
     * @param model модель
     * @return
     */
    public Car[] findByModel(String model){
        return find(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getModel().equals(model);
            }
        });
    }

    /**
     * поиск по серийному нормеру
     * @param serialNumber серийный номер
     * @return
     */
    public Car[] findBySerialNumber(int serialNumber){
        return find(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getSerialNumber()==serialNumber;
            }
        });
    }

    /**
     * Сортировка по бренду
     */
    public void sortByBrand(){
        sortBy(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        });
    }

    /**
     * сортировка по модели
     */
    public void sortByModel(){
        sortBy(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
    }

    /**
     * Сортировка по серийному номеру
     */
    public void sortBySerialNumber(){
        sortBy(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getSerialNumber() - o2.getSerialNumber();
            }
        });
    }

    /**
     * Сортировка по ID
     */
    public void sortByID(){
        sortBy(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getID() - o2.getID();
            }
        });
    }





}
