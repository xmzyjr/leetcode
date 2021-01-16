package feture.ms;

/**
 * @author lanshan
 */
public class M1001 {
    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     *
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     *
     * 示例:
     *
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * 说明:
     *
     * A.length == n + m
     */
    public void merge(int[] A, int m, int[] B, int n) {
        if (m <= 0 || n <= 0 || A == null || A.length == 0 || m > A.length || B == null || B.length == 0
                || n > B.length)
            return;
        int index1 = m - 1, index2 = n - 1;
        int temp = A.length - 1;
        while (temp >= 0) {
            if (index1 < 0) {
                A[temp--] = B[index2--];
            } else if (index2 < 0) {
                A[temp--] = A[index1--];
            } else {
                if (A[index1] > B[index2]) {
                    A[temp--] = A[index1--];
                } else {
                    A[temp--] = B[index2--];
                }
            }
        }
    }
}
