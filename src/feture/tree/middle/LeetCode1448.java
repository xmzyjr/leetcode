package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1448 {
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
        public int goodNodes(TreeNode root) {
            return find(root, Integer.MIN_VALUE);
        }
        
        private int find(TreeNode root, int max) {
            if (root == null)
                return 0;
            int count = root.val >= max ? 1 : 0;
            max = Math.max(root.val, max);
            int left = find(root.left, max);
            int right = find(root.right, max);
            return count + left + right;
        }
    }
}
