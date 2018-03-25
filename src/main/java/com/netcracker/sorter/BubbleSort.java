package com.netcracker.sorter;

import com.netcracker.entities.Person;

import java.util.Comparator;

public class BubbleSort implements MySortable {
    @Override
    /**
     * сортировка пузырьком
     * @param mas  - массив, который сортируем
     * @param comparator - компаратор
     * @return отсортированный массив
     */
    public void sort(Object[] mas, Comparator comparator, int counter) {
        System.out.println("Sort type: bubble");
        Object temp;
        for(int i=0; i<counter-1; i++) {
            for (int j = counter - 1; j > i; j--) {
                if (comparator.compare(mas[j - 1], mas[j]) >= 1) {
                    temp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j - 1] = temp;
                }
            }
        }
    }
}
