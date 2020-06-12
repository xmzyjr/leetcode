package feture.daily;

/**
 * @author lanshan
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        return find(0, n);
    }

    private int find(int level, int total) {
        if (level == total)
            return 1;
        if (level > total)
            return 0;
        return find(level + 1, total) + find(level + 2, total);
    }
    
    private int find2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] sum = new int[n + 1];
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }

    public static void main(String[] args) {
        LeetCode70 l = new LeetCode70();
        System.out.println(l.climbStairs(4));
        System.out.println(l.find2(4));
    }
}
