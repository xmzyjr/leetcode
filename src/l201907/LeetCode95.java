
package l201907;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode95 {

    private class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     *
     * 示例:
     *
     * 输入: 3
     * 输出:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释:
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return get(1, n);
    }

    public List<TreeNode> get(int start, int end) {
        List<TreeNode> all = new ArrayList<>();
        if (start > end) {
            all.add(null);
            return all;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = get(start, i - 1);
            List<TreeNode> right = get(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode now = new TreeNode(i);
                    now.left = l;
                    now.right = r;
                    all.add(now);
                }
            }
        }
        return all;
    }
}
