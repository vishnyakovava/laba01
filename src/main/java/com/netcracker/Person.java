package com.netcracker;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Person {
    private String surname;
    private LocalDate birthDate;
    private int ID;
    private static int id=0;

    public Person(String surname, LocalDate birthDate){
        setSurname(surname);
        setBirthDate(birthDate);
        id++;
        this.ID = id;
    }

    public int age(){
        int age=0;
        DateTime current = new DateTime();
        age = current.getYear() - birthDate.getYear();
        return age;
    }


    private void setID(int ID){
        this.ID = ID;
    }
    public int getID(){ return ID;
    }
    private void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){ return surname;
    }

    private void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate(){ return birthDate;
    }
}
