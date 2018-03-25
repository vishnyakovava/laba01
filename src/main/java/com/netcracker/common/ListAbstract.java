package com.netcracker.common;

import com.netcracker.annotation.AutoInjectable;
import com.netcracker.collections.MyListT;
import com.netcracker.collections.PersonList;
import com.netcracker.injector.Injector;
import com.netcracker.sorter.Sorting;
import com.netcracker.sorter.generics.MySortableT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.function.Predicate;

public abstract class ListAbstract<T> implements ListInterface<T> {

    protected Object[] items;
    protected int quantity;
    protected int counter=0;
    protected MySortableT<T> sorter;
    private static final Logger log = LogManager.getLogger(PersonList.class.getName());

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
    public T[] toArray(){
        Object[] newItems =  new Object[counter];
        System.arraycopy(items, 0, newItems, 0, counter );
        return (T[])newItems;
    }

    /**
     * Добавление в список
     * @param item элеиент добавления
     */
    public void add(Object item){
        if(counter == quantity){
            Object[] newPeople  = new Object[quantity*2];
            System.arraycopy(items, 0, newPeople, 0, items.length);
            items = newPeople;
            quantity*=2;
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
    public T[] find(Predicate<T> predicate){
        MyListT<T> listT = new MyListT<>(5);
        for(int i=0; i<counter; i++){
            if(predicate.test((T)items[i]))
                listT.add((T)items[i]);
        }
        return (T[])listT.toArray();
    }

    /**
     * Устанавливает вид сортировки
     * @param sorter вид сортировки
     */
    public void setSorter(MySortableT<T> sorter){
//        this.sorter = sorter;
    }

    /**
     * Сортировка списка
     * @param comp параметр сортировки
     */
    public void sortBy(Comparator<T> comp){
        Sorting sorter = (Sorting) (new Injector()).inject(new Sorting());
        log.debug("sort type"+sorter.toString());
        sorter.sort((T[])items, comp, counter);
    }



}
