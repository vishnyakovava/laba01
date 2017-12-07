package com.netcracker.common;

import com.netcracker.sorter.generics.MySortableT;

import java.util.function.Predicate;

public abstract class ListAbstract<T> implements ListInterface<T> {
    protected Object[] items;
    protected int quantity;
    protected int counter=0;
    protected MySortableT<T> sorter;

    /**
     * @return размер коллекции
     */
    public int size(){
        return counter;
    }

    /**
     * @return выбирает i-ый элемент из списка
     */
    public abstract T get(int i);

    /**
     * @return возвращает массив без пустых ячеек
     */
    public Object[] toArray(){
        Object[] newItems =  new Object[counter];
        System.arraycopy(items, 0, newItems, 0, counter );
        items = newItems;
        return items;
    }

    /**
     * Добавление в список
     * @param item элеиент добавления
     */
    public void add(Object item){
        if(counter == quantity){
            Object[] newPeople  = new Object[quantity+1];
            System.arraycopy(items, 0, newPeople, 0, items.length);
            items = newPeople;
            quantity++;
        }
        items[counter] = item;
        counter++;
    }

    /**
     * Удаление из списка
     * @param index индекс жлемента в списке
     */
    public void remove(int index){
        Object[] new1 = new Object[quantity - 1];
        System.arraycopy(items, 0, new1, 0, items.length-index-1);
        System.arraycopy(items, index+1, new1, index, items.length-index-1);
        items = new1;
        counter--;
        quantity--;
    }

    /**
     * Удаление из списка по предикату
     * @param predicate предкат
     */
    public void removeByPredicate(Predicate<T> predicate){
        for(int i=0; i<counter; i++){
            if(predicate.test((T)items[i])){
                remove(i);
                return;
            }
        }
    }

    /**
     * Поиск по предикату
     * @param predicate
     * @return элемент списка
     */
    public T find(Predicate<T> predicate){
        for(int i=0; i<counter; i++){
            if(predicate.test((T)items[i]))
                return (T)items[i];
        }
        return null;
    }




}
