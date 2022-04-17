package Generics.LAB.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator {


    public static <T> T[] create(int length, T item) {

        return create(item.getClass(), length, item);
    }
    @SuppressWarnings("uncheked")
    public static <T> T[] create(Class<?> cl, int length, T item) {
        T[] array = (T[]) Array.newInstance(cl, length);
        IntStream.range(0, length).forEach(i->array[i] = item);
        return array;
    }
}
