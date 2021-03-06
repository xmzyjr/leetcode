package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return find(root, 0);
    }

    private int find(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int left = find(root.left, level + 1);
        int right = find(root.right, level + 1);
        return Math.max(left, right);
    }
    
    private int find2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(find2(root.left), find2(root.right)) + 1;
    }
}
