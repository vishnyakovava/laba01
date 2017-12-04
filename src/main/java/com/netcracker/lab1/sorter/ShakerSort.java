package com.netcracker.lab1.sorter;

import com.netcracker.lab1.entities.Person;

import java.util.Comparator;

public class ShakerSort implements MySortable {
    /**
     * Шейкерная сортировка
     * @param mas - массив, который сортируем
     * @param comparator - компаратор
     * @return отсортированный массив
     */
    @Override
    public void sort(Person[] mas, Comparator comparator, int counter) {
        boolean wasSwapped;
        Person temp;
        do {
            wasSwapped=false;
            for (int i = 0; i < counter - 2; i++) {
                if (comparator.compare(mas[i], mas[i + 1])>=1) {
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                    wasSwapped=true;
                }
            }

            if(!wasSwapped) break;

            wasSwapped=false;
            for (int j = counter-2; j >= 0; j--) {
                if(comparator.compare(mas[j],mas[j+1])>=1){
                    temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]=temp;
                    wasSwapped=true;
                }
            }

        } while(wasSwapped);
    }
}
