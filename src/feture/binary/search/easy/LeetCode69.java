package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode69 {
    static class Solution {

        public int mySqrt(int x) {
            // n - x/n == 0
            double n = x;
            while (n - x * 1.0 / n > 1e-7) {
                n = (n + x * 1.0 / n) * 0.5;
            }
            System.out.println(n);
            return (int) n;
        }

        public static void main(String[] args) {
            Solution l = new Solution();
            l.mySqrt(2147395599);
            System.out.println(Math.sqrt(2147395599));
        }
    }
}
