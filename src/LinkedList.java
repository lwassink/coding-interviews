import sun.awt.image.ImageWatched;

import java.util.Iterator;

/**
 * Created by lwassink on 6/12/17.
 */
public class LinkedList<T> implements Iterable<T> {
    T data;
    LinkedList<T> next = null;

    public LinkedList(T d) {
        data = d;
    }

    public void insertAfter(LinkedList<T> node) {
        node.next = next;
        next = node;
    }

    public void deleteNext() {
        if (next != null) next = next.next;
    }

    public LinkedList<T> search(T key) {
        LinkedList<T> cur = this;
        while (cur != null && cur.data != key) cur = cur.next;
        return cur;
    }

    public Iterator<T> iterator() {
        return new NodeIter(this);
    }

    private class NodeIter implements Iterator<T> {
        LinkedList<T> cur;

        public NodeIter(LinkedList<T> node) {
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

    public LinkedList<T> cycleNode() {
        LinkedList<T> fast = this, slow = this;
        while (fast != null) {
            fast = fast.next;
            if (fast == slow) return fast;
            if (fast == null) break;
            fast = fast.next;
            slow = slow.next;
            if (fast.data == slow.data) return fast;
        }
        return null;
    }

    public boolean
}
