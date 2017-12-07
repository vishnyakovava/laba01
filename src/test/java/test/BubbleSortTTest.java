package test;

import com.netcracker.collections.PersonList;
import com.netcracker.entities.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class BubbleSortTTest {
    Person personTest1, personTest2, personTest3;
    PersonList list = new PersonList(1);
    @Before
    public void runBefore(){
        personTest1 = new Person("Surnamee", new LocalDate(1992, 5, 6));
        personTest2 = new Person("Aaab", new LocalDate(1968, 7, 1));
        personTest3 = new Person("Name", new LocalDate(1998, 1, 11));
        list.add(personTest1); list.add(personTest2); list.add(personTest3);
    }

    @Test
    public void sort() throws Exception {
        list.sortBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        assertEquals("Aaab", list.get(0).getSurname());
    }

}