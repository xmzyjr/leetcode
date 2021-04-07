package feture.offer;

/**
 * @author lanshan
 */
public class Offer56 {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     *
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     *  
     *
     * 限制：
     *
     * 2 <= nums.length <= 10000
     */
    public int[] singleNumbers(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t ^= num;
        }
        int i = 1;
        while ((t & i) == 0) {
            i = i << 1;
        }
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & i) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
