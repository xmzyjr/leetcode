package feture.offer;

/**
 * @author lanshan
 */
public class Offer36 {

    static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        head = pre = null;
        find(root);
        dealTail(head);
        return head;
    }

    private void dealTail(Node node) {
        Node temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = head;
        head.left = temp;
    }

    private void find(Node n) {
        if (n == null) {
            return;
        }
        Node tl = n.left, tr = n.right;
        find(tl);
        if (head == null) {
            head = n;
        }
        if (pre != null) {
            pre.right = n;
            n.left = pre;
        }
        pre = n;
        find(tr);
    }

    public static void main(String[] args) {
        Offer36 o = new Offer36();
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node1.right = node2;
        o.treeToDoublyList(node1);

    }
}
