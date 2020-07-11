package feture.dp.easy;

/**
 * @author lanshan
 */
public class LeetCode1025 {
    static class Solution {

        /**
         * 假设 g(N) 为结果, f(x,N) x为可以整除N的除数
         * 那么 g(N) = f(1,N)|....|f(x,N) = !g(N-1)|....|!g(N-x)
         *
         * g(1) = false
         * g(2) = true
         * g(3) = false
         *
         * g(4) = f(1,4)|f(2,4) = !g(3) | !g(2) = true | false = true
         * g(5) = f(1,5) = !g(4) = false
         *
         * 以此类推，偶数为true, 奇数为 false。
         * 同时可以得出结论，奇数减去能整除它的除数，结果都是偶数。
         *
         */
        public boolean divisorGame(int N) {
            return (N & 1) == 0;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.divisorGame(2));
        }
    }
}
