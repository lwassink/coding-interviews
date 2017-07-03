import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by lwassink on 6/12/17.
 */
public class Node<T> implements Iterable<T> {
    T data;
    Node<T> next = null;

    public Node(T d) {
        data = d;
    }

    public void insertAfter(Node<T> node) {
        node.next = next;
        next = node;
    }

    public boolean hasNext() {
        return (this.next != null);
    }

    public void deleteNext() {
        if (next != null) next = next.next;
    }

    public Node<T> search(T key) {
        Node<T> cur = this;
        while (cur != null && cur.data != key) cur = cur.next;
        return cur;
    }

    public Iterator<T> iterator() {
        return new NodeIter(this);
    }

    private class NodeIter implements Iterator<T> {
        Node<T> cur;

        public NodeIter(Node<T> node) {
            cur = node;
        }

        public boolean hasNext() {
            return (cur.next != null);
        }

        public T next() {
            T data = cur.data;
            cur = cur.next;
            return data;
        }
    }

    public Node<T> cycleNode() {
        Node<T> fast = this, slow = this;
        while (fast.hasNext()) {
            fast = fast.next;
            if (fast == slow) return fast;
            if (fast == null) break;
            fast = fast.next;
            slow = slow.next;
            if (fast.data == slow.data) return fast;
        }
        return null;
    }

    public static List<Integer> sum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Integer carry = 0;
        Iterator<Integer> i1 = list1.iterator(), i2 = list2.iterator();
        List<Integer> result = new LinkedList<>();

        while(i1.hasNext() || i2.hasNext()) {
            Integer n1 = 0, n2 = 0;
            if (i1.hasNext()) n1 = i1.next();
            if (i2.hasNext()) n2 = i2.next();

            Integer curSum = n1 + n2 + carry;
            result.add(curSum % 10);
            carry = curSum / 10;
        }

        if (carry > 0) result.add(carry);
        return result;
    }

    public Node<T> findLoop() {
        Node<T> n1 = this, n2 = this;

        while (n1 != n2 && n1.hasNext()) {
            n2 = n2.next;
            if (!n1.next.hasNext()) return null;
            n1 = n1.next.next;
        }
        
        n2 = n2.next;
        int len = (n1 == n2) ? 0 : 1;
        while (n1 != n2) {
            len++;
            n2 = n2.next;
        }

        n1 = this; n2 = this;
        while (len > 0) {
            len--;
            n1 = n1.next;
        }

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}
