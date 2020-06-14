package feture.game;

/**
 * @author lanshan
 */
public class LeetCode5436 {


    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int[] result = new int[nums.length];
        int temp = nums[0];
        result[0] = temp;
        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            result[i] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode5436 l = new LeetCode5436();
        int[] ints = l.runningSum(new int[] {1, 2, 3, 4});
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
