package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return 1 + left + right;
        }
    }
}
