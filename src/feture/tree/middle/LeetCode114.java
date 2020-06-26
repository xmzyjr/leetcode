package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode114 {
    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null)
                return;
            find(root);
        }
        
        private TreeNode find(TreeNode root) {
            if (root == null)
                return null;
            TreeNode left = find(root.left);
            TreeNode right = find(root.right);
            if (left != null) {
                root.right = left;
                root.left = null;
            }
            if (left != null && right != null) {
                TreeNode temp = root;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = right;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        LeetCode114.Solution l = new LeetCode114.Solution();
        LeetCode114.TreeNode root = new LeetCode114.TreeNode(1);
        LeetCode114.TreeNode root2 = new LeetCode114.TreeNode(2);
        LeetCode114.TreeNode root3 = new LeetCode114.TreeNode(5);
        LeetCode114.TreeNode root4 = new LeetCode114.TreeNode(3);
        LeetCode114.TreeNode root5 = new LeetCode114.TreeNode(4);
        LeetCode114.TreeNode root6 = new LeetCode114.TreeNode(6);


        root.left = root2;
        root.right = root3;

        root2.left = root4;
        root2.right = root5;

        root3.right = root6;

        l.flatten(root);
    }
}
