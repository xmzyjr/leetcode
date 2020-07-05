
package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class Offer11 {

    class Solution {
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length == 0)
                return -1;
            int left = 0, right = numbers.length - 1;
            if (left == right) {
                return numbers[left];
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            return numbers[left];
        }
    }
}
