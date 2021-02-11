package feture.ms;

/**
 * @author lanshan
 */
public class M1704 {
    /**
     * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
     *
     * 注意：本题相对书上原题稍作改动
     *
     * 示例 1：
     *
     * 输入：[3,0,1]
     * 输出：2
     *  
     *
     * 示例 2：
     *
     * 输入：[9,6,4,2,3,5,7,0,1]
     * 输出：8
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int total = (1 + nums.length) * nums.length / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

    public static void main(String[] args) {
        M1704 m = new M1704();
        System.out.println(m.missingNumber(new int[] {3, 0, 1}));
    }
}
