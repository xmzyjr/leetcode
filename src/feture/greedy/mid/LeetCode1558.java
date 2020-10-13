package feture.greedy.mid;

/**
 * @author lanshan
 */
public class LeetCode1558 {

    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            while (num != 0) {
                if ((num & 1) != 0) {
                    count++;
                }
                num >>= 1;
            }
        }
        if (max != 0) {
            while (max != 0) {
                count++;
                max >>= 1;
            }
            count--;
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode1558 l = new LeetCode1558();
        System.out.println(l.minOperations(new int[] {1,5}));
        System.out.println(l.minOperations(new int[] {2,2}));
        System.out.println(l.minOperations(new int[] {4,2,5}));
        System.out.println(l.minOperations(new int[] {3, 2, 2, 4}));
        System.out.println(l.minOperations(new int[] {2,4,8,16}));
    }
}
