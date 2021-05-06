package feture.offer;

/**
 * @author lanshan
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return num;
    }
}
