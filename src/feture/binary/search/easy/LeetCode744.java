package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0, right = letters.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] == target) {
                    left = mid + 1;
                } else if (letters[mid] > target) {
                    right = mid - 1;
                } else if (letters[mid] < target) {
                    left = mid + 1;
                }
            }
            if (right <0 || left>=letters.length) {
                return letters[0];
            }
            return letters[left];
        }
    }
}
