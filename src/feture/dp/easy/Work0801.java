package feture.dp.easy;

/**
 * @author lanshan
 */
public class Work0801 {
    static class Solution {
        private final int mod = 1000000007;
        public int waysToStep(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n == 3) {
                return 4;
            }
            int[] num = new int[n];
            num[0] =1 ;
            num[1] = 2;
            num[2] = 4;
            for (int i = 3; i < n; i++) {
                int sum1 = (num[i - 1] + num[i - 2]) % mod;
                int sum = sum1 + num[i - 3];
                sum = sum % mod;
                num[i] = sum;
            }
            return num[n-1];
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.waysToStep(61));
        }
    }
}
