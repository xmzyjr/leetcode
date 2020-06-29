package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            if (root == null)
                return 0;
            return find(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        private int find(TreeNode root, int min, int max) {
            if (root == null) {
                return max - min;
            }
            if (root.val<min) {
                min = root.val;
            }
            if (root.val>max) {
                max = root.val;
            }
            return Math.max(find(root.left, min, max), find(root.right, min, max));
        }
    }
}
