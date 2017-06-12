/**
 * Created by lwassink on 6/9/17.
 */
public class QuickSelect {
    public static int quickSelect(int[] a, int k) {
        if (k < 0 || k >= a.length) throw new java.lang.IllegalArgumentException();
        return quickSelect(a, k, 0, a.length);
    }

    private static int quickSelect(int[] a, int k, int start, int end) {
        int pivot = a[start], pivInd = start;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[pivInd];
                a[pivInd++] = temp;
            }
        }

        if      (pivInd > k)  return quickSelect(a, k, start, pivInd);
        else if (pivInd == k) return pivot;
        else                  return quickSelect(a, k, pivInd + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 3, 6, 1, 6, 3, 4};
        // 1 1 2 3 3 3 4 5 6 6
        System.out.println(quickSelect(a, 0)); // 1
        System.out.println(quickSelect(a, 9)); // 6
        System.out.println(quickSelect(a, 4)); // 3
        System.out.println(quickSelect(a, 6)); // 4
    }
}
