package feture.tree.hard;

/**
 * @author lanshan
 */
public class LeetCode124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int max;
        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            if (root == null)
                return max;
            find(root);
            return max;
        }

        private Integer find(TreeNode root) {
            if (root == null)
                return null;
            Integer left = find(root.left);
            Integer right = find(root.right);
            int result = root.val;
            int temp = result;
            if (left != null && left > 0) {
                temp += left;
            }
            if (right != null && right > 0) {
                temp += right;
            }
            if (temp > max) {
                max = temp;
            }
            if (left != null && right == null && left > 0) {
                result += left;
            } else if (left == null && right != null && right > 0) {
                result += right;
            } else if (left != null && right != null) {
                result = Math.max(Math.max(result, result + left), result + right);
            }
            return result;
        }

    }
}
