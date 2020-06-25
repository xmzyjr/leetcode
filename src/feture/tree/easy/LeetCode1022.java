package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode1022 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        private static final int mod = 1000000000 + 7;
        private int result = 0;
        public int sumRootToLeaf(TreeNode root) {
            if (root == null)
                return 0;
            find(root, 0);
            return result;
        }

        private void find(TreeNode root, int sum) {
            if (root.left == null && root.right == null) {
                result += ((sum<<1) + root.val) % mod;
                return;
            }
            sum = ((sum<<1) + root.val) % mod;
            if (root.left != null)
                find(root.left, sum);
            if (root.right!=null)
                find(root.right, sum);
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            TreeNode root1 = new TreeNode(0);
            TreeNode root2 = new TreeNode(1);
            TreeNode root3 = new TreeNode(0);
            TreeNode root4 = new TreeNode(1);
            TreeNode root5 = new TreeNode(0);
            TreeNode root6 = new TreeNode(1);

            root.left = root1;
            root.right = root2;

            root1.left = root3;
            root1.right = root4;

            root2.left = root5;
            root2.right = root6;

            Solution s = new Solution();
            System.out.println(s.sumRootToLeaf(root));
        }

    }
}
