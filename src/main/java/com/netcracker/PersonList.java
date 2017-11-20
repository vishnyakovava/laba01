package com.netcracker;

public class PersonList {
    private Person[] people;
    private int quantity; // передаем в конструктор для обозначения изначального размера массива
    private int counter=0; //к-во людей в массиве

    public PersonList(int quantity){
        this.people = new Person[quantity];
        this.quantity = quantity;
    }

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
     * @param id
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
    public boolean equals(Object person){
        if(this == person) return true;
        if(person == null) return false;
        if(getClass() != person.getClass()) return false;
        Person other = (Person) person;
        if(((Person) person).getID()!=other.getID() ) return false;
        if(((Person) person).getSurname() != other.getSurname()) return false;
        return true;
    }

    public void printPeople(){
        for(int i=0; i<people.length; i++){
            if (people[i] == null) break;
            System.out.println("ID: " +people[i].getID() + ", Surname: " + people[i].getSurname() + ", Date of birth: " + people[i].getBirthDate());
        }
    }
}
