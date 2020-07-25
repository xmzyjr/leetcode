
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode413 {

    class Solution {

        public int numberOfArithmeticSlices(int[] A) {
            if (A == null || A.length < 3)
                return 0;
            int left = 0, right = 1;
            int d = A[right] - A[left];
            int count = 0;
            while (left < right) {
                ++right;
                if (right >= A.length) {
                    break;
                }
                int tempD = A[right] - A[right-1];
                if (tempD == d) {
                    continue;
                }
                int n = right - left;
                if (n < 3) {
                    left++;
                } else {
                    count += (n - 1) * (n - 2) / 2;
                    left = right - 1;
                }
                right = left + 1;
                d = A[right] - A[left];
            }
            int n = right - left;
            if (right - left >= 3) {
                count += (n - 1) * (n - 2) / 2;
            }
            return count;
        }
    }
}
