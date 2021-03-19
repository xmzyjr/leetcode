package feture.ms;

/**
 * @author lanshan
 */
public class M0404 {
    /**
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     *
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *       1
     *      / \
     *     2   2
     *    / \
     *   3   3
     *  / \
     * 4   4
     * 返回 false 。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean check = false;
    public boolean isBalanced(TreeNode root) {
        check = false;
        find(root);
        return !check;
    }

    private int find(TreeNode root) {
        if (root == null)
            return 0;
        int left = find(root.left);
        int right = find(root.right);
        check |= Math.abs(left - right) > 1;
        return Math.max(left, right) + 1;
    }
}
