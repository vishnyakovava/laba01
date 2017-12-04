package com.netcracker.lab1.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Класс человека
 * @author Valeria Vishnyakova
 */
public class Person {
    /** Поле фамилия*/
    private String surname;
    /** Поле дата рождения*/
    private LocalDate birthDate;
    /** Поле индентификатор*/
    private int ID; // индентификатор
    private static int id=0;

    /**
     * Конструктор класса Person
     * @param surname - фамилия
     * @param birthDate - дата рождения
     */
    public Person(String surname, LocalDate birthDate){
        setSurname(surname);
        setBirthDate(birthDate);
        id++;
        this.ID = id;
    }

    /**
     * Метод подсчета возраста
     * @return возраст человека
     */
    public int getAge(){
        DateTime current = new DateTime();
        int age = current.getYear() - birthDate.getYear();
        if(birthDate.getMonthOfYear()>current.getMonthOfYear()) age--;
        if(birthDate.getMonthOfYear()==current.getMonthOfYear() && birthDate.getDayOfMonth()>current.getDayOfMonth()) age--;
        return age;
    }

    /**
     * Сеттер поля ID
     * @param ID - идентификатор человека
     */
    private void setID(int ID){
        this.ID = ID;
    }

    /**
     * Геттер поля ID
     * @return ID человека
     */
    public int getID(){ return ID;
    }

    /**
     * Сеттер поля фамилия
     * @param surname - фамилия
     */
    private void setSurname(String surname){
        this.surname = surname;
    }

    /**
     * Геттер поля фамилия
     * @return фамилию человека
     */
    public String getSurname(){ return surname;
    }

    /**
     * Сеттер поля дата рождения
     * @param birthDate - дата рождения
     */
    private void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    /**
     * Геттер поля дата рождения
     * @return дату рождения человека
     */
    public LocalDate getBirthDate(){ return birthDate; }


    /**
     * Переопределние метода toString()
     * @return
     */
     public String toString(){
        return "Surname:"+getSurname()+", ID:"+getID()+", Date of birth:"+getBirthDate();
     }
}