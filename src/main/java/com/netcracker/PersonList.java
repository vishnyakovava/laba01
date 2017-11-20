package com.netcracker;

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

    /**
     * Конструктор
     * @param quantity - начальная емкость
     */
    public PersonList(int quantity){
        this.people = new Person[quantity];
        this.quantity = quantity;
    }

    /**
     * Метод добавления элемента в список
     * @param person
     */
    public void listAdd(Person person){
        if(counter == quantity){
            Person[] newPeople  = new Person[quantity+1]; //*2
            System.arraycopy(people, 0, newPeople, 0, people.length);
            people = newPeople;
            quantity++; //*2
        }
        people[counter] = person;
        counter++;
    }

    /**
     * Метод удаления элемента из списка
     * @param id - идентификатор человека
     */
    public  void listRemove(int id){
        Person[] new1 = new Person[people.length - 1];
        for(int i=0; i<people.length; i++){
            if(people[i].getID()==id){
                System.arraycopy(people, 0, new1, 0, i);
                System.arraycopy(people, i+1, new1, i, people.length-i-1);
                people = new1;
            }
        }
        counter--;
    }

    /**
     * Метод удаления элемента из списка
     * @param person - объект класса Person
     */
    public void listRemove(Person person) {
        Person[] new1 = new Person[people.length - 1];
        for(int i=0; i< people.length; i++){
            if (people[i].equals(person)) {
                System.arraycopy(people, 0, new1, 0, i);
                System.arraycopy(people, i+1, new1, i, people.length-i-1);
                people = new1;
            }
        }
        counter--;
    }


    /**
     * Метод сравнения объектов класса Person
     * @param person - объект класса Person
     * @return
     */
    public boolean equals(Object person){
        if(this == person) return true;
        if(person == null) return false;
        if(getClass() != person.getClass()) return false;
        Person other = (Person) person;
        if(((Person) person).getID()!=other.getID() ) return false;
        if(((Person) person).getSurname() != other.getSurname()) return false;
        return true;
    }

    /**
     * Метод выода элементов списка людей
     */
    public void printPeople(){
        for(int i=0; i<people.length; i++){
            if (people[i] == null) break;
            System.out.println("ID: " +people[i].getID() + ", Surname: " + people[i].getSurname() + ", Date of birth: " + people[i].getBirthDate());
        }
    }
}
