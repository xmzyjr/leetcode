package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1315 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            return find(root, 0, 0);
        }

        private int find(TreeNode root, int father, int grandfather) {
            if (root == null) {
                return 0;
            }
            int left = find(root.left, root.val, father);
            int right = find(root.right, root.val, father);
            int result = left + right;
            if (grandfather != 0 && (grandfather & 1) == 0) {
                result += root.val;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(1&2);
        System.out.println(1&3);
    }
}
