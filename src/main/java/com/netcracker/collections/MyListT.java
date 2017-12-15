package com.netcracker.collections;
import com.netcracker.common.ListAbstract;
import com.netcracker.sorter.generics.BubbleSortT;
import com.netcracker.sorter.generics.MySortableT;
import java.util.Comparator;
import java.util.Iterator;

public class MyListT<T> extends ListAbstract<T> implements Iterable<T> {

    /**
     * Конструктор класса
     * @param quantity изначальный размер
     * @param <T> параметр типа
     */
    public <T> MyListT(int quantity) {
        this.items = new Object[quantity];
        this.quantity = quantity;
        this.sorter = new BubbleSortT();
    }

    /**
     * Возвращает i-ый элемент из списка
     * @param i
     * @return
     */
    public T get(int i) {
        return (T) items[i];
    }

    /**
     * Установка параметра сортировки
     * @param sorter - параметр сортировки из MySortable - вид сортировки
     */
    public void setSorter(MySortableT sorter) { this.sorter = sorter; }

    /**
     * Сортировка по определенному параметру, передаваемому в компаратор
     * @param comp - компаратор
     */
    public void sortBy(Comparator<T> comp) { sorter.sort((T[]) items, comp, counter); }

    /**
     * Вывод элементов из списка на экран
     */
    public void printItems(){
        for(int i=0; i<counter; i++){
            if (items[i] == null) break;
            System.out.println(items[i].toString());
        }
    }

    /**
     *
     * @return итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    /**
     * класс итератора
     * @param <T> обобщенный параметр
     */
    class MyIterator<T> implements  Iterator<T>{
        int currentItem=0;
        @Override
        public boolean hasNext() {
            return currentItem<counter;
        }

        @Override
        public T next() {
            return (T)items[currentItem++];
        }
    }

}
