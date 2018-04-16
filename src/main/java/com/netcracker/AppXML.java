package com.netcracker;


import com.netcracker.collections.CarList;
import com.netcracker.collections.PersonList;
import com.netcracker.entities.Car;
import com.netcracker.entities.Person;
import org.joda.time.LocalDate;

public class AppXML {
    public static void main( String[] args ) {
        String fileNamePersons = "C:\\Users\\mllev\\Desktop\\laba01\\src\\main\\resources\\persons.xml";
        String fileNameCars = "C:\\Users\\mllev\\Desktop\\laba01\\src\\main\\resources\\cars.xml";
        Converter converter = new Converter();

        PersonList list = new PersonList(1);
        Person person1 = new Person("Sunders", new LocalDate(1992, 8, 29));
        Person person2 = new Person("Jonson", new LocalDate(1958, 3, 18));
        list.add(person1); list.add(person2);

        converter.convertObjectToXml(list, fileNamePersons); // сохраняем объект в XML файл
        PersonList unmarshPerson1 =  (PersonList) converter.fromXmlToObject(fileNamePersons, new PersonList()); // восстанавливаем объект из XML файла
        unmarshPerson1.printItems();

        Car car1 = new Car("Nissan","gt-r", 123321);
        Car car2 = new Car("Opel","astra", 123456);
        CarList carList = new CarList(1);
        carList.add(car1); carList.add(car2);

        converter.convertObjectToXml(carList, fileNameCars);
        CarList unmarshCar1 = (CarList) converter.fromXmlToObject(fileNameCars, new CarList()); // восстанавливаем объект из XML файла
        unmarshCar1.printItems();

    }
}
