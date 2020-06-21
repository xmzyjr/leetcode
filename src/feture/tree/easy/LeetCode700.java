package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode700 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        TreeNode result;
        public TreeNode searchBST(TreeNode root, int val) {
            result = null;
            find(root, val);
            return result;
        }

        private void find(TreeNode root, int val) {
            if (root == null || result != null)
                return;
            if (root.val == val) {
                result = root;
                return;
            }
            find(root.left, val);
            find(root.right, val);
        }
    }
}
