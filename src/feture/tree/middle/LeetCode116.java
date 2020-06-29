package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return null;
            Node a,b,c;
            a = root;
            c = b = a.left;
            while (c != null) {
                a.left.next = a.right;
                if (a.next == null) {
                    a = c;
                    b = c.left;
                    c = b;
                } else {
                    a = a.next;
                    b = b.next;
                    b.next = a.left;
                    b = b.next;
                }
            }
            return root;
        }
    }
}
