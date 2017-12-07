package com.netcracker.sorter;

import com.netcracker.entities.Person;

import java.util.Comparator;

public interface MySortable {
    void sort(Object[] mas, Comparator comparator, int counter);
}
