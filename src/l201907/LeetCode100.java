package l201907;

/**
 * @author lanshan
 */
public class LeetCode100 {
    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * 输出: true
     * 示例 2:
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * 输出: false
     * 示例 3:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * 输出: false
     */
    private class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = false, right = false;
        if (p.left != null && q.left != null) {
            left = isSameTree(p.left, q.left);
        } else if (p.left != null || q.left != null) {
            return false;
        } else {
            left = true;
        }
        if (p.right != null && q.right != null) {
            right = isSameTree(p.right, q.right);
        } else if (p.right != null || q.right != null) {
            return false;
        } else {
            right = true;
        }
        return left && right;
    }
    
    
}
