package feture.tree.easy;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            TreeNode head = null, result = null;
            if (root == null)
                return head;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            while (!stack.isEmpty() || temp!=null) {
                if (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                    temp = stack.pop();
                    if (head == null) {
                        result = head = temp;
                    } else {
                        head.left = null;
                        head.right = temp;
                        head = head.right;
                    }
                    temp = temp.right;
                }
            }
            return result;
        }
    }
}
