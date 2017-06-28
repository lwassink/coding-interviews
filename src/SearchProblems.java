/**
 * Created by lwassink on 6/18/17.
 */
import java.util.*;

public class SearchProblems {
    private static int bSearch(int[] arr, int target, int begin, int end) {
        if (begin >= end) return -1;

        int mid = begin + (end - begin) / 2;
        int el = arr[mid];
        int comp = Integer.compare(target, el);

        if      (comp < 0)  return bSearch(arr, target, begin, mid);
        else if (comp == 0) return mid;
        else                return bSearch(arr, target, mid + 1, end);
    }

    public static int bSearch(int[] arr, int target) {
        return bSearch(arr, target, 0, arr.length);
    }

    public static int iterBSearch(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] == target) {
                return mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }

    public static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length, mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] == target) {
                break;
            } else {
                high = mid;
            }
        }

        if (arr.length == 0 || arr[mid] != target) return -mid - 1;

        while (low < high) {
            if (arr[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }

        return mid;
    }

    public static int singlePassFirst(List<Integer> nums, Integer target) {
        int low = 0, high = nums.size() - 1, result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target <= nums.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (target.equals(nums.get(mid))) result = mid;
        }

        return result;
    }

    public static int ceil(List<Integer> nums, Integer target) {
        int low = 0, high = nums.size() - 1, result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target < nums.get(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 6};
        System.out.println(bSearch(arr, -5)); // -1
        System.out.println(bSearch(arr, 0)); // 0
        System.out.println(bSearch(arr, 2)); // 2
        System.out.println(bSearch(arr, 3)); // -1
        System.out.println(bSearch(arr, 6)); // 4
        System.out.println(bSearch(arr, 10)); // -1

        int[] arrWithRepeats = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(findFirst(arrWithRepeats, 108)); // 3
        System.out.println(findFirst(arrWithRepeats, 285)); // 6

        Integer[] x = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        List<Integer> listWithRepeats = Arrays.asList(x);
        System.out.println(singlePassFirst(listWithRepeats, 108)); // 3
        System.out.println(singlePassFirst(listWithRepeats, 285)); // 6

        System.out.println(ceil(listWithRepeats, 108)); // 5
        System.out.println(ceil(listWithRepeats, 285)); // 9
        System.out.println(ceil(listWithRepeats, -20)); // 0
        System.out.println(ceil(listWithRepeats, 500)); // -1
    }
}
