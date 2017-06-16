/**
 * Created by lwassink on 6/14/17.
 */
import java.util.*;
import java.util.LinkedList;

public class QueueProblems {
    private static class Node {
        public Integer data;
        public Node left = null;
        public Node right = null;

        public Node(Integer data) {
            this.data = data;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(data);
            if (left != null)  {
                result.append(", ");
                result.append(left.toString());
            }
            if (right != null) {
                result.append(", ");
                result.append(right.toString());
            }
            return result.toString();
        }
    }

    public static List<List<Integer>> levels(Node tree) {
        Queue<Node> curQueue = new LinkedList<>();
        curQueue.add(tree);
        List<List<Integer>> levels = new ArrayList<>();

        while (!curQueue.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            Queue<Node> nextQueue = new LinkedList<>();

            while (!curQueue.isEmpty()) {
                Node x = curQueue.remove();
                if (x != null) {
                    nextQueue.add(x.left);
                    nextQueue.add(x.right);
                    thisLevel.add(x.data);
                }
            }

            curQueue = nextQueue;
            if (!thisLevel.isEmpty()) levels.add(thisLevel);
        }

        return levels;
    }

    public static List<List<Integer>> bottomUpLevels(Node tree) {
        Queue<Node> curQueue = new LinkedList<>();
        curQueue.add(tree);
        List<List<Integer>> levels = new ArrayList<>();

        while (!curQueue.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            Queue<Node> nextQueue = new LinkedList<>();

            while (!curQueue.isEmpty()) {
                Node x = curQueue.remove();
                if (x != null) {
                    nextQueue.add(x.left);
                    nextQueue.add(x.right);
                    thisLevel.add(x.data);
                }
            }

            curQueue = nextQueue;
            if (!thisLevel.isEmpty()) levels.add(thisLevel);
        }

        Collections.reverse(levels);
        return levels;
    }

    public static List<List<Integer>> alternateingLTR(Node tree) {
        boolean LTR = true;
        Deque<Node> curStack = new LinkedList<>();
        curStack.push(tree);
        List<List<Integer>> levels = new ArrayList<>();

        while (!curStack.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            Deque<Node> nextStack = new LinkedList<>();

            while (!curStack.isEmpty()) {
                Node x = curStack.pop();
                if (x != null) {
                    if (LTR) {
                        nextStack.push(x.left);
                        nextStack.push(x.right);
                    } else {
                        nextStack.push(x.right);
                        nextStack.push(x.left);
                    }
                    thisLevel.add(x.data);
                }
            }

            curStack = nextStack;
            if (!thisLevel.isEmpty()) levels.add(thisLevel);
            LTR = !LTR;
        }

        return levels;
    }

    public static List<Float> levelAverages(Node tree) {
        Queue<Node> curQueue = new LinkedList<>();
        curQueue.add(tree);
        List<Float> averages = new ArrayList<>();

        while (!curQueue.isEmpty()) {
            int count = 0;
            Integer sum = 0;
            Queue<Node> nextQueue = new LinkedList<>();

            while (!curQueue.isEmpty()) {
                Node x = curQueue.remove();
                if (x != null) {
                    nextQueue.add(x.left);
                    nextQueue.add(x.right);
                    sum += x.data;
                    count++;
                }
            }

            curQueue = nextQueue;
            if (count != 0) averages.add((float) sum/(float) count);
        }

        return averages;
    }

    public static void main(String[] args) {
        Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(8);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);
        tree.right.left = new Node(2);
        tree.right.right = new Node(3);
        tree.right.right.left = new Node(12);
        System.out.println(tree.toString());
        System.out.println(levels(tree));
        System.out.println(alternateingLTR(tree));
        System.out.println(levelAverages(tree));
    }
}
