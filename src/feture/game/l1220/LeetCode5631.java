package feture.game.l1220;

/**
 * @author lanshan
 */
public class LeetCode5631 {
    public int maxResult(int[] nums, int k) {
        return find(nums, 0, k);
    }

    private Integer find(int[] nums, int index, int size) {
        if (index > nums.length-1) {
            return null;
        }
        if (index == nums.length-1) {
            return nums[index];
        }
        Integer max = null;
        for (int i = 1; i <= size ; i++) {
            Integer num = find(nums, index + i, size);
            if (num == null)
                break;
            max = max == null ? num : Math.max(max, num);
        }
        return max + nums[index];
    }

    public static void main(String[] args) {
        LeetCode5631 l = new LeetCode5631();
        System.out.println(l.maxResult(new int[] {1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }
}
