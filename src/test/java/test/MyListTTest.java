package test;

import com.netcracker.collections.MyListT;
import com.netcracker.entities.Car;
import com.netcracker.entities.Person;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MyListTTest {
    Person person1, person2, person3;
    MyListT<Person> list = new MyListT<Person>(1);

    @Before
    public void runBefore(){
        person1 = new Person("Maslov", new LocalDate(1996, 8, 29));
        person2 = new Person("Zavodova", new LocalDate(2000, 7, 26));
        person3 = new Person("Nasonova", new LocalDate(1992, 2, 7));
        list.add(person1); list.add(person2); list.add(person3);
    }

    @After
    public  void afterRun(){
        list = null;
    }

    @Test
    public void get() throws Exception {
        list.get(0);
        assertEquals(1,list.get(0).getID());
    }

    @Test
    public void sortBy() throws Exception {
        list.sortBy(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        assertEquals("Maslov", list.get(0).getSurname());
    }

}