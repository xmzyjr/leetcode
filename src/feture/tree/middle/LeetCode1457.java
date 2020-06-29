package feture.tree.middle;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1457 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public int pseudoPalindromicPaths(TreeNode root) {
            int[] num = new int[9];
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 1;
            return find(root, num);
        }

        private int find(TreeNode root, int[] num) {
            if (root.left == null && root.right == null) {
                num[root.val - 1]++;
                return check(num) ? 1 : 0;
            }
            num[root.val - 1]++;
            int left = 0, right = 0;
            if (root.left != null)
                left = find(root.left, Arrays.copyOf(num, num.length));
            if (root.right != null)
                right = find(root.right, Arrays.copyOf(num, num.length));
            return left + right;
        }

        private boolean check(int[] num) {
            int res = 0;
            for (int value : num) {
                res += (value & 1);
            }
            return res <= 1;
        }
    }
}
