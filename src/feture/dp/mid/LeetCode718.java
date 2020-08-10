package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode718 {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1] 。
     *  
     *
     * 提示：
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     */

    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        return find(A,B,0,0);
    }

    private int find(int[] a, int[] b, int index1, int index2) {
        if (index1>=a.length || index2>=b.length)
            return 0;
        if (a[index1]!=b[index2]) {
            return Math.max(find(a, b, index1 + 1, index2), find(a, b, index1, index2+1));
        } else {
            return Math.max(Math.max(find(a, b, index1 + 1, index2), find(a, b, index1, index2 + 1)),
                    find(a, b, index1 + 1, index2 + 1)+1);
        }
    }

    public int findLength2(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        int[][] num = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = num.length - 2; i >= 0; i--) {
            for (int j = num[i].length - 2; j >= 0; j--) {
                num[i][j] = A[i] == B[j] ? num[i + 1][j + 1] + 1 : 0;
                res = Math.max(res, num[i][j]);
            }
        }
        return res;
    }
}
