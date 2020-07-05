package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0)
                return new int[0];
            int left = 0, right = numbers.length-1;
            while (left<right) {
                int num = numbers[left] + numbers[right];
                if (num == target) {
                    return new int[] { left + 1, right + 1 };
                } else if (num < target) {
                    left++;
                } else if (num > target) {
                    right--;
                }
            }
            return new int[0];
        }
    }
}
