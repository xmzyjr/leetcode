package feture.binary.search.middle;

/**
 * @author lanshan
 */
public class LeetCode1111 {
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            if (seq == null || seq.length() == 0)
                return new int[0];
            int[] nums = new int[seq.length()];
            for (int i = 0; i < seq.length(); i++) {
                if (i == 0) {
                    nums[i]=0;
                    continue;
                }
                nums[i] = seq.charAt(i) == seq.charAt(i-1)?nums[i-1] ^ 1:nums[i-1];
            }
            return nums;
        }
    }
}
