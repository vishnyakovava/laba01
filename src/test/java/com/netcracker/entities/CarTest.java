package com.netcracker.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car1=new Car("Nissan","gt-r", 123321);

    @Test
    public void getID() throws Exception {
        int actual = car1.getID();
        assertEquals(1, actual);
    }

    @Test
    public void getBrand() throws Exception {
        String actual = car1.getBrand();
        assertEquals("Nissan", actual);
    }

    @Test
    public void getModel() throws Exception {
        String actual = car1.getModel();
        assertEquals("gt-r", actual);
    }

    @Test
    public void getSerialNumber() throws Exception {
        int actual = car1.getSerialNumber();
        assertEquals(123321, actual);
    }

}