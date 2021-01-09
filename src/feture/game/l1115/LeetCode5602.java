package feture.game.l1115;

/**
 * @author lanshan
 */
public class LeetCode5602 {
    
    private Integer[][] res;
    public int minOperations(int[] nums, int x) {
        res = new Integer[nums.length+1][nums.length+1];
        int i = find(nums, 0, nums.length - 1, x);
        if (i == Integer.MAX_VALUE)
            return -1;
        return i;
    }
    
    private int find(int[] nums, int left, int right, int target) {
        if (left>nums.length-1 || right<0)
            return Integer.MAX_VALUE;
        if (res[left][right] != null)
            return res[left][right];
        if (target == 0) {
            res[left][right] = 0;
            return 0;
        }
        if (left > right) {
            res[left][right] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        int l = find(nums, left + 1, right, target - nums[left]);
        int r = find(nums, left, right - 1, target - nums[right]);

        l = l == Integer.MAX_VALUE ? l : l + 1;
        r = r == Integer.MAX_VALUE ? r : r + 1;
        int min = Math.min(l, r);
        res[left][right] = min;
        return min;
    }

    private static class Node {
        public int ans;
        public int target;

        public Node(int ans, int target) {
            this.ans = ans;
            this.target = target;
        }
    }
    public int minOperations2(int[] nums, int x) {
        Node[][] res2 = new Node[nums.length][nums.length];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i]+sum[i-1];
        }
//        res2[0][nums.length-1] =
        return 0;
    }



    public static void main(String[] args) {
        LeetCode5602 l = new LeetCode5602();
        System.out.println(l.minOperations(new int[] {1, 1, 4, 2, 3}, 5));
        System.out.println(l.minOperations(new int[] {5,6,7,8,9}, 4));
        System.out.println(l.minOperations(new int[] {3,2,20,1,1,3}, 10));

    }
}
