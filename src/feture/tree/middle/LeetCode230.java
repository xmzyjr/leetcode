package feture.tree.middle;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null || k == 0)
                return 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            while (!stack.isEmpty() || temp!=null) {
                if (temp!=null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                     temp = stack.pop();
                     if (--k == 0) {
                         return temp.val;
                     }
                     temp = temp.right;
                }
            }
            return 0;
        }
    }
}
