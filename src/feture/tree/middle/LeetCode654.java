package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return find(nums, 0, nums.length - 1);
    }
    
    private TreeNode find(int[]nums, int left, int right) {
        if (right < left)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = findIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = find(nums, left, mid-1);
        root.right = find(nums, mid+1, right);
        return root;
    }
    
    private int findIndex(int[] nums, int left, int right) {
        int max = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }
}
