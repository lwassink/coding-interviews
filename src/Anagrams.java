/**
 * Created by lwassink on 6/19/17.
 */
import java.util.*;

public class Anagrams {
    public static boolean areAnagrams(String str1, String str2) {
        int[] charCounts = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            charCounts[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCounts[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }

        int[] x = {1, 3};
        System.out.println(x['b' - 'a']);
    }
}
