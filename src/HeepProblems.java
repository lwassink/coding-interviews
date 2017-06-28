/**
 * Created by lwassink on 6/18/17.
 */
import java.util.*;

public class HeepProblems {
    private static class ElWithSource {
        public Integer el;
        public int idx;
        public int source;

        public ElWithSource(Integer el, int idx, int source) {
            this.el = el;
            this.idx = idx;
            this.source = source;
        }
    }

    public static List<Integer> merge(List<List<Integer>> lists) {
        PriorityQueue<ElWithSource> heep = new PriorityQueue<>(lists.size(), new Comparator<ElWithSource>() {
            @Override
            public int compare(ElWithSource e1, ElWithSource e2) {
                return Integer.compare(e1.el, e2.el);
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) heep.add(new ElWithSource(lists.get(i).get(0), 0, i));
        }

        List<Integer> merged = new ArrayList<>();
        while (!heep.isEmpty()) {
            ElWithSource min = heep.poll();
            merged.add(min.el);
            if (min.idx < lists.get(min.source).size() - 1) heep.add(
                    new ElWithSource(
                        lists.get(min.source).get(min.idx + 1),
                        min.idx + 1,
                        min.source
                    )
            );
        }

        return merged;
    }

    public static void main(String[] args) {
        Integer[] a1 = {0, 2, 5, 6, 6};
        Integer[] a2 = {0, 3, 4, 7};
        Integer[] a3 = {1, 2, 4, 10, 11};
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(a1));
        lists.add(Arrays.asList(a2));
        lists.add(Arrays.asList(a3));
        System.out.println(merge(lists));
    }
}
