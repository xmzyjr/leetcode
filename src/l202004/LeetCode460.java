package l202004;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode460 {

    public static class Node {
        public Integer key;
        public Integer value;
        public Integer freq;

        public Node pre;
        public Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> keyMap;
    Map<Integer, LinkedList<Node>> freqMap;
    Integer minFreq;
    int size;
    
    public LeetCode460(int capacity) {
        keyMap = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (size ==0) {
            return -1;
        }
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        adjustFreq(node);
        return node.value;
    }

    private void adjustFreq(Node node) {
        Integer freq = node.freq;
        LinkedList<Node> originFreq = freqMap.get(freq);
        originFreq.remove(node);
        if (minFreq.equals(freq) && originFreq.size() == 0) {
            minFreq = freq + 1;
        }
        LinkedList<Node> nodes = freqMap.get(freq + 1);
        if (nodes == null) {
            nodes = new LinkedList<>();
        }
        nodes.addFirst(node);
        node.freq = freq + 1;
        freqMap.put(freq + 1, nodes);
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            adjustFreq(node);
        } else if (keyMap.size() != 0 && keyMap.size() == size) {
            LinkedList<Node> nodes = freqMap.get(minFreq);
            Node node = nodes.pollLast();
            assert node != null;
            keyMap.remove(node.key);
            addMinFreqNode(key, value);
        } else {
            addMinFreqNode(key, value);
        }
    }
    
    private void addMinFreqNode(int key, int value) {
        Node node = new Node(key, value);
        node.freq = 1;
        keyMap.put(key, node);
        LinkedList<Node> nodes = freqMap.get(1);
        if (nodes == null) {
            nodes = new LinkedList<>();
        }
        nodes.addFirst(node);
        minFreq = 1;
        freqMap.put(1, nodes);
    }

    public static void main(String[] args) {
        LeetCode460 l = new LeetCode460(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
        l.get(3);
        l.put(4,4);
        l.get(1);
        l.get(3);
        l.get(4);
    }
}
