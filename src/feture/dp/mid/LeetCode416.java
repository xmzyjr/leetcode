package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode416 {
    
    boolean res;
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum/2;
        boolean[] res = new boolean[target+1];
        res[res.length - 1] = true;
        for (int j = nums.length - 1; j >= 0; j--) {
            for (int i = 0; i < target; i++) {
                if (i+nums[j]>target) {
                    break;
                }
                res[i] = res[i] || res[i + nums[j]];
            }
        }
        return res[0];
    }
    
    private boolean find(int[] nums, int target, int now, int index) {
        if (index == nums.length)
            return false;
        if (res)
            return true;
        if (now == target) {
            res = true;
            return true;
        } else if (now > target)
            return false;
        return find(nums, target, now + nums[index], index+1) || find(nums, target, now, index+1);
    }

    public static void main(String[] args) {
        LeetCode416 l = new LeetCode416();
        l.canPartition(new int[]{23,13,11,7,6,5,5});
    }
}
