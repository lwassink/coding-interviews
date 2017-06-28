import java.util.HashMap;
import java.util.*;

/**
 * Created by lwassink on 6/21/17.
 */
public class MapProblems {
    public static boolean isConstructible(String letter, String mag) {
        int[] counts = new int[26];
        int total = letter.length();

        for (char c : letter.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : mag.toCharArray()) {
            if (counts[c - 'a']-- > 0) total--;
            if (total <= 0) return true;
        }

        return false;
    }

    public static boolean isConstructibleArbAlphabet(String letter, String mag) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        int total = letter.length();

        for (char c : letter.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            } else {
                charCounts.put(c, 1);
            }
        }

        for (char c : mag.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) - 1);
                if (charCounts.get(c) >= 0) total--;
            }
            if (total <= 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isConstructible("aaba", "bababa"));  // true
        System.out.println(isConstructible("x", "x"));          // true
        System.out.println(isConstructible("xy", "xx"));        // false
        System.out.println(isConstructible("aabb", "abacc"));   // false

        System.out.println(isConstructibleArbAlphabet("aaba", "bababa"));  // true
        System.out.println(isConstructibleArbAlphabet("x", "x"));          // true
        System.out.println(isConstructibleArbAlphabet("xy", "xx"));        // false
        System.out.println(isConstructibleArbAlphabet("aabb", "abacceq"));   // false
    }

    public static class Student implements Comparable<Student> {
        public String name;
        public double gpa;

        public int compareTo (Student that) { return name.compareTo(that.name); }

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }
    }

    public static void sortByName(List<Student> students) {
        Collections.sort(students);
    }

    public static void sortByGPA(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Double.compare(a.gpa, b.gpa);
            }
        });
    }
}
