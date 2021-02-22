package feture.ms;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lanshan
 */
public class M1625 {
    /**
     * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。
     * 当缓存被填满时，它应该删除最近最少使用的项目。
     *
     * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
     * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
     *
     *
     *
     * LRUCache cache = new LRUCache( 2 /* 缓存容量 );
     * cache.put(1, 1);
     * cache.put(2, 2);
     * cache.get(1);       // 返回  1
     * cache.put(3, 3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4, 4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     * 
     **/
    static class LRUCache {

        public static void main(String[] args) {
            LRUCache l = new LRUCache(2);
            l.put(1,1);
            l.put(2,2);
            l.get(1);
            l.put(3,3);
            l.get(2);
            l.put(4,4);
            l.get(1);
            l.get(3);
            l.get(4);
        }

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
            Node node = new Node(key, value);
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
