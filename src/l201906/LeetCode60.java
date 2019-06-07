
package l201906;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode60 {

    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     * 康托展开：k=A(n-1)*(n-1)! + A(n-2)*(n-2)!+...+A0*0!
     */
    public String getPermutation(int n, int k) {
        boolean[] check = new boolean[n];
        return get(check, k, n);
    }

    public String get(boolean[] check, int k, int n) {
        k--;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int di = device(n);
            int index = k / di;
            sb.append(check(check, index));
            k = k - index * di;
        }
        return sb.toString();
    }

    public int device(int n) {
        int sum = 1;
        for (int i = n; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }

    public int check(boolean[] num, int index) {
        for (int i = 0; i < num.length; i++) {
            if (!num[i]) {
                if (--index < 0) {
                    num[i] = true;
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode60 l = new LeetCode60();
        System.out.println(l.getPermutation(3, 2));
    }
}
