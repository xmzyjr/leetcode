package feture.bd;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class LRU {

    class LRUCache {

        class Node {

            int key, value;

            Node next;

            Node pre;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Integer removeNode(int key) {
            Integer value;
            if (head.key == key) {
                value = head.value;
                removeHead();
                return value;
            }
            if (tail.key == key) {
                value = tail.value;
                removeTail();
                return value;
            }
            Node temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    value = temp.value;
                    Node pre = temp.pre;
                    Node next = temp.next;
                    pre.next = next;
                    next.pre = pre;
                    temp.next = null;
                    temp.pre = null;
                    return value;
                }
                temp = temp.next;
            }
            return -1;
        }

        void removeHead() {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
        }

        void removeTail() {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
        }

        void addHead(int key, int value) {
            Node node = new LRUCache.Node(key, value);
            node.next = head;
            if (head != null)
                head.pre = node;
            head = node;
            if (tail == null)
                tail = head;
        }

        Set<Integer> keySet;

        int capacity;

        Node head;

        Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keySet = new HashSet<>(capacity);
        }

        public int get(int key) {
            if (!keySet.contains(key))
                return -1;
            Integer value = removeNode(key);
            addHead(key, value);
            return value;
        }

        public void put(int key, int value) {
            if (keySet.contains(key)) {
                removeNode(key);
                addHead(key, value);
            } else {
                int size = keySet.size();
                if (size == capacity) {
                    keySet.remove(tail.key);
                    removeTail();
                }
                addHead(key, value);
                keySet.add(key);

            }
        }
    }

}
