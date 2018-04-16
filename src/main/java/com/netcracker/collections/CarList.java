package com.netcracker.collections;

import com.netcracker.entities.Car;
import com.netcracker.sorter.BubbleSort;
import com.netcracker.sorter.MySortable;

import javax.xml.bind.annotation.*;
import java.util.Comparator;
import java.util.function.Predicate;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarList {
    @XmlElement(name = "car")
    private Car[] parking;
    @XmlElement
    private int capacity;
    @XmlElement
    private  int counter = 0;
    @XmlTransient
    private MySortable sorter;

    public CarList(int capacity){
        this.parking = new Car[capacity];
        this.capacity = capacity;
        this.sorter = new BubbleSort();
    }

    public CarList(){}

    public int size(){
        return counter;
    }

    public Car get(int i){
        return parking[i];
    }

    public void add(Car person){
        if(counter == capacity){
            Car[] newPeople  = new Car[capacity*2];
            System.arraycopy(parking, 0, newPeople, 0, parking.length);
            parking = newPeople;
            capacity*=2;
        }
        parking[counter] = person;
        counter++;
    }

    public  void remove(int index){
        Car[] new1 = new Car[capacity - 1];
        System.arraycopy(parking, 0, new1, 0, parking.length-index-1);
        System.arraycopy(parking, index+1, new1, index, parking.length-index-1);
        parking = new1;
        counter--;
        capacity--;
    }

    public void printItems(){
        for(int i=0; i<counter; i++){
            if (parking[i] == null) i++;
            System.out.println(parking[i].toString());
        }
    }

    public Car find(Predicate<Car> predicate){
        for(int i=0; i<counter; i++){
            if(predicate.test(parking[i]))
                return parking[i];
        }
        return null;
    }

    public void setSorter(MySortable sorter){
        this.sorter = sorter;
    }

    public void sortPersonBy(Comparator<Car> comp){
        sorter.sort(parking, comp, counter);
    }

}
