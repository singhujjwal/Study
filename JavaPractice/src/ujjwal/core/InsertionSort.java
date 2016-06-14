package ujjwal.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

    final static int i = 32;

    public static List<Integer> insertionSort(final List<Integer> numbers) {
        final List<Integer> sortedList = new LinkedList<Integer>();
        originalList: for (Integer number : numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (number < sortedList.get(i)) {
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }

        return sortedList;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(3);
        unsorted.add(1);
        unsorted.add(2);
        unsorted.add(66);
        unsorted.add(-11);
        unsorted.add(0x21);
        unsorted.add(3312);
        unsorted.add(332);
        unsorted.add(13);
        List<Integer> a = insertionSort(unsorted);
        a.add(3, 213);

        for (Integer number : a) {
         System.out.println(number);
        }

    }

}
