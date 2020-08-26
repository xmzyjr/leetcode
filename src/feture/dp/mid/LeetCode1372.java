package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1372 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max;
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        max = 0;
        find(root);
        return max;
    }
    
    private int[] find(TreeNode root) {
        if (root == null)
            return null;
        int[] left = find(root.left);
        int[] right = find(root.right);
        if (left == null && right == null)
            return new int[]{0,0};
        if (left == null) {
            int rightValue = right[0] + 1;
            max = Math.max(max, rightValue);
            return new int[] { 0, rightValue };
        }
        if (right == null) {
            int leftValue = left[1] + 1;
            max = Math.max(max, leftValue);
            return new int[] { leftValue, 0 };
        }
        
        int leftValue =  left[1] + 1;
        int rightValue = right[0] + 1;
        max = Math.max(max, Math.max(leftValue, rightValue));
        return new int[] { leftValue, rightValue };
    }
}
