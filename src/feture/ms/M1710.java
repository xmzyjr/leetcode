package feture.ms;

/**
 * @author lanshan
 */
public class M1710 {
    /**
     * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     *
     * 示例 1：
     *
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     *  
     *
     * 示例 2：
     *
     * 输入：[3,2]
     * 输出：-1
     *  
     *
     * 示例 3：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *  
     *
     * 说明：
     * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
     */
    public int majorityElement(int[] nums) {
        Integer res = null;
        int count = 0;
        for (int num : nums) {
            if (res == null) {
                res = num;
                count = 1;
            } else {
                if (num == res) {
                    count++;
                } else {
                    --count;
                    if (count == 0)
                        res = null;
                }
            }
        }
        if (res != null) {
            int t = nums.length / 2 + 1;
            int t1 = 0;
            for (int num : nums) {
                if (num == res)
                    t1++;
            }
            if (t1 >= t)
                return res;
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        M1710 m = new M1710();
        System.out.println(m.majorityElement(new int[] {1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(m.majorityElement(new int[] {3,2}));
        System.out.println(m.majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
