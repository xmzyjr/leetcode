package feture.offer;

/**
 * @author lanshan
 */
public class Offer26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *     3
     *    / \
     *   4  5
     *  / \
     * 1  2
     * 给定的树 B：
     *
     *   4
     *  /
     * 1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * 限制：
     *
     * 0 <= 节点个数 <= 10000
     */
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean all;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        all = false;
        find(A, B, B);
        return all;
    }

    private boolean find(TreeNode a, TreeNode b, TreeNode bRoot) {
        if (all) {
            return true;
        }
        if (b == null)
            return true;
        if (a == null)
            return false;
        boolean left, right;
        if (a.val == b.val) {
            left = find(a.left, b.left, bRoot);
            right = find(a.right, b.right, bRoot);
        } else {
            left = find(a.left, bRoot, bRoot);
            right = find(a.right, bRoot, bRoot);
        }
        if (b == bRoot) {
            all = all || (left && right);
        }
        return left && right;
    }
}
