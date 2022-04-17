package Generics.Exercises.CustomList7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
       this.elements.add(element);
    }

    public T remove(int index){
        return this.elements.remove(index);
    }
    public boolean contains(T element){
        return this.elements.contains(element);
    }
    public void swap(int index, int index1){
        T element = this.elements.get(index);
        T element1 = this.elements.get(index1);
        this.elements.set(index, element1);
        this.elements.set(index1, element);
    }
    public int countGreaterThan(T element){
        return (int)this.elements.stream().filter(e-> e.compareTo(element)>0).count();
    }
    public T getMax(){
        return this.elements.stream().max((a,b) -> a.compareTo(b)).get();
    }
    public T getMin(){
        return this.elements.stream().min((a,b) -> a.compareTo(b)).get();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext(){
                return index< elements.size();
            }
            @Override
            public T next(){
                return elements.get(index++);
            }
        };
    }
}
