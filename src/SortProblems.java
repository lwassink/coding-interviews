/**
 * Created by lwassink on 6/22/17.
 */
import java.util.*;

public class SortProblems {
    public static List<Integer> intersection(List<Integer> a, List<Integer> b) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < a.size() && j < b.size()) {
            Integer aEl = a.get(i), bEl = b.get(j);
            if (aEl < bEl) { i++; }
            else if (bEl < aEl) { j++; }
            else {
                if (result.size() == 0 || result.get(result.size() - 1) != aEl) result.add(aEl);
                i++; j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] a = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
        Integer[] b = { 5, 5, 6, 8, 8, 9, 10, 10 };
        System.out.println(intersection(Arrays.asList(a), Arrays.asList(b))); // [5, 6, 8]

        List<Integer> aE = new ArrayList<>();
        List<Integer> bE = new ArrayList<>();
        System.out.println(intersection(aE, bE)); // []
    }
}
