package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1325 {
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
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null)
                return null;
            TreeNode left = removeLeafNodes(root.left, target);
            TreeNode right = removeLeafNodes(root.right, target);
            root.left = left;
            root.right = right;
            if (left == null && right == null && root.val == target) {
                return null;
            }
            return root;
        }
    }
}