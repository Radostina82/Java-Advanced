package Generics.LAB.GenericArrayCreator;

import Generics.LAB.GenericArrayCreator.ArrayCreator;

public class Main {
    public static void main(String[] args) {
        String [] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class,10, 0);
    }
}
