package tema2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyList<T> {

   // List<T> list = new ArrayList<>();

    private T[] array;
    private int size;
    private int dimension;

    public MyList(Class<T> cl, Integer dimension) {

            array = (T[])Array.newInstance(cl, dimension);
            size = 0;
            this.dimension = dimension;
    }

    public MyList() {

    }

    public void add(T element) {

        if (size < dimension)
            array[size++] = element;
    }

    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    // check if the element is in the list
    public boolean lookup(T element) {

        for (int i = 0; i < size; i++) {

            if (array[i] == element) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        MyList<Integer> list1 = new MyList<Integer>(Integer.class, 5);
        list1.add(3);
        list1.add(5);
        list1.print();
        
        if (list1.lookup(3))
            System.out.println("True");


    }
}
