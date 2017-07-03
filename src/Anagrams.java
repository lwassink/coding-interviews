/**
 * Created by lwassink on 6/19/17.
 */
import java.util.*;
import java.util.LinkedList;

public class Anagrams {
    public static List<List<String>> anagrams(List<String> words) {
        Map<String, List<String>> m = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sword = new String(chars);

            if (m.containsKey(sword)) {
                m.get(sword).add(word);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                m.put(sword, temp);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> syns : m.values()) {
            if (syns.size() > 1) result.add(syns);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }

        int[] x = {1, 3};
        System.out.println(x['b' - 'a']);

        String[] words = {"ab", "cat", "ba", "tac", "act", "light"};
        System.out.println(anagrams(Arrays.asList(words)));
    }
}
