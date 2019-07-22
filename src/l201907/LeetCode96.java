
package l201907;

/**
 * @author lanshan
 */
public class LeetCode96 {

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}
