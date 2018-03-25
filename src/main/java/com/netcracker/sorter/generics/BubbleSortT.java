package com.netcracker.sorter.generics;
import java.util.Comparator;

public class BubbleSortT<T> implements MySortableT<T>{
    public void sort(T[] mas, Comparator<T> comparator, int counter) {
        System.out.println("Sort type: bubble");
        T temp;
        for(int i=0; i<counter-1; i++) {
            for (int j = counter - 1; j > i; j--) {
                if (comparator.compare((T)mas[j - 1], (T)mas[j]) >= 1) {
                    temp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j - 1] = temp;
                }
            }
        }
    }
}
