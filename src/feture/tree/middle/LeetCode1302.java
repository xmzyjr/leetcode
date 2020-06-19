package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1302 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxLevel = 0, max = 0;
    public int deepestLeavesSum(TreeNode root) {
        maxLevel = max = 0;
        if (root == null)
            return 0;
        find(root, 1);
        return max;
    }

    private void find(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            maxLevel = level;
            max = root.val;
        } else if (level == maxLevel) {
            max += root.val;
        }
        find(root.left, level+1);
        find(root.right, level+1);
    }

}
