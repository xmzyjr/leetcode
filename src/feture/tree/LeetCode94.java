package feture.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(root.val);
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode temp = root;
        stack.push(temp);
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                if (temp.left != null) {
                    stack.push(temp.left);
                }
                temp = temp.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                    temp = pop.right;
                }
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        LeetCode94 l = new LeetCode94();
        System.out.println(l.inorderTraversal(node1));
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(root.val);
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        return result;
    }
}
