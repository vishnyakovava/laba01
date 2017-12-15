package com.netcracker.sorter;

import java.util.Comparator;

public interface MySortable {
    /**
     * Сортирока списка
     * @param mas список
     * @param comparator параметр сортировки
     * @param counter количество элементов в массиве
     */
    void sort(Object[] mas, Comparator comparator, int counter);
}
