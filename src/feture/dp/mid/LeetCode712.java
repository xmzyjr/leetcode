
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode712 {

    static class Solution {

        /**
         * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
         * 示例 1:
         * 输入: s1 = "sea", s2 = "eat"
         * 输出: 231
         * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
         * 在 "eat" 中删除 "t" 并将 116 加入总和。
         * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
         * 示例 2:
         * 输入: s1 = "delete", s2 = "leet"
         * 输出: 403
         * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
         * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
         * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
         */
        public int minimumDeleteSum(String s1, String s2) {
            if (s1.equals(s2)) {
                return 0;
            }
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < s1.length(); i++) {
                sum1 += s1.charAt(i);
            }

            for (int i = 0; i < s2.length(); i++) {
                sum2 += s2.charAt(i);
            }

            int[][] res = new int[s2.length() + 1][s1.length() + 1];
            for (int i = s2.length() - 1; i >= 0; i--) {
                for (int j = s1.length() - 1; j >= 0; j--) {
                    int max = Math.max(res[i][j + 1], res[i + 1][j]);
                    if (s1.charAt(j) == s2.charAt(i)) {
                        res[i][j] = Math.max(max, s1.charAt(j) + res[i + 1][j + 1]);
                    } else {
                        res[i][j] = max;
                    }
                }
            }
            System.out.println(res[0][0]);
            return sum1 + sum2 - 2 * res[0][0];
        }

        /**
         * "ccaccjp"
         * "fwosarcwge"
         */
        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.minimumDeleteSum("ccaccjp", "fwosarcwge"));
        }

    }
}
