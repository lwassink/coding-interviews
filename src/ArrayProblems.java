import java.util.Collections;

/**
 * Created by lwassink on 6/9/17.
 */
public class ArrayProblems {
    public static enum Color { RED , WHITE , BLUE, GREEN }

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T> void printArray(T[] anArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(anArray[i]);
        }
        System.out.println(sb.toString());
    }

    private static void dutchFlag(Integer[] a, int pivotIdx) {
        Integer pivot = a[pivotIdx];
        int smaller = 0, larger = a.length;

        for (int i = 0; i < larger; i++) {
            if (a[i] < pivot) swap(a, i, smaller++);
            if (a[i] > pivot) swap(a, i, --larger);
        }
    }

    private static void fourColors(Color[] a) {
        int whiteOrd = 1;
        int smaller = 0, larger = a.length;
        for (int i = 0; i < larger; i++) {
            if (a[i].ordinal() < whiteOrd) swap(a, i, smaller++);
            if (a[i].ordinal() > whiteOrd) swap(a, i, --larger);
        }

        int greenOrd = 3, nextGreen = a.length;
        for (int i = smaller; i < nextGreen; i++) {
            if (a[i].ordinal() == greenOrd) swap(a, i, --nextGreen);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi there!");
        Integer[] a = {3,1,3,5,2,4,7,3};
        dutchFlag(a, 0);
        printArray(a);

        Color[] colorArray = {
                Color.BLUE,
                Color.GREEN,
                Color.RED,
                Color.WHITE,
                Color.BLUE,
                Color.GREEN,
                Color.RED,
                Color.WHITE,
                Color.BLUE,
                Color.GREEN,
                Color.RED,
                Color.WHITE
        };
        fourColors(colorArray);
        printArray(colorArray);
    }
}
