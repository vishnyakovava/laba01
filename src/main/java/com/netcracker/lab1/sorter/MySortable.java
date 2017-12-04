package com.netcracker.lab1.sorter;

import com.netcracker.lab1.entities.Person;

import java.util.Comparator;

public interface MySortable {
    void sort(Person[] mas, Comparator comparator, int counter);
}
