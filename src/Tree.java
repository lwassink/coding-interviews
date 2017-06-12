/**
 * Created by lwassink on 6/10/17.
 */
public class Tree {
    private Node root;

    public Tree(Node r) {
        root = r;
    }

    private static class Node {
        public Node right;
        public Node left;
        public int val;

        public Node(int v, Node l, Node r) {
            left = l;
            right = r;
            val = v;
        }

        public Node(int v) {
            left = null;
            right = null;
            val = v;
        }
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (lower > n.val) return false;
        if (upper < n.val) return false;
        return isBST(n.left, lower, n.val) && isBST(n.right, n.val, upper);
    }

    public static void main (String[] args) {
        Node good = new Node(5,
                new Node(3, new Node(2), new Node(4)),
                new Node(7, new Node(6), new Node (8))
        );

        Node bad1 = new Node(5,
                new Node(4, null, new Node(6)),
                null
        );

        Node bad2 = new Node(5,
                null,
                new Node(6, new Node(4), null)
        );

        Tree goodTree = new Tree(good);
        Tree badTree1 = new Tree(bad1);
        Tree badTree2 = new Tree(bad2);

        System.out.println(goodTree.isBST());
        System.out.println(badTree1.isBST());
        System.out.println(badTree2.isBST());
    }
}
