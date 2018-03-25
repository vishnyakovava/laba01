package com.netcracker.sorter.generics;

import com.netcracker.entities.Person;

import java.util.Comparator;

public class ShakerSortT<T> implements MySortableT<T>{
    public void sort(T[] mas, Comparator<T> comparator, int counter) {
        System.out.println("Sort type: shaker");
        boolean wasSwapped;
        T temp;
        do {
            wasSwapped=false;
            for (int i = 0; i < counter - 2; i++) {
                if (comparator.compare((T)mas[i], (T)mas[i + 1])>=1) {
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                    wasSwapped=true;
                }
            }

            if(!wasSwapped) break;

            wasSwapped=false;
            for (int j = counter-2; j >= 0; j--) {
                if(comparator.compare((T)mas[j],(T)mas[j+1])>=1){
                    temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]=temp;
                    wasSwapped=true;
                }
            }

        } while(wasSwapped);
    }
}
