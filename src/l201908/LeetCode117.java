
package l201908;

/**
 * @author lanshan
 */
public class LeetCode117 {

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
        Node temp = root;
        Node temp1 = null;
        Node temp2 = null;
        while (temp != null) {
            if (temp.left != null) {
                if (temp1 == null) {
                    temp1 = temp.left;
                    temp2 = temp1;
                } else {
                    temp2.next = temp.left;
                    temp2 = temp2.next;
                }
            }
            if (temp.right != null) {
                if (temp1 == null) {
                    temp1 = temp.right;
                    temp2 = temp1;
                } else {
                    temp2.next = temp.right;
                    temp2 = temp2.next;
                }
            }
            if (temp.next == null) {
                temp = temp1;
                temp1 = null;
            } else {
                temp = temp.next;
            }
        }
        return root;
    }

    public void fix(Node root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null)
            root.left.next = root.right;
        Node temp = root.next;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                temp = temp.next;
            } else {
                break;
            }
        }
        if (temp != null) {
            if (root.right != null) {
                if (temp.left != null) {
                    root.right.next = temp.left;
                } else {
                    root.right.next = temp.right;
                }
            } else {
                if (temp.left != null) {
                    root.left.next = temp.left;
                } else {
                    root.left.next = temp.right;
                }
            }
        }
        if (root.left != null)
            fix(root.left);
        if (root.right != null)
            fix(root.right);
    }
}
