package feture.tree.easy;

import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return find(root);
    }

    private int find(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, find(child));
        }
        return max+1;
    }
}










