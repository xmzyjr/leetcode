package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode852 {
    class Solution {

        public int peakIndexInMountainArray(int[] A) {
            if (A == null || A.length == 0)
                return -1;
            int left = 0, right = A.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                } else if (A[mid] < A[mid - 1]) {
                    right = mid - 1;
                } else if (A[mid] < A[mid + 1]) {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
