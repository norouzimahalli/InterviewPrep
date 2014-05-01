package interview.prep;

import java.util.HashMap;

/**
 * Created by Adunuthula on 4/13/2014.
 * LRUCache Implementation using a Hashmap and Custom LinkedList
 */
public class LRUCache<T> {

    private HashMap<String, DLLNode>map = new HashMap<String, DLLNode>();
    private DLLNode<T> head = null;
    private DLLNode<T> tail = null;
    private int cacheSize;

    static class DLLNode<T> {
        String key;
        T elem;
        DLLNode next;
        DLLNode prev;

        public static DLLNode add(DLLNode head, DLLNode node) {
            node.next = head;
            head.prev = node;
            return node;
        }

        public static DLLNode remove(DLLNode tail) {
            tail.prev.next = null;
            return tail.prev;
        }

        public static DLLNode removeAt(DLLNode node) {
            if (node == null)
                return null;

            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            return node;
        }

    }

    public LRUCache(int size) {
        cacheSize = size;
    }

    public int size() {
        return map.size();
    }

    public T get(String key) {
        DLLNode<T> node = map.get(key);
        if (node == null) {
            return null;
        }

        DLLNode.removeAt(node);
        head = DLLNode.add(head, node);
        return node.elem;
    }

    public void put(String key, T val) {
        DLLNode<T>node = map.get(key);
        if (node == null) {
            System.out.println("Adding key " + key);
            node = new DLLNode<T>();
            node.key = key;
            node.elem = val;
            node.next = null;
            node.prev = null;

            if (map.size() >= cacheSize) {
                System.out.println("Size Limit Reached, removing key " + tail.key);
                map.remove(tail.key);
                tail = DLLNode.remove(tail);
            }
        } else {
            DLLNode.removeAt(node);
            node.elem = val;
        }

        if (head == null) {
            System.out.println("Addind head, tail " + key);
            head = node;
            tail = node;
        } else {
            System.out.println("Moved key to front " + node.key);
            head = DLLNode.add(head, node);
        }

        map.put(key, node);
    }


    public void print() {
        DLLNode<T> node = head;

        while (node != null) {
            System.out.print(" " + node.elem);
            node = node.next;
        }
        System.out.println("\n");
    }
}
