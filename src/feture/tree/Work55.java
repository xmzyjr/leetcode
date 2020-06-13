package feture.tree;

/**
 * @author lanshan
 */
public class Work55 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return find(root, 1);
    }
    
    private int find(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int left = find(root.left, level + 1);
        int right = find(root.right, level + 1);
        return Math.max(left, right);
    }
}
