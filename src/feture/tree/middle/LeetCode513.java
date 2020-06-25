package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int maxLevel;
        int result;
        public int findBottomLeftValue(TreeNode root) {
            if (root == null)
                return 0;
            maxLevel = 0;
            result = root.val;
            find(root, 0);
            return result;
        }

        private void find(TreeNode root, int level) {
            if (root == null)
                return;
            if (level > maxLevel) {
                maxLevel = level;
                result = root.val;
            }
            find(root.left, level + 1);
            find(root.right, level + 1);
        }
    }
}
