package pl.camp.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayDiff {
    public static void main(String[] args) {
        /*Integer[] t1 = new Integer[] {1,1,2,2,3,4};
        Integer[] t2 = new Integer[] {2,3};*/

        int[] t1 = new int[] {1,1,2,2,3,4};
        int[] t2 = new int[] {2,3,1};

        int[] test = arrayDiff2(t1, t2);
        for(int element : test) {
            System.out.println(element);
        }
    }

    public static int[] arrayDiff2(int[] a1, int[] a2) {
        return IntStream.of(a1).filter(x -> !IntStream.of(a2).anyMatch(y -> y == x)).toArray();
    }

    public static int[] arrayDiff(Integer[] a1, Integer[] a2) {
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);

        for(int i = 0; i < l1.size(); i++) {
            if(!l2.contains(l1.get(i))) {
                l3.add(l1.get(i));
            }
        }

        /*Iterator<Integer> iterator = l1.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if(l2.contains(element)) {
                iterator.remove();
            }
        }*/

        int[] result = new int[l3.size()];
        for(int i = 0; i < l3.size(); i++) {
            result[i] = l3.get(i);
        }

        return result;
    }
}
