package Generics.Exercises;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public void swap(int index1, int index2) {
        T firstElement = this.list.get(index1);
        T secondElement = this.list.get(index2);
        this.list.set(index1,secondElement );
        this.list.set(index2, firstElement);
    }
        public int countGrater(T element){
        return (int)this.list.stream().filter(e-> e.compareTo(element)>0).count();
}
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T t : list) {
            builder.append(t.getClass().getName()).append(": ").append(t).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
