package feture.tree.easy;

/**
 * @author lanshan
 */
public class Work0402 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return find(nums, 0, nums.length-1);
    }
    
    private TreeNode find(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (end - start) / 2 + start;
        TreeNode m = new TreeNode(nums[mid]);
        m.left = find(nums, start, mid - 1);
        m.right = find(nums, mid+1, end);
        return m;
    }

    public static void main(String[] args) {
        Work0402 work0402 = new Work0402();
        work0402.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
