package feture.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class Offer56_2 {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer i = map.getOrDefault(num, 0);
            map.put(num, ++i);
        }
        for (Map.Entry<Integer, Integer> t : map.entrySet()) {
            if (t.getValue() == 1)
                return t.getKey();
        }
        return -1;
    }
}
