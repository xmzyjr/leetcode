
package l201908;

/**
 * @author lanshan
 */
public class LeetCode116 {

    private static class Node {

        public int val;

        public Node left;

        public Node right;

        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        root.left.next = root.right;
        fix(root.left);
        fix(root.right);
        return root;
    }

    public void fix(Node root) {
        if (root.left == null && root.right == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        fix(root.left);
        fix(root.right);
    }
}
