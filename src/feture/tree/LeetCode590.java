package feture.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode590 {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.children == null || root.children.size() == 0) {
            return Collections.singletonList(root.val);
        }
        Stack<Node> left = new Stack<>();
        Stack<Node> right = new Stack<>();
        left.push(root);
        while (!left.isEmpty()) {
            Node pop = left.pop();
            List<Node> children = pop.children;
            if (children!=null && children.size()!=0) {
                for (Node child : children) {
                    left.push(child);
                }
            }
            right.push(pop);
        }
        List<Integer> result = new ArrayList<>();
        while (!right.isEmpty()) {
            result.add(right.pop().val);
        }
        return result;
    }

    private static class Node {
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
}
