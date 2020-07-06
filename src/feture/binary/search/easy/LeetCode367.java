
package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode367 {

    static class Solution {

        public boolean isPerfectSquare(int num) {
            int left = 1, right = num;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                float n = (float) num / mid;
                if (mid == n) {
                    return true;
                } else if (n > mid) {
                    left = mid +1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode367.Solution l = new LeetCode367.Solution();
        System.out.println(l.isPerfectSquare(2147395600));

        System.out.println(Math.sqrt(2147395600));
    }
}
