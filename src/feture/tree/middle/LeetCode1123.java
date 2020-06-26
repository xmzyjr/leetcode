package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1123 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int maxLevel;
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            maxLevel = getMax(root);
            return find(root, 1);
        }
        
        private int getMax(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(getMax(root.left), getMax(root.right)) + 1;
        }

        private TreeNode find(TreeNode root, int level) {
            if (root == null)
                return null;
            TreeNode left = find(root.left, level + 1);
            TreeNode right = find(root.right, level + 1);
            if ((left == null && right == null) && level == maxLevel) {
                return root;
            }
            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            return right;
        }
    }
}
