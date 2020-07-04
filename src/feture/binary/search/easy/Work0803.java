package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class Work0803 {

    class Solution {
        public int findMagicIndex(int[] nums) {
            if (nums == null || nums.length == 0)
                return -1;
            int index = 0;
            while (index < nums.length) {
                if (nums[index] == index)
                    return index;
                else if (nums[index]>index) {
                    index = nums[index];
                } else {
                    index ++;
                }
            }
            return -1;
        }
    }
}
