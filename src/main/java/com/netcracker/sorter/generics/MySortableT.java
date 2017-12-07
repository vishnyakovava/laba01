package com.netcracker.sorter.generics;
import java.util.Comparator;

public interface MySortableT<T> {
    void sort(T[] mas, Comparator<T> comparator, int counter);
}
