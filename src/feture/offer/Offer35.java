package feture.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        Node res = null, pre = null;
        Map<Node, Node> map = new HashMap<>();

        while (temp != null) {
            Node n = new Node(temp.val);
            map.put(temp, n);
            temp = temp.next;
            if (res == null)
                res = n;
            if (pre == null) {
                pre = n;
            } else {
                pre.next = n;
                pre = pre.next;
            }
        }

        temp = head;
        pre = res;
        System.out.println(res);
        while (temp != null) {
            if (temp.random == null) {
                pre.random = null;
            } else {
                pre.random = map.get(temp.random);
            }
            temp = temp.next;
            pre = pre.next;
        }

        return res;
    }
}
