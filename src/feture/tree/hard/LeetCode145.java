
package feture.tree.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(root.val);
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root);
        while (!left.isEmpty()) {
            TreeNode pop = left.pop();
            if (pop.left!=null) {
                left.push(pop.left);
            }
            if (pop.right!=null) {
                left.push(pop.right);
            }
            right.push(pop);
        }
        List<Integer> result = new ArrayList<>();
        while (!right.isEmpty()) {
            result.add(right.pop().val);
        }
        return result;
    }

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
