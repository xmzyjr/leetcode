package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || temp!=null) {
            if (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        System.out.println(result);
        boolean valid = true;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i-1)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && root.val<=min) {
            return false;
        }
        if (max!=null && root.val>=max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
