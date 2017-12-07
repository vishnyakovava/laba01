package test;

import com.netcracker.entities.Person;
import com.netcracker.collections.PersonList;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class MyListTest {

    private PersonList list = new PersonList(1);
    private Person personTest1, personTest2, personTest3,p;

    @Before
    public void runBefore(){
        personTest1 = new Person("Surname", new LocalDate(1992, 5, 6));
        personTest2 = new Person("Aaa", new LocalDate(1968, 7, 1));
        personTest3 = new Person("Name", new LocalDate(1990, 1, 11));
    }

    @After
    public  void afterRun(){
        list = null;
    }

    @Test
    public void add() throws Exception {
        list.add(personTest1);
        assertEquals(1,list.size());
        list.add(personTest2);
        assertEquals(2, list.size());
        assertEquals(personTest1, list.get(0));
        assertEquals(personTest2, list.get(1));

    }

    @Test
    public void remove() throws Exception {

        list.add(personTest1);
        list.add(personTest2);
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    public void find() throws Exception {

        list.add(personTest1);
        list.add(personTest2);
        p = list.find(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getSurname().equals("Surname");
            }
        });
        String str = p.getSurname();
        assertEquals("Surname", str);
    }

    @Test
    public void sortPersonByTest(){
        list.add(personTest1);
        list.add(personTest2);
        list.add(personTest3);

        list.sortPersonBy(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        assertEquals("Surname", list.get(0).getSurname());
        assertEquals("Name", list.get(1).getSurname());
        assertEquals("Aaa", list.get(2).getSurname());
    }

    @Test
    public void getTest(){
        list.add(personTest1);
        String str = list.get(0).getSurname();
        assertEquals("Surname", str);
    }

    @Test
    public void sizeTest(){
        list.add(personTest1);
        list.add(personTest2);
        int actualSize = list.size();
        assertEquals(2, actualSize);
    }
}