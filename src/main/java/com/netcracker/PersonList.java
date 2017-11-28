package com.netcracker;
// сделать возможнотсь сортировки людей по фамилии, по возрасту, по id.сделать универсально.
// использовать разные виды сортировок. поиск (по тем же параметрам)
//
// добавить поддержку unitest (подсчет возраста, сортировка)

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
            System.out.println("ID: " +people[i].getID() + ", Surname: " + people[i].getSurname() + ", Date of birth: " + people[i].getBirthDate() +" Age: "+people[i].getAge());
        }
    }

    /**
     * Поиск в коллекции по ID
     * @param ID - индентификатор человека
     * @return объект класса Person с соответствующим ID
     */
    public Person getPersonBy(int ID){ //поиск по ID
        for(int i=0; i<people.length; i++){
            if(people[i].getID() == ID)
                return people[i];
        }
        return null;
    }

    /**
     * Поиск в коллекции по фамилии
     * @param surname - фамилия
     * @return объект класса Person с соответствующей фамлиией
     */
    public Person getPersonBy(String surname){ //поиск по surname
        for(int i=0; i<people.length; i++){
            if (people[i].getSurname().equals(surname)) {
                return people[i];
            }
        }
        return null;
    }

    /**
     * сортировка пузырьком
     * @param mas  - массив, который сортируем
     * @param comp - компаратор
     * @return отсортированный массив
     */
    private Person[] bubbleSort(Person[] mas, Comparator<Person> comp){
        Person temp;
        for(int i=0; i<counter-1; i++){
            for(int j=counter-1; j>i; j--){
                if(comp.compare(mas[j-1], mas[j])>=1){
                    temp=mas[j];
                    mas[j] = mas[j-1];
                    mas[j-1] = temp;
                }
            }
        }
        return mas;
    }

    /**
     * Шейкерная сортировка
     * @param mas - массив, который сортируем
     * @param comp - компаратор
     * @return отсортированный массив
     */
    public Person[] shakerSort(Person[] mas, Comparator<Person> comp){
        boolean wasSwapped;
        Person temp;
        do {
            wasSwapped=false;
            for (int i = 0; i < counter - 2; i++) {
                if (comp.compare(mas[i], mas[i + 1])>=1) {
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                    wasSwapped=true;
                }
            }

            if(!wasSwapped) break;

            wasSwapped=false;
            for (int j = counter-2; j >= 0; j--) {
                if(comp.compare(mas[j],mas[j+1])>=1){
                    temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]=temp;
                    wasSwapped=true;
                }
            }

        } while(wasSwapped);
        return mas;
    }

    /**
     * сортировка
     * @param comp - компаратор
     * @param change - переменная для кейсов
     * @return оотсортированный массив выбранной сортиовкой
     */
    public Person[] sortPersonBy(Comparator<Person> comp, int change){
        switch(change){
            case 1: return bubbleSort(people, comp);
            case 2: return shakerSort(people, comp);
            default: return null;
        }

    }
}
