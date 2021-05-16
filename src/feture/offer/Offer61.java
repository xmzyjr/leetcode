package feture.offer;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class Offer61 {
    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5]
     * 输出: True
     *
     * 示例 2:
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 限制：
     *
     * 数组长度为 5
     *
     * 数组的数取值为 [0, 13] .
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        int count = 0;
        for (int num : nums) {
            count = num == 0 ? ++count : count;
        }
        Arrays.sort(nums);
        boolean isStart = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (isStart) {
                    isStart = false;
                } else {
                    int t = nums[i] - nums[i - 1] - 1;
                    if (t > count || t < 0)
                        return false;
                    count -= t;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Offer61 o = new Offer61();
        System.out.println(o.isStraight(new int[] {0, 0, 1, 2, 5}));
    }
}
