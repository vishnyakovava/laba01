package com.netcracker.common;

import com.netcracker.sorter.generics.MySortableT;

import java.util.Comparator;
import java.util.function.Predicate;

public interface ListInterface<T> {
    /**
     * Размер коллекции
     * @return размер
     */
    int size();

    /**
     * Берет i-ый эелемент списка
     * @return элемент
     */
    T get(int i);

    /**
     * Добавление в ксписок
     * @param item элемент
     */
    void add(Object item);

    /**
     * Удаление из списка
     * @param index индекс элемента в списке
     */
    void remove(int index);

    /**
     * Удаление по предикату
     * @param predicate предикат
     */
    void removeByPredicate(Predicate<T> predicate);

    /**
     * Поиск по предикату
     * @return найденный элемент
     */
    T[] find(Predicate<T> predicate);

}
